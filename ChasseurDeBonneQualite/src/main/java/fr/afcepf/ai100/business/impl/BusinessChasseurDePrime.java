package fr.afcepf.ai100.business.impl;

import java.util.List;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

import fr.afcepf.ai100.business.api.IBusinessChasseurDePrime;
import fr.afcepf.ai100.dao.api.IDaoChasseurDePrime;
import fr.afcepf.ai100.dao.impl.DaoChasseurDePrime;
import fr.afcepf.ai100.entity.ChasseurDePrime;
import fr.afcepf.ai100.exception.ChasseurDejaExistantException;
import fr.afcepf.ai100.exception.ChasseurNonTrouve;

/**
 * Classe business pour le chasseur de prime.
 * @author Stagiaire
 *
 */
public class BusinessChasseurDePrime implements IBusinessChasseurDePrime {

    /**
     * Dao Chasseur.
     */
    private IDaoChasseurDePrime daoChasseur = new DaoChasseurDePrime();

    @Override
    public ChasseurDePrime ajouterChasseurDePrime(
            ChasseurDePrime pChasseurDePrime)
                    throws ChasseurDejaExistantException {
        List<ChasseurDePrime> chasseurs =
                daoChasseur.rechercherChasseurDePrimeParNom(
                        pChasseurDePrime.getNom());
        ChasseurDePrime chasseurRetourne = pChasseurDePrime;
        if (chasseurs.size() == 0) {
            chasseurRetourne =
                    daoChasseur.ajouterChasseurDePrime(pChasseurDePrime);
        } else {
            throw new ChasseurDejaExistantException("Chasseur existe déjà.");
        }
        return chasseurRetourne;
    }

    @Override
    public boolean supprimerChasseurDePrime(ChasseurDePrime pChasseurDePrime)
            throws ChasseurNonTrouve {
        boolean reussi = daoChasseur.supprimerChasseurDePrime(
                pChasseurDePrime.getIdChasseurDePrime());
        if (!reussi) {
            throw new ChasseurNonTrouve("Chasseur non trouvé");
        }
        return reussi;
        // TODO Auto-generated method stub
    }

    @Override
    public List<ChasseurDePrime> rechercherChasseurDePrimeParNom(String pNom) {
        List<ChasseurDePrime> chasseurs =
                daoChasseur.rechercherChasseurDePrimeParNom(pNom);
        return chasseurs;
    }

    @Override
    public List<ChasseurDePrime> rechercherChasseurDePrimeParTarif(
            float pTarifBas, float pTarifHaut) {
        List<ChasseurDePrime> chasseurs =
                daoChasseur.rechercherChasseurDePrimeParTarif(
                        pTarifBas, pTarifHaut);
        return chasseurs;
    }

    @Override
    public boolean tuerChasseur(ChasseurDePrime pChasseurDePrime)
            throws ChasseurNonTrouve {
       boolean reussi = daoChasseur.tuerChasseur(
               pChasseurDePrime.getIdChasseurDePrime());
       if (!reussi) {
           throw new ChasseurNonTrouve("Chasseur non trouvé");
       }
       return reussi;
    }

}
