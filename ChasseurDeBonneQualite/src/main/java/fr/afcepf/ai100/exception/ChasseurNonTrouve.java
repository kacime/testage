package fr.afcepf.ai100.exception;

/**
 * Exception renvoyée quand chasseur non trouvé.
 * @author Stagiaire
 *
 */
public class ChasseurNonTrouve extends Exception {
        /**
         * Constructeur.
         * @param message Message diffusé.
         */
        public ChasseurNonTrouve(String message) {
            super(message);
        }
}
