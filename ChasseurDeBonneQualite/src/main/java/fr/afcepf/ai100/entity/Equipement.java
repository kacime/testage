package fr.afcepf.ai100.entity;

/**
 * Classe entité correspondant à la table equipement.
 *
 * @author Stagiaire
 *
 */
public class Equipement {

    /**
     * Id de l'équipement dans la bdd.
     */
    private int idEquipement;

    /**
     * Nom de l'équipement.
     */
    private String nom;
    /**
     *id du chasseur de prime portant l'équipement.
     */
    private int idChasseurDePrime;

    /**
     * Getter de l'id de l'équipement.
     * @return l'id de l'équipement.
     */
    public int getIdEquipement() {
        return idEquipement;
    }
    /**
     * Setter de l'id de l'équipement.
     * @param pIdEquipement nouvel id de l'équipement.
     */
    public void setIdEquipement(int pIdEquipement) {
        idEquipement = pIdEquipement;
    }

    /**
     * Getter du nom de l'équipement.
     * @return le nom de l'équipement.
     */
    public String getNom() {
        return nom;
    }
    /**
     * Setter du nom de l'équipement.
     * @param pNom nouveau nom de l'équipement.
     */
    public void setNom(String pNom) {
        nom = pNom;
    }
    /**
     * Getter du nom du chasseur de prime qui pocède de l'équipement.
     * @return l'id du chasseur de prime qui a l'équipement.
     */
    public int getIdChasseurDePrime() {
        return idChasseurDePrime;
    }
    /**
     * Setter de l'id du chasseur de prime qui pocède l'équipement.
     * @param pIdChasseurDePrime l'id du nouveau pocesseur.
     */
    public void setIdChasseurDePrime(int pIdChasseurDePrime) {
        idChasseurDePrime = pIdChasseurDePrime;
    }
    /**
     * Constructeur.
     * @param pIdEquipement id de l'équipement.
     * @param pNom nom de l'équipement.
     * @param pIdChasseurDePrime id du pocesseur de l'équipement.
     */
    public Equipement(int pIdEquipement, String pNom, int pIdChasseurDePrime) {
        super();
        idEquipement = pIdEquipement;
        nom = pNom;
        idChasseurDePrime = pIdChasseurDePrime;
    }
    /**
     * Constructeur.
     * @param pIdEquipement id de l'équipement.
     * @param pNom nom de l'équipement.
     */
    public Equipement(int pIdEquipement, String pNom) {
        super();
        idEquipement = pIdEquipement;
        nom = pNom;
    }
    /**
     * Constructeur.
     * @param pNom nom de l'équipement.
     */
    public Equipement(String pNom) {
        nom = pNom;
    }
}
