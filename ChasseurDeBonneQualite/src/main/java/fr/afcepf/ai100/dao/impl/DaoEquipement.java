package fr.afcepf.ai100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.afcepf.ai100.dao.api.IDaoEquipement;
import fr.afcepf.ai100.entity.Equipement;
import fr.afcepf.ai100.exception.EquipementInexistant;
import fr.afcepf.ai100.jdbc.Ai100DataSource;

/**
 * Implémentation de l'interface IDaoEquipement.
 *
 * @author Stagiaire
 *
 */
public class DaoEquipement implements IDaoEquipement {

    /**
     * DataSource pour se connecter à la base.
     */
    private Ai100DataSource dataSource = new Ai100DataSource();

    /**
     * Nom de la table dans la bdd.
     */
    private static final String EQUIPEMENT_TABLE = "equipement";
    /**
     * Nom de la colonne nom.
     */
    private static final String COLONNE_NOM = "nom";
    /**
     * Nom de la colonne id_Equipement.
     */
    private static final String COLONNE_ID_EQUIPEMENT = "id_equipement";
    /**
     * nom de la colonne de count.
     */
    private static final String COUNT = "countColonne";

    /**
     * Nom de la colonne id_chasseur_de_prime.
     */
    private static final String COLONNE_ID_CHASSEUR_DE_PRIME =
            "id_chasseur_de_prime";

    /**
     * Requete pour compter le nombre d'équipements d'un chasseur de prime.
     */
    private static String requeteCount = "SELECT COUNT(*) as " + COUNT
            + " FROM " + EQUIPEMENT_TABLE + " WHERE "
            + COLONNE_ID_CHASSEUR_DE_PRIME + " = ?";

    /**
     * Requete d'ajout d'un équipement.
     */
    private static String requeteAjout = "INSERT INTO " + EQUIPEMENT_TABLE
            + " (" + COLONNE_NOM + ") VALUES (?)";

    /**
     * Requete de suppression d'un équipement dans la bdd.
     */
    private static String requeteSuppression = "DELETE FROM " + EQUIPEMENT_TABLE
            + " WHERE " + COLONNE_ID_EQUIPEMENT + " = ?";
    /**
     * Requete de recherche d'équipement par nom.
     */
    private static String requeteRecherche = "SELECT " + COLONNE_ID_EQUIPEMENT
            + " ," + COLONNE_NOM + ", " + COLONNE_ID_CHASSEUR_DE_PRIME
            + " FROM equipement WHERE nom like ?";

    /**
     * Requete pour l'attribution d'un équipement à un chasseur de prime.
     */
    private static String requeteUpdate = "UPDATE " + EQUIPEMENT_TABLE + "set "
            + COLONNE_ID_CHASSEUR_DE_PRIME + " = ? " + "WHERE "
            + COLONNE_ID_EQUIPEMENT + " = ? ";


    @Override
    public Equipement ajouterEquipement(Equipement pEquipement) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(requeteAjout,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, pEquipement.getNom());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            pEquipement.setIdEquipement(rs.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pEquipement;
    }

    @Override
    public boolean supprimerEquipement(int pIdEquipement) {
        Connection connection = null;
        boolean reussi = false;
        try {
            connection = dataSource.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement(requeteSuppression);
            pstmt.setInt(1, pIdEquipement);
            reussi = pstmt.executeUpdate() != 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reussi;
    }

    @Override
    public List<Equipement> rechercherEquipement(String pNom) {
        List<Equipement> listeEquipements = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement(requeteRecherche);
            pstmt.setString(1, "%" + pNom + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idEquipement = rs.getInt(COLONNE_ID_EQUIPEMENT);
                int idChasseurDePrime = rs.getInt(COLONNE_ID_CHASSEUR_DE_PRIME);
                String nom = rs.getString(COLONNE_NOM);
                listeEquipements.add(
                        new Equipement(idEquipement, nom, idChasseurDePrime));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listeEquipements;
    }

    @Override
    public boolean attribuerEquipement(int pIdEquipement,
            int pIdChasseurDePrime) {
        Connection connection = null;
        boolean reussi = false;
        try {
            connection = dataSource.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement(requeteUpdate);
            pstmt.setInt(1, pIdChasseurDePrime);
            pstmt.setInt(2, pIdEquipement);
            int nb = pstmt.executeUpdate();

            if (nb == 1) {
                reussi = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reussi;
    }

    @Override
    public int nbEquipement(int pIdChasseurDePrime) {
        Connection connection = null;
        int count = 0;
        try {
            connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(requeteCount);
            pstmt.setInt(1, pIdChasseurDePrime);
            ResultSet res = pstmt.executeQuery();
            count = res.getInt(COUNT);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return count;
    }

}
