package TestsEntreprise;

import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Directeur;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Personnes;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class TestInitialisationObjet {

    
        String fonction1 = "directeur";
        String fonction2 = "comptable";
        String fonction3 = "secretaire";
        String fonction4 = "ouvrier";
        String numeroNational = "1234";
        String prenom = "Fred";
        String nom = "Nicolay";
    

    
    @Before
    public void initVariables() {
        String numeroNational = "1234";
        String prenom = "Fred";
        String nom = "Nicolay";
    }

    @Test
    public void TestInitDirecteur() {
        Personnes directeur = new Directeur(numeroNational, prenom, nom, fonction1);
    }

}
