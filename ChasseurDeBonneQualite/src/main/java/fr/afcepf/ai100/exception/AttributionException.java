package fr.afcepf.ai100.exception;

/**
 * Exception levée si l'attribution ne se fait pas normalement.
 * @author Stagiaire
 *
 */
public class AttributionException extends Exception {

    /**
     * Constructeur.
     * @param pMessage message d'erreur.
     */
    public AttributionException(String pMessage) {
     super(pMessage);
    }
}
