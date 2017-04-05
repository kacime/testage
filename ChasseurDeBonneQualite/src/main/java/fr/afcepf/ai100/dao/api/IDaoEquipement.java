package fr.afcepf.ai100.dao.api;

import java.util.List;

import fr.afcepf.ai100.entity.Equipement;
import fr.afcepf.ai100.exception.EquipementInexistant;

/**
 * Interface pour la d�finition des m�thodes de CRUD de la table equipement.
 *
 * @author Stagiaire
 *
 */
public interface IDaoEquipement {
    /**
     * Ajoute l'�quipement dans la base.
     *
     * @param pEquipement
     *            l'�quipement � ajouter.
     * @return l'�quipement avec son id.
     */
    Equipement ajouterEquipement(Equipement pEquipement);

    /**
     * Supprime l'�quipement d�sign� par son id de la base.
     *
     * @param pIdEquipement
     *            id de l'�quipement � supprimer.
     * @return booleen indiquant si suppression op�r�e
     */
    boolean supprimerEquipement(int pIdEquipement);

    /**
     * Recherche des equipement par nom semblable.
     *
     * @param pNom
     *            : le nom ressemblant au nom des �quipements.
     * @return la liste des �quipements dont le nom match avec le pNom.
     */
    List<Equipement> rechercherEquipement(String pNom);

    /**
     * Donne un �quipement � un chasseur de prime.
     *
     * @param pIdEquipement
     *            id de l'�quipement � attribuer.
     * @param pIdChasseurDePrime
     *            id du chasseur de prime qui re�oit l'�quipement.
     * @return true si l'attribution c'est bien pass�, false autrement.
     */
    boolean attribuerEquipement(int pIdEquipement, int pIdChasseurDePrime);

    /**
     * R�cup�re le nombre d'Equipement port�s par le ChasseurDePrime.
     *
     * @param pIdChasseurDePrime
     *            l'id du ChasseurDePrime dont on veut le nombre d'Equipement.
     * @return le nombre d'Equipement du chasseurDePrime.
     */
    int nbEquipement(int pIdChasseurDePrime);

}
