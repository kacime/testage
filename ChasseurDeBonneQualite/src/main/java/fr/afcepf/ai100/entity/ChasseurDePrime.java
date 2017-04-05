package fr.afcepf.ai100.entity;


/**
 * Classe entité correspondant à la table chasseurdeprime.
 *
 * @author Stagiaire
 *
 */

public class ChasseurDePrime {

    /**
     * Id du chasseur de prime.
     */
    private int idChasseurDePrime;

    /**
     * Nom du chasseur de prime.
     */
    private String nom;

    /**
     * Tarif pour acquérir ses services.
     */
    private float tarif;

    /**
     * Nom du vaisseau du chasseur.
     */
    private String vaisseau;

    /**
     * Boolean pour indiquer si mort ou non.
     */
    private boolean mort;

    /**
     * Constructeur vide du chasseur.
     */
    public ChasseurDePrime() {
        super();
    }

    /**
     * Constructeur surchargé pour le chasseur.
     *
     * @param pIdChasseurDePrime Id du chasseur.
     * @param pNom Nom du chasseur.
     * @param pTarif Tarif du chasseur.
     * @param pVaisseau Nom du Vaisseau.
     * @param pMort Boolean de la mort.
     */

    public ChasseurDePrime(int pIdChasseurDePrime, String pNom,
            float pTarif, String pVaisseau, boolean pMort) {
        super();
        idChasseurDePrime = pIdChasseurDePrime;
        nom = pNom;
        tarif = pTarif;
        vaisseau = pVaisseau;
        mort = pMort;
    }

    @Override
    public String toString() {
        return "ChasseurDePrime [idChasseurDePrime=" + idChasseurDePrime
                + ", nom=" + nom + ", tarif=" + tarif
                + ", vaisseau=" + vaisseau + ", mort=" + mort + "]";
    }

    /**
     * Getter de l'id du chasseur.
     *
     * @return Id du chasseur.
     */
    public int getIdChasseurDePrime() {
        return idChasseurDePrime;
    }

    /**
     * Setter de l'id du chasseur.
     *
     * @param pidChasseurDePrime
     *            Id du chasseur à setter.
     */
    public void setIdChasseurDePrime(int pidChasseurDePrime) {
        idChasseurDePrime = pidChasseurDePrime;
    }

    /**
     * Getter du nom du chasseur.
     *
     * @return Nom du chasseur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du nom du chasseur.
     *
     * @param pnom
     *            Nom du chassuer à setter.
     */
    public void setNom(String pnom) {
        nom = pnom;
    }

    /**
     * Getter du tarif du chasseur.
     *
     * @return Tarif du chasseur.
     */
    public float getTarif() {
        return tarif;
    }

    /**
     * Setter du tarif.
     *
     * @param ptarif
     *            Tarif du chassuer à setter.
     */
    public void setTarif(float ptarif) {
        tarif = ptarif;
    }

    /**
     * Getter du nom du vaisseau.
     *
     * @return Nom du vaisseau.
     */
    public String getVaisseau() {
        return vaisseau;
    }

    /**
     * Setter du nom du vaisseau.
     *
     * @param pVaisseau
     *            Nom du vaisseau à setter.
     */
    public void setVaisseau(String pVaisseau) {
        pVaisseau = vaisseau;
    }

    /**
     * Getter du boolean pour savoir si chasseur est mort ou non.
     *
     * @return Boolean indiquant si mort ou non du chasseur.
     */
    public boolean isMort() {
        return mort;
    }

    /**
     * Setter du boolean indiquant la mort.
     *
     * @param pMort
     *            Boolean indiquant si mort ou non.
     */
    public void setMort(boolean pMort) {
        mort = pMort;
    }



}
