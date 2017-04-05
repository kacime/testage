package fr.afcepf.ai100.business.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.afcepf.ai100.business.api.IBusinessEquipement;
import fr.afcepf.ai100.dao.api.IDaoEquipement;
import fr.afcepf.ai100.entity.ChasseurDePrime;
import fr.afcepf.ai100.entity.Equipement;
import fr.afcepf.ai100.exception.AttributionException;
import fr.afcepf.ai100.exception.EquipementMaxException;
import junit.framework.Assert;

/**
 * Classe Buisness de test.
 * @author Stagiaire
 *
 */
public class BusinessEquipementImplTest {

    /**
     * Id de l'équipement de test.
     */
    private static final int ID_EQUIPEMENT = 2;

    /**
     * Id du chasseur de prime de test.
     */
    private static final int ID_CHASSEUR_DE_PRIME = 42;
    /**
     * Classe que l'on teste.
     */
    private IBusinessEquipement businessEquipement = new BusinessEquipement();

    /**
     * Test nominal de.
     * {@link BusinessEquipement#attribuerEquipement
     * (Equipement, ChasseurDePrime)}
     * @throws AttributionException
     *          Exception lancée quand attribution non effectuée.
     * @throws EquipementMaxException
     *          Exception lancée quand trop d'exception.
     */
    @Test
    public void attribuerEquipementNominal()
            throws EquipementMaxException, AttributionException {

        IDaoEquipement daoEquipement = new DaoEquipementNominal();
        ((BusinessEquipement) businessEquipement)
                .setDaoEquipement(daoEquipement);
        Equipement equipement = new Equipement(ID_EQUIPEMENT, "Titi");
        ChasseurDePrime chasseurDePrime = new ChasseurDePrime();
        chasseurDePrime.setIdChasseurDePrime(ID_CHASSEUR_DE_PRIME);
        Equipement equipementRetour = businessEquipement
                .attribuerEquipement(equipement, chasseurDePrime);
        assertEquals(equipementRetour.getIdChasseurDePrime(),
                ID_CHASSEUR_DE_PRIME);
    }


    /**
     * Test en échec. Le nombre d'équipements portés par le chasseur de prime
     * est au maximum. L'Exception EquipementMaxEception doit être levée.
     *
     * @throws AttributionException
     *          Exception lancée quand attribution non effectuée.
     * @throws EquipementMaxException
     *          Exception lancée quand trop d'exception.
     */
    @Test(expected = EquipementMaxException.class)
    public void attribuerEquipementEchecGrandNb()
            throws EquipementMaxException, AttributionException {
        Equipement equipement = new Equipement(ID_EQUIPEMENT, "Titi");
        ChasseurDePrime chasseurDePrime = new ChasseurDePrime();
        chasseurDePrime.setIdChasseurDePrime(ID_CHASSEUR_DE_PRIME);

        IDaoEquipement daoEquipementMock = Mockito.mock(IDaoEquipement.class);

        Mockito.when(daoEquipementMock.nbEquipement(ID_CHASSEUR_DE_PRIME))
                .thenReturn(BusinessEquipement.NOMBRE_EQUIPEMENT_MAX);

        ((BusinessEquipement) businessEquipement)
                        .setDaoEquipement(daoEquipementMock);
        businessEquipement.attribuerEquipement(equipement, chasseurDePrime);
    }

    /**
     * Test de l'échec de l'attribution dans la base.
     * @throws AttributionException
     *          Exception lancée quand attribution non effectuée.
     * @throws EquipementMaxException
     *          Exception lancée quand trop d'exception.
     */
    @Test(expected = AttributionException.class)
    public void attribuerEquipementEchecAttribution()
            throws EquipementMaxException, AttributionException {
        Equipement equipement = new Equipement(ID_EQUIPEMENT, "Titi");
        ChasseurDePrime chasseurDePrime = new ChasseurDePrime();
        chasseurDePrime.setIdChasseurDePrime(ID_CHASSEUR_DE_PRIME);

        IDaoEquipement daoEquipementMock = Mockito.mock(IDaoEquipement.class);

        Mockito.when(daoEquipementMock.nbEquipement(ID_CHASSEUR_DE_PRIME))
                .thenReturn(BusinessEquipement.NOMBRE_EQUIPEMENT_MAX-1);

        Mockito.when(daoEquipementMock
                .attribuerEquipement(ID_EQUIPEMENT, ID_CHASSEUR_DE_PRIME))
                .thenReturn(false);

        ((BusinessEquipement) businessEquipement)
                        .setDaoEquipement(daoEquipementMock);
        businessEquipement.attribuerEquipement(equipement, chasseurDePrime);
    }

    /**
     * Dao pour le test nominal d'attribution.
     *
     * @author Stagiaire
     *
     */
    private class DaoEquipementNominal implements IDaoEquipement {

        @Override
        public Equipement ajouterEquipement(Equipement pEquipement) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean supprimerEquipement(int pIdEquipement) {
            return false;
            // TODO Auto-generated method stub

        }

        @Override
        public List<Equipement> rechercherEquipement(String pNom) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean attribuerEquipement(int pIdEquipement,
                int pIdChasseurDePrime) {

            return true;
        }

        @Override
        public int nbEquipement(int pIdChasseurDePrime) {
            // TODO Auto-generated method stub
            return 0;
        }

    }

}
