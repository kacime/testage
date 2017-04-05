package fr.afcepf.ai100.jdbc;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;
/**
 * DataSource.
 * @author Stagiaire
 *
 */
public class Ai100DataSource implements DataSource {
    /**
     * Nom de la propriété username dans le bundle.
     */
    private static final String USERNAME = "username";
    /**
     * Nom de la propriété password dans le bundle.
     */
    private static final String PASSWORD = "password";
    /**
     * nom de la propriété jndiPath dans le bundle.
     */
    private static final String JNDIPATH = "jndiPath";

    /**
     * nom de la propriété driverClassName dans le bundle.
     */
    private static final String DRIVER_CLASS_NAME = "driverClassName";
    /**
     * Emplacement du fichier de properties.
     */
    private static final String PATH_TO_BUNDLE =
                        "fr.afcepf.ai100.jdbc.bdd_ai100";
    /**
     * utilisateur de l'accès à la bdd.
     */
    private static String username;
    /**
     * Mot de passe pour l'accès à la bdd.
     */
    private static String password;
    /**
     * Url de la base de donnée.
     */
    private static String url;


    static {

        try {


            // Avec ResourceBundle
            ResourceBundle rb = ResourceBundle.getBundle(PATH_TO_BUNDLE);
            username = rb.getString(USERNAME);
            password = rb.getString(PASSWORD);
            url = rb.getString(JNDIPATH);
            Class.forName(rb.getString(DRIVER_CLASS_NAME));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter arg0) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Connection getConnection(
            String pUsername, String pPassword) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
