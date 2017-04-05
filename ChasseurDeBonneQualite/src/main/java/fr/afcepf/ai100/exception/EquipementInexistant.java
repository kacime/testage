package fr.afcepf.ai100.exception;

/**
 * Exception g�rant les �quipements inexistants.
 * @author Stagiaire
 *
 */
public class EquipementInexistant extends Exception {

    /**
     * Constructeur de l'exception.
     * @param pString Message envoy�.
     */
    public EquipementInexistant(String pString) {
        super(pString);
    }

}
