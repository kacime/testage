package fr.afcepf.ai100.business.api;

import java.util.List;

import fr.afcepf.ai100.entity.ChasseurDePrime;
import fr.afcepf.ai100.entity.Equipement;
import fr.afcepf.ai100.exception.AttributionException;
import fr.afcepf.ai100.exception.EquipementInexistant;
import fr.afcepf.ai100.exception.EquipementMaxException;

/**
 * Interface proposant les m�thodes du business Equipement.
 *
 * @author Stagiaire
 *
 */
public interface IBusinessEquipement {

    /**
     * Permet d'attribuer un Equipement � un ChasseurDePrime si celui-ci ne
     * porte pas d�j� plus de trois �quipements.
     *
     * @param pEquipement
     *            l'Equipement a attribuer
     * @param pChasseurDePrime
     *            le ChasseurDePrime qui veut porter l'Equipement.
     * @return l'Equipement avec l'id de son pocesseur modifi�.
     * @throws EquipementMaxException
     *             lev�e si la capacit� maximum de portage du chasseur de prime
     *             est atteinte.
     * @throws AttributionException
     *             lev�e si l'attribution ne se passe pas correctement.
     */
    Equipement attribuerEquipement(Equipement pEquipement,
            ChasseurDePrime pChasseurDePrime)
            throws EquipementMaxException, AttributionException;

    /**
     * Permet de supprimer un �quipement.
     * @param pEquipement Equipement � supprimer.
     * @throws EquipementInexistant
     *          lev�e si l'�quipement n'existe pas.
     */
    void supprimerEquipement(Equipement pEquipement)
            throws EquipementInexistant;

    /**
     * Recherche des equipement par nom semblable.
     *
     * @param pNom
     *            : le nom ressemblant au nom des �quipements.
     * @return la liste des �quipements dont le nom match avec le pNom.
     */
    List<Equipement> rechercherEquipement(String pNom);



    /**
     * R�cup�re le nombre d'Equipement port�s par le ChasseurDePrime.
     *
     * @param pIdChasseurDePrime
     *            l'id du ChasseurDePrime dont on veut le nombre d'Equipement.
     * @return le nombre d'Equipement du chasseurDePrime.
     */
    int nbEquipement(int pIdChasseurDePrime);


}
