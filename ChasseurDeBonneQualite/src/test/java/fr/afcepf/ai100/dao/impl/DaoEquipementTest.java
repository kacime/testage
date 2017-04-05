package fr.afcepf.ai100.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.afcepf.ai100.entity.Equipement;

/**
 * Classe de test de la classe DaoEquipement.
 *
 * @author Stagiaire
 * @see DaoEquipement. {@link DaoEquipement}
 */
public class DaoEquipementTest {
    /**
     * Emplacement du script de lancement de la creation de la base.
     */
    private static final String PATH_TO_SCRIPT = "creabase.bat";

    /**
     * Méthode d'initialisation des tests. Execute le script de
     * creation/remplissage de la base.
     */
    @BeforeClass
    public static void init() {
        String path = Thread.currentThread().getContextClassLoader()
                .getResource(PATH_TO_SCRIPT).getPath();
        path = path.replaceAll("%20", " ");

        try {
            Process process = Runtime.getRuntime().exec(path);
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Problème lors de l'éxécution du script de "
                    + "création de la base");
        }

    }

    /**
     * La classe que l'on teste.
     */
    private DaoEquipement daoEquipement = new DaoEquipement();

    /**
     * Méthode de test de la méthode.
     * {@link DaoEquipement#ajouterEquipement(Equipement)}.
     */
    @Test
    public void ajouterEquipementTest() {
        Equipement equipement = new Equipement("jetpack");
        Equipement equipementRetourne = daoEquipement
                .ajouterEquipement(equipement);
        // les objets sont égaux.
        assertEquals(equipement, equipementRetourne);

        // les objets correspondent à la même instance.
        assertSame(equipement, equipementRetourne);
        assertFalse(equipementRetourne.getIdEquipement() == 0);
    }

}
