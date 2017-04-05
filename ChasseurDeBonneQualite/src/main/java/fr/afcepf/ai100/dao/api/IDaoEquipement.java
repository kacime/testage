package fr.afcepf.ai100.dao.api;

import java.util.List;

import fr.afcepf.ai100.entity.Equipement;
import fr.afcepf.ai100.exception.EquipementInexistant;

/**
 * Interface pour la définition des méthodes de CRUD de la table equipement.
 *
 * @author Stagiaire
 *
 */
public interface IDaoEquipement {
    /**
     * Ajoute l'équipement dans la base.
     *
     * @param pEquipement
     *            l'équipement à ajouter.
     * @return l'équipement avec son id.
     */
    Equipement ajouterEquipement(Equipement pEquipement);

    /**
     * Supprime l'équipement désigné par son id de la base.
     *
     * @param pIdEquipement
     *            id de l'équipement à supprimer.
     * @return booleen indiquant si suppression opérée
     */
    boolean supprimerEquipement(int pIdEquipement);

    /**
     * Recherche des equipement par nom semblable.
     *
     * @param pNom
     *            : le nom ressemblant au nom des équipements.
     * @return la liste des équipements dont le nom match avec le pNom.
     */
    List<Equipement> rechercherEquipement(String pNom);

    /**
     * Donne un équipement à un chasseur de prime.
     *
     * @param pIdEquipement
     *            id de l'équipement à attribuer.
     * @param pIdChasseurDePrime
     *            id du chasseur de prime qui reçoit l'équipement.
     * @return true si l'attribution c'est bien passé, false autrement.
     */
    boolean attribuerEquipement(int pIdEquipement, int pIdChasseurDePrime);

    /**
     * Récupère le nombre d'Equipement portés par le ChasseurDePrime.
     *
     * @param pIdChasseurDePrime
     *            l'id du ChasseurDePrime dont on veut le nombre d'Equipement.
     * @return le nombre d'Equipement du chasseurDePrime.
     */
    int nbEquipement(int pIdChasseurDePrime);

}
