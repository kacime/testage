package fr.afcepf.ai100.exception;

/**
 * Exeption si trop d'Equipement.
 * @author Stagiaire
 *
 */
public class EquipementMaxException extends Exception {

    /**
     * Constructeur.
     * @param pMessage le message d'erreur.
     */
    public EquipementMaxException(String pMessage) {
        super(pMessage);
    }

}
