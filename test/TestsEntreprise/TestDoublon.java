package TestsEntreprise;

import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.IntroDonneesSaveBin;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Personnes;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.PersonnesFactory;
import java.util.HashSet;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Class qui test l'introduction de doublon
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//permet de choisir l'ordre des méthodes

public class TestDoublon {

    HashSet<Personnes> hset = new HashSet<>();
    public String fonction1 = "directeur";
    public String fonction2 = "comptable";
    public String fonction3 = "secretaire";
    public String fonction4 = "ouvrier";
    public String id = "1234";
    public String prenom = "Fred";
    public String nom = "Nicolay";

    /*Test qui crée un objet de ma class IntroDonneesSaveBin , si la variable booléenne de la deuxième 
    personne est False, alors c'est un doublon.*/
    @Test
    public void T0_TestDuplicateDirecteur() {
        IntroDonneesSaveBin obj = new IntroDonneesSaveBin();
        Personnes directeur = PersonnesFactory.getPers(id, prenom, nom, fonction1);
        Boolean ajout1 = obj.ajoutPersonneToList(directeur, hset);
        Personnes directeur2 = PersonnesFactory.getPers(id, prenom, nom, fonction1);
        Boolean ajout2 = obj.ajoutPersonneToList(directeur2, hset);
        Assert.assertFalse(ajout2);//Test si ajout2 est faux
        System.out.println("T0 : Deuxième directeur pas ajouté, car doublon.");
        hset = new HashSet<>();//remise à zéro de ma hashset
    }
    
    //idem que premier test mais pour un comptable
    @Test
    public void T1_TestDuplicateComptable() {
        IntroDonneesSaveBin obj = new IntroDonneesSaveBin();
        Personnes comptabe = PersonnesFactory.getPers(id, prenom, nom, fonction2);
        Boolean ajout1 = obj.ajoutPersonneToList(comptabe, hset);
        Personnes comptabe2 = PersonnesFactory.getPers(id, prenom, nom, fonction2);
        Boolean ajout2 = obj.ajoutPersonneToList(comptabe2, hset);
        Assert.assertFalse(ajout2);//Test si ajout2 est faux
        System.out.println("T1 : Deuxième comptable pas ajouté, car doublon.");
        hset = new HashSet<>();//remise à zéro de ma hashset
    }

    //idem que premier test mais pour un secretaire
    @Test
    public void T2_TestDuplicateSecretaire() {
        IntroDonneesSaveBin obj = new IntroDonneesSaveBin();
        Personnes secretaire = PersonnesFactory.getPers(id, prenom, nom, fonction3);
        Boolean ajout1 = obj.ajoutPersonneToList(secretaire, hset);
        Personnes secretaire2 = PersonnesFactory.getPers(id, prenom, nom, fonction3);
        Boolean ajout2 = obj.ajoutPersonneToList(secretaire2, hset);
        Assert.assertFalse(ajout2);//Test si ajout2 est faux
        System.out.println("T0 : Deuxième secretaire pas ajouté, car doublon.");
        hset = new HashSet<>();//remise à zéro de ma hashset
    }

    //idem que premier test mais pour un ouvrier
    @Test
    public void T3_TestDuplicateOuvrier() {
        IntroDonneesSaveBin obj = new IntroDonneesSaveBin();
        Personnes ouvrier = PersonnesFactory.getPers(id, prenom, nom, fonction4);
        Boolean ajout1 = obj.ajoutPersonneToList(ouvrier, hset);
        Personnes ouvrier2 = PersonnesFactory.getPers(id, prenom, nom, fonction4);
        Boolean ajout2 = obj.ajoutPersonneToList(ouvrier2, hset);
        Assert.assertFalse(ajout2);//Test si ajout2 est faux
        System.out.println("T0 : Deuxième ouvrier pas ajouté, car doublon.");
        hset = new HashSet<>();//remise à zéro de ma hashset
    }
}
