package fr.afcepf.ai100.exception;

/**
 * Exception renboy�e quand le chasseur existe d�j� dans la base.
 * @author Stagiaire
 *
 */
public class ChasseurDejaExistantException extends Exception {

    /**
     * Constructeur.
     * @param message message � envoyer.
     */
    public ChasseurDejaExistantException(String message) {
        super(message);
    }
}
