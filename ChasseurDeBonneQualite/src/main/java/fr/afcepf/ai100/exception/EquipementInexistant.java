package fr.afcepf.ai100.exception;

/**
 * Exception gérant les équipements inexistants.
 * @author Stagiaire
 *
 */
public class EquipementInexistant extends Exception {

    /**
     * Constructeur de l'exception.
     * @param pString Message envoyé.
     */
    public EquipementInexistant(String pString) {
        super(pString);
    }

}
