package fr.afcepf.ai100.business.api;

import java.util.List;

import fr.afcepf.ai100.entity.ChasseurDePrime;
import fr.afcepf.ai100.entity.Equipement;
import fr.afcepf.ai100.exception.AttributionException;
import fr.afcepf.ai100.exception.EquipementInexistant;
import fr.afcepf.ai100.exception.EquipementMaxException;

/**
 * Interface proposant les méthodes du business Equipement.
 *
 * @author Stagiaire
 *
 */
public interface IBusinessEquipement {

    /**
     * Permet d'attribuer un Equipement à un ChasseurDePrime si celui-ci ne
     * porte pas déjà plus de trois équipements.
     *
     * @param pEquipement
     *            l'Equipement a attribuer
     * @param pChasseurDePrime
     *            le ChasseurDePrime qui veut porter l'Equipement.
     * @return l'Equipement avec l'id de son pocesseur modifié.
     * @throws EquipementMaxException
     *             levée si la capacité maximum de portage du chasseur de prime
     *             est atteinte.
     * @throws AttributionException
     *             levée si l'attribution ne se passe pas correctement.
     */
    Equipement attribuerEquipement(Equipement pEquipement,
            ChasseurDePrime pChasseurDePrime)
            throws EquipementMaxException, AttributionException;

    /**
     * Permet de supprimer un équipement.
     * @param pEquipement Equipement à supprimer.
     * @throws EquipementInexistant
     *          levée si l'équipement n'existe pas.
     */
    void supprimerEquipement(Equipement pEquipement)
            throws EquipementInexistant;

    /**
     * Recherche des equipement par nom semblable.
     *
     * @param pNom
     *            : le nom ressemblant au nom des équipements.
     * @return la liste des équipements dont le nom match avec le pNom.
     */
    List<Equipement> rechercherEquipement(String pNom);



    /**
     * Récupère le nombre d'Equipement portés par le ChasseurDePrime.
     *
     * @param pIdChasseurDePrime
     *            l'id du ChasseurDePrime dont on veut le nombre d'Equipement.
     * @return le nombre d'Equipement du chasseurDePrime.
     */
    int nbEquipement(int pIdChasseurDePrime);


}
