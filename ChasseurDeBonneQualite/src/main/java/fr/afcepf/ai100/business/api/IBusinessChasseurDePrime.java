package fr.afcepf.ai100.business.api;

import java.util.List;

import fr.afcepf.ai100.entity.ChasseurDePrime;
import fr.afcepf.ai100.exception.ChasseurDejaExistantException;
import fr.afcepf.ai100.exception.ChasseurNonTrouve;

/**
 * Interface proposant les m�todes du buisness ChasseurDePrime.
 * @author Stagiaire
 *
 */
public interface IBusinessChasseurDePrime {

    /**
     * Ajoute un chasseur de prime dans la bdd.
     *
     * @param pChasseurDePrime
     *            le chasseur de prime � ajouter.
     * @return le chasseur de prime avec son id g�n�r�.
     * @throws ChasseurDejaExistantException
     *          Exception lanc�e si chasseur d�j� existant.
     */
    ChasseurDePrime ajouterChasseurDePrime(ChasseurDePrime pChasseurDePrime)
            throws ChasseurDejaExistantException;

    /**
     * Supprimer un chasseur.
     * @param pChasseurDePrime Chasseur de prime � supprimer.
     * @return Bool�en indiquant si suppression ou non effectu�e.
     * @throws ChasseurNonTrouve
     *          Exception lanc�e si pas de chasseur trouv�.
     */
    boolean supprimerChasseurDePrime(ChasseurDePrime pChasseurDePrime)
                throws ChasseurNonTrouve;

    /**
     * Recherche des chasseurs de prime par nom semblable � celui fourni.
     *
     * @param pNom
     *            : le nom de r�f�rence.
     * @return la liste des chasseurs de prime dont le nom match pNom.
     */
    List<ChasseurDePrime> rechercherChasseurDePrimeParNom(String pNom);

    /**
     * Recherche des chasseurs de prime dont le tarif est compris entre le tarif
     * bas et le tarif haut.
     *
     * @param pTarifBas
     *            le tarif minimum de la recherche.
     * @param pTarifHaut
     *            le tarif maximum de la recherche.
     * @return la liste des chasseurs de prime dont le tarif est compris entre
     *         pTarifHaut et pTarifBas.
     */
    List<ChasseurDePrime> rechercherChasseurDePrimeParTarif(float pTarifBas,
            float pTarifHaut);

   /**
    * M�thode pour tuer un chasseur.
    * @param pChasseurDePrime Chasseur � tuer.
    * @return Booleen indiquant si chasseur bien tu�.
    * @throws ChasseurNonTrouve Exception lanc�e si chasseur non dans la base.
    */
    boolean tuerChasseur(ChasseurDePrime pChasseurDePrime)
            throws ChasseurNonTrouve;
}
