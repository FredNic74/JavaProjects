package TestsEntreprise;

import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Personnes;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.PersonnesFactory;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)//permet de choisir l'ordre des méthodes

/**
 * Class qui test si les différents objet personnes s'initialise bien avec leurs attributs
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class TestInitialisationObjet {
    //déclaration et initialisation des différentes variables

    public String fonction1 = "directeur";
    public String fonction2 = "comptable";
    public String fonction3 = "secretaire";
    public String fonction4 = "ouvrier";
    public String idDir = "1234";
    public String prenomDir = "Fred";
    public String nomDir = "Nicolay";
    public String idCom = "4567";
    public String prenomCom = "Jecompte";
    public String nomCom = "Bien";
    public String idSec = "9874";
    public String prenomSec = "Mimi";
    public String nomSec = "Lafrappe";
    public String idOuv = "4561";
    public String prenomOuv = "Gege";
    public String nomOuv = "Lapelle";

    //Test initialisation d'un directeur en testant tout ses attributs
    @Test
    public void T0_TestInitDirecteur() {
        Personnes dirlo = PersonnesFactory.getPers(idDir, prenomDir, nomDir, fonction1);
        assertEquals( dirlo.getNumeroNational(),"1234");
        assertEquals( dirlo.getPrenom(),"Fred");
        assertEquals( dirlo.getNom(),"Nicolay");
        assertEquals( dirlo.getFonction(),"directeur");  
        System.out.println("T0 : Initialisation directeur OK.");
    }  

    //Test initialisation d'un comptable en testant tout ses attributs
    @Test
    public void T1_TestInitComptable() {
        Personnes compt = PersonnesFactory.getPers(idCom, prenomCom, nomCom, fonction2);
        assertEquals( compt.getNumeroNational(),"4567");
        assertEquals( compt.getPrenom(),"Jecompte");
        assertEquals( compt.getNom(),"Bien");
        assertEquals( compt.getFonction(),"comptable");
        System.out.println("T1 : Initialisation comptable OK.");
    }

    //Test initialisation d'un secretaire en testant tout ses attributs
    @Test
    public void T2_TestInitSecretaire() {
        Personnes secr = PersonnesFactory.getPers(idSec, prenomSec, nomSec, fonction3);
        assertEquals( secr.getNumeroNational(),"9874");
        assertEquals( secr.getPrenom(),"Mimi");
        assertEquals( secr.getNom(),"Lafrappe");
        assertEquals( secr.getFonction(),"secretaire");
        System.out.println("T2 : Initialisation secretaire OK.");
    }

    //Test initialisation d'un ouvrier en testant tout ses attributs
    @Test
    public void T3_TestInitOuvrier() {
        Personnes ouvr = PersonnesFactory.getPers(idOuv, prenomOuv, nomOuv, fonction4);
        assertEquals( ouvr.getNumeroNational(),"4561");
        assertEquals( ouvr.getPrenom(),"Gege");
        assertEquals( ouvr.getNom(),"Lapelle");
        assertEquals( ouvr.getFonction(),"ouvrier");
        System.out.println("T3 : Initialisation ouvrier OK.");
    }
}
