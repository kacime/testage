package fr.afcepf.ai100.exception;

/**
 * Exception renvoy�e quand chasseur non trouv�.
 * @author Stagiaire
 *
 */
public class ChasseurNonTrouve extends Exception {
        /**
         * Constructeur.
         * @param message Message diffus�.
         */
        public ChasseurNonTrouve(String message) {
            super(message);
        }
}
