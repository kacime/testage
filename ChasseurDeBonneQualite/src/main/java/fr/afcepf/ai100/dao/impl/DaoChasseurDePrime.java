package fr.afcepf.ai100.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

import fr.afcepf.ai100.dao.api.IDaoChasseurDePrime;
import fr.afcepf.ai100.entity.ChasseurDePrime;
import fr.afcepf.ai100.jdbc.Ai100DataSource;

/**
 * CRUD de la table chasseurdeprime.
 *
 * @author Stagiaire
 *
 */
public class DaoChasseurDePrime implements IDaoChasseurDePrime {

    /**
     * DataSource pour ouvrir notre connexion.
     */
    private DataSource ds = new Ai100DataSource();

    /**
     * Nom de la table dans la bdd.
     */
    private static final String CHASSEUR_TABLE = "chasseur_de_prime";
    /**
     * Nom de la colonne nom.
     */
    private static final String COLONNE_NOM = "nom";
    /**
     * Nom de la colonne id du chasseur.
     */
    private static final String COLONNE_ID_CHASSEUR = "id_chasseur_de_prime";
    /**
     * nom de la colonne du tarif.
     */
    private static final String COLONNE_TARIF = "tarif";

    /**
     * Nom de la colonne du vaisseau.
     */
    private static final String COLONNE_VAISSEAU =
            "vaisseau";

    /**
     * Nom de la colonne du vaisseau.
     */
    private static final String COLONNE_MORT =
            "mort";

    /**
     * Constant indiquant la place du paramètre 1.
     */
    private static final int PARAM1 = 1;

    /**
     * Constant indiquant la place du paramètre 2.
     */
    private static final int PARAM2 = 2;

    /**
     * Constant indiquant la place du paramètre 3.
     */
    private static final int PARAM3 = 3;

    /**
     * Constant indiquant la place du paramètre 4.
     */
    private static final int PARAM4 = 4;

    /**
     * Requête SQL d'ajout d'un chasseur.
     */
    private static final String REQ_ADD =
            "INSERT INTO " + CHASSEUR_TABLE + " (" + COLONNE_NOM + ", "
    + COLONNE_TARIF + ", " + COLONNE_VAISSEAU + ", " + COLONNE_MORT + ")"
            + "VALUES (?, ?, ?, ?)";

    /**
     * Requête SQL de suppression d'un chasseur.
     */
    private static final String REQ_DELETE =
            "DELETE FROM " + CHASSEUR_TABLE + " WHERE "
                    + COLONNE_ID_CHASSEUR + " = ?";

    /**
     * Requête SQL de recherche d'un chasseur par nom.
     */
    private static final String REQ_SEARCH_NOM =
    "SELECT " + COLONNE_ID_CHASSEUR + ", " + COLONNE_NOM + ", "
            + COLONNE_TARIF + ", " + COLONNE_MORT
            + "FROM " + CHASSEUR_TABLE + " WHERE " + COLONNE_NOM + " LIKE ?";

    /**
     * Requête SQL de recherche d'un chasseur par tarifMin et tarifMax.
     */
    private static final String REQ_SEARCH_TARIF =
    "SELECT " + COLONNE_ID_CHASSEUR + ", " + COLONNE_NOM + ", "
            + COLONNE_TARIF + ", " + COLONNE_MORT
            + "FROM " + CHASSEUR_TABLE + " WHERE " + COLONNE_TARIF + ">? AND "
            + COLONNE_TARIF + "<?";

    /**
     * Requête SQL de recherche d'un chasseur par tarifMin et tarifMax.
     */
    private static final String REQ_KILL =
            "UPDATE " + CHASSEUR_TABLE + " SET " + COLONNE_MORT + "=1"
                    + " WHERE " + COLONNE_ID_CHASSEUR + "= ?";


    @Override
    public ChasseurDePrime ajouterChasseurDePrime(ChasseurDePrime ch) {
        try (Connection cnx = ds.getConnection()) {
            PreparedStatement pstmt =
                    cnx.prepareStatement(REQ_ADD,
                            Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(PARAM1, ch.getNom());
            pstmt.setFloat(PARAM2, ch.getTarif());
            pstmt.setString(PARAM3, ch.getVaisseau());
            pstmt.setBoolean(PARAM4, ch.isMort());
            boolean reussite = pstmt.executeUpdate() == 1;
            if (reussite) {
                ResultSet rsKey = pstmt.getGeneratedKeys();
                if (rsKey.next()) {
                    ch.setIdChasseurDePrime(rsKey.getInt(1));
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        return ch;
    }

    @Override
    public boolean supprimerChasseurDePrime(int idChasseurDePrime) {
        Connection cnx = null;
        boolean reussi = false;
        try {
            cnx = ds.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement(REQ_DELETE);
            pstmt.setInt(1, idChasseurDePrime);
            reussi = pstmt.executeUpdate()==1;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return reussi;
    }

    @Override
    public List<ChasseurDePrime> rechercherChasseurDePrimeParNom(String nom) {
        List<ChasseurDePrime> chasseurs = new ArrayList<>();
        Connection cnx = null;
        try {
            cnx = ds.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement(REQ_SEARCH_NOM);
            pstmt.setString(1, "%" + nom + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idChasseur = rs.getInt("idchasseur");
                String nomChasseur = rs.getString("nom");
                float tarif = rs.getFloat("tarif");
                String vaisseau = rs.getString("vaisseau");
                boolean mort = rs.getBoolean("mort");
                chasseurs.add(new ChasseurDePrime(idChasseur,
                        nomChasseur, tarif, vaisseau, mort));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return chasseurs;
    }

    @Override
    public List<ChasseurDePrime>
    rechercherChasseurDePrimeParTarif(float tarifMin, float tarifMax) {
        List<ChasseurDePrime> chasseurs = new ArrayList<>();
        Connection cnx = null;
        try {
            cnx = ds.getConnection();

            PreparedStatement pstmt = cnx.prepareStatement(REQ_SEARCH_TARIF);
            pstmt.setFloat(1, tarifMin);
            pstmt.setFloat(2, tarifMax);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idChasseur = rs.getInt("idchasseur");
                String nomChasseur = rs.getString("nom");
                float tarif = rs.getFloat("tarif");
                String vaisseau = rs.getString("vaisseau");
                boolean mort = rs.getBoolean("mort");
                chasseurs.add(new ChasseurDePrime(idChasseur,
                        nomChasseur, tarif, vaisseau, mort));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return chasseurs;
    }

    @Override
    public boolean tuerChasseur(int idChasseur) {
        Connection cnx = null;
        boolean reussi = false;
        try {
            cnx = ds.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement(REQ_KILL);
            pstmt.setInt(1, idChasseur);
            int nb = pstmt.executeUpdate();
            if (nb == 1) {
                reussi = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return reussi;
    }


}
