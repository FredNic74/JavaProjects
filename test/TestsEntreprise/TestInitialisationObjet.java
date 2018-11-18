package TestsEntreprise;

import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Comptable;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Directeur;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Ouvrier;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Personnes;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.PersonnesFactory;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class TestInitialisationObjet {
   
        public String fonction1 = "directeur";
        public String fonction2 = "comptable";
        public String fonction3 = "secretaire";
        public String fonction4 = "ouvrier";
        public String idDir = "1234";
        public String prenomDir = "Fred";
        public String nomDir = "Nicolay";   
        public String idCom = "4567";
        public String prenomCom = "Jecompte";
        public String nomCOm = "Bien";  
        public String idSec = "9874";
        public String prenomSec = "Mimi";
        public String nomSec = "Lafrappe";  
        public String idOuv = "4561";
        public String prenomOuv = "Gege";
        public String nomOuv = "Lapelle";  
        ArrayList<Personnes> al = new ArrayList();
        
    @Test
    public void TestInitDirecteur() {    
        //PersonnesFactory pers= new PersonnesFactory();
        Personnes directeur = PersonnesFactory.getPers(idDir, prenomDir, nomDir, fonction1);
        Personnes dirlo = new Directeur();
        al.add(directeur);
        dirlo.setNumeroNational("1234");
        dirlo.setPrenom("Fred");
        dirlo.setNom("Nicolay");
        dirlo.setFonction("directeur");
        assertEquals(directeur, dirlo);
    }
    
    @Test
    public void TestInitComptable() {    
        //PersonnesFactory pers= new PersonnesFactory();
        Personnes comptable = PersonnesFactory.getPers(idCom, prenomCom, nomCOm, fonction2);
        Personnes compt = new Comptable();
        al.add(comptable);
        compt.setNumeroNational("4567");
        compt.setPrenom("Jecompte");
        compt.setNom("Bien");
        compt.setFonction("comptable");
        assertEquals(comptable, compt);
    }
    
    @Test
    public void TestInitSecretaire() {    
        //PersonnesFactory pers= new PersonnesFactory();
        Personnes Secretaire = PersonnesFactory.getPers(idSec, prenomSec, nomSec, fonction3);
        Personnes Secr = new Directeur();
        al.add(Secretaire);
        Secr.setNumeroNational("9874");
        Secr.setPrenom("Mimi");
        Secr.setNom("Lafrappe");
        Secr.setFonction("secretaire");
        assertEquals(Secretaire, Secr);
    }
    
    @Test
    public void TestInitOuvrier() {    
        //PersonnesFactory pers= new PersonnesFactory();
        Personnes ouvrier = PersonnesFactory.getPers(idOuv, prenomOuv, nomOuv, fonction4);
        Personnes ouv = new Ouvrier();
        al.add(ouvrier);
        ouv.setNumeroNational("4561");
        ouv.setPrenom("Gege");
        ouv.setNom("Lapelle");
        ouv.setFonction("ouvrier");
        assertEquals(ouvrier, ouv);
    }
}
