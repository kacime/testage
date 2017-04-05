package fr.afcepf.ai100.business.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.afcepf.ai100.business.api.IBusinessEquipement;
import fr.afcepf.ai100.dao.api.IDaoEquipement;
import fr.afcepf.ai100.dao.impl.DaoEquipement;
import fr.afcepf.ai100.entity.ChasseurDePrime;
import fr.afcepf.ai100.entity.Equipement;
import fr.afcepf.ai100.exception.AttributionException;
import fr.afcepf.ai100.exception.EquipementInexistant;
import fr.afcepf.ai100.exception.EquipementMaxException;

/**
 * Implémentation des règles de gestion des Equipements.
 *
 * @author Stagiaire
 *
 */
public class BusinessEquipement implements IBusinessEquipement {

    /**
     * Capacité maximum de portage d'Equipement.
     */
    protected static final int NOMBRE_EQUIPEMENT_MAX = 3;

    /**
     * Dao Equipement.
     */
    private IDaoEquipement daoEquipement = new DaoEquipement();

    /**
     * Getter du DAO.
     *
     * @return le DAO.
     */
    public IDaoEquipement getDaoEquipement() {
        return daoEquipement;
    }

    /**
     * Setter du Dao.
     *
     * @param pDaoEquipement
     *            le Dao.
     */
    public void setDaoEquipement(IDaoEquipement pDaoEquipement) {
        daoEquipement = pDaoEquipement;
    }

    @Override
    public Equipement attribuerEquipement(Equipement pEquipement,
            ChasseurDePrime pChasseurDePrime)
            throws EquipementMaxException, AttributionException {

        int nbEquipement = daoEquipement
                .nbEquipement(pChasseurDePrime.getIdChasseurDePrime());

        if (nbEquipement < NOMBRE_EQUIPEMENT_MAX) {
            boolean attribue = daoEquipement.attribuerEquipement(
                    pEquipement.getIdEquipement(),
                    pChasseurDePrime.getIdChasseurDePrime());

            if (attribue) {
                pEquipement.setIdChasseurDePrime(
                        pChasseurDePrime.getIdChasseurDePrime());
            } else {
                throw new AttributionException("Equipement non attribué");
            }
        } else {
            throw new EquipementMaxException(
                    "Nombre d'équipement maximum atteint");
        }
        return pEquipement;
    }

    @Override
    public void supprimerEquipement(Equipement pEquipement)
                    throws EquipementInexistant {
        boolean reussi =
                daoEquipement.supprimerEquipement(
                        pEquipement.getIdEquipement());
        if (!reussi) {
            throw new EquipementInexistant("Equipement inexistant");
        }
    }

    @Override
    public List<Equipement> rechercherEquipement(String pNom) {
        List<Equipement> equipements = daoEquipement.rechercherEquipement(pNom);
        return equipements;
    }



    @Override
    public int nbEquipement(int pIdChasseurDePrime) {
        int nb = daoEquipement.nbEquipement(pIdChasseurDePrime);
        return nb;
    }

}
