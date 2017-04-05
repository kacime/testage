package fr.afcepf.ai100.exception;

/**
 * Exception renboyée quand le chasseur existe déjà dans la base.
 * @author Stagiaire
 *
 */
public class ChasseurDejaExistantException extends Exception {

    /**
     * Constructeur.
     * @param message message à envoyer.
     */
    public ChasseurDejaExistantException(String message) {
        super(message);
    }
}
