package fr.afcepf.ai100.business.api;

import java.util.List;

import fr.afcepf.ai100.entity.ChasseurDePrime;
import fr.afcepf.ai100.exception.ChasseurDejaExistantException;
import fr.afcepf.ai100.exception.ChasseurNonTrouve;

/**
 * Interface proposant les métodes du buisness ChasseurDePrime.
 * @author Stagiaire
 *
 */
public interface IBusinessChasseurDePrime {

    /**
     * Ajoute un chasseur de prime dans la bdd.
     *
     * @param pChasseurDePrime
     *            le chasseur de prime à ajouter.
     * @return le chasseur de prime avec son id généré.
     * @throws ChasseurDejaExistantException
     *          Exception lancée si chasseur déjà existant.
     */
    ChasseurDePrime ajouterChasseurDePrime(ChasseurDePrime pChasseurDePrime)
            throws ChasseurDejaExistantException;

    /**
     * Supprimer un chasseur.
     * @param pChasseurDePrime Chasseur de prime à supprimer.
     * @return Booléen indiquant si suppression ou non effectuée.
     * @throws ChasseurNonTrouve
     *          Exception lancée si pas de chasseur trouvé.
     */
    boolean supprimerChasseurDePrime(ChasseurDePrime pChasseurDePrime)
                throws ChasseurNonTrouve;

    /**
     * Recherche des chasseurs de prime par nom semblable à celui fourni.
     *
     * @param pNom
     *            : le nom de référence.
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
    * Méthode pour tuer un chasseur.
    * @param pChasseurDePrime Chasseur à tuer.
    * @return Booleen indiquant si chasseur bien tué.
    * @throws ChasseurNonTrouve Exception lancée si chasseur non dans la base.
    */
    boolean tuerChasseur(ChasseurDePrime pChasseurDePrime)
            throws ChasseurNonTrouve;
}
