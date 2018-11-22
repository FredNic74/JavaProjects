package TestsEntreprise;

import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.IntroDonneesSaveBin;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Personnes;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.PersonnesFactory;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.WrFichierTexte;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Class de test qui crée et initialise des objets, les stock dans un Hashset
 * (Test0) Pour tester la sérialisation, j'utilise ma méthode
 * ajoutPersonneToList si elle me renvoi true, l'objet est ajouter à ma hashset
 * et sérialisé. Enfin, pour tester la désérialisation, j'utilise m méthode
 * readPutArray et ensuite, je vais voir combien d'objet son stocker dans
 * l'Arraylist.
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//permet de choisir l'ordre des méthodes
public class TestSerialDeserial {

    //Déclaration et inistialisation de mes variables
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
    HashSet<Personnes> hset = new HashSet();//création d'un HashSet, pour y stocker mes objets créé avant sérialisation
    ArrayList<Personnes> al = new ArrayList<>();
    private Personnes directeur;
    private Personnes comptable;
    private Personnes ouvrier;
    private Personnes secretaire;
    private Personnes pers;

    //Test qui initialise objets, les place dns une hashset et contrôle s'il y a bien 4 objets dans ma hashset.  
    @Test
    public void T0_creationObjets() {//façon de nommer les tests, pour voir leur ordre d'exécution
        directeur = PersonnesFactory.getPers(idDir, prenomDir, nomDir, fonction1);
        hset.add(directeur);
        comptable = PersonnesFactory.getPers(idCom, prenomCom, nomCOm, fonction2);
        hset.add(comptable);
        secretaire = PersonnesFactory.getPers(idSec, prenomSec, nomSec, fonction3);
        hset.add(secretaire);
        ouvrier = PersonnesFactory.getPers(idOuv, prenomOuv, nomOuv, fonction4);
        hset.add(ouvrier);
        assertEquals(hset.size(), 4);//Test si objets ont bien été créé et rentré dans ma hashset 
        System.out.println("T0 : Création d'objets ok.");
        hset = new HashSet<>();//remise à zéro de ma hashset
    }

    //Test qui crée un objet de ma classe IntroDonneesSaveBin, et test si celle-ci ajoute bien mes objet à la hashset et les sérialise
    @Test
    public void T1_SerialisationDirecteur() throws FileNotFoundException, IOException {
        IntroDonneesSaveBin obj = new IntroDonneesSaveBin();
        Boolean ajout = obj.ajoutPersonneToList(directeur, hset);//variablr booleen qui va me servir à récupérer ce que ma méthode ajoutPersonneToList me renvoi.
        Assert.assertTrue(ajout);//Si ma variable booleen est vrai alors mon objet à bien été introduit dans ma hashset et sérialisé
        System.out.println("T1 : Directeur ajouté et sérialisé.");
        hset = new HashSet<>();//remise à zéro de ma hashset
    }

    //Test qui crée un objet de ma classe IntroDonneesSaveBin, et test si celle-ci ajoute bien mes objet à la hashset et les sérialise
    @Test
    public void T2_SerialisationComptable() throws FileNotFoundException, IOException {
        IntroDonneesSaveBin obj = new IntroDonneesSaveBin();
        Boolean ajout = obj.ajoutPersonneToList(comptable, hset);//variablr booleen qui va me servir à récupérer ce que ma méthode ajoutPersonneToList me renvoi.
        Assert.assertTrue(ajout);//Si ma variable booleen est vrai alors mon objet à bien été introduit dans ma hashset et sérialisé
        System.out.println("T2 : Comptable ajouté et sérialisé.");
        hset = new HashSet<>();//remise à zéro de ma hashset
    }

    //Test qui crée un objet de ma classe IntroDonneesSaveBin, et test si celle-ci ajoute bien mes objet à la hashset et les sérialise
    @Test
    public void T3_SerialisationSecretaire() throws FileNotFoundException, IOException {
        IntroDonneesSaveBin obj = new IntroDonneesSaveBin();
        Boolean ajout = obj.ajoutPersonneToList(secretaire, hset);//variablr booleen qui va me servir à récupérer ce que ma méthode ajoutPersonneToList me renvoi.
        Assert.assertTrue(ajout);//Si ma variable booleen est vrai alors mon objet à bien été introduit dans ma hashset et sérialisé
        System.out.println("T3 : Secretaire ajouté et sérialisé.");
        hset = new HashSet<>();//remise à zéro de ma hashset
    }

    //Test qui crée un objet de ma classe IntroDonneesSaveBin, et test si celle-ci ajoute bien mes objet à la hashset et les sérialise
    @Test
    public void T4_SerialisationOuvrier() throws FileNotFoundException, IOException {
        IntroDonneesSaveBin obj = new IntroDonneesSaveBin();
        Boolean ajout = obj.ajoutPersonneToList(ouvrier, hset);//variablr booleen qui va me servir à récupérer ce que ma méthode ajoutPersonneToList me renvoi.
        Assert.assertTrue(ajout);//Si ma variable booleen est vrai alors mon objet à bien été introduit dans ma hashset et sérialisé
        System.out.println("T4 : Ouvrier ajouté et sérialisé.");
        hset = new HashSet<>();//remise à zéro de ma hashset
    }

    /*Test qui crée un objet de ma classe WrFichierText, lis le fichier binaire tant qu'il y a des objets dedans. 
     * Ensuite, test le nombre d'objet présent dans l'Arraylist et donc qu'il se sont bien deserialise.*/
    @Test
    public void T5_Deserialisation() throws IOException, ClassNotFoundException {
        WrFichierTexte obj = new WrFichierTexte();
        al = obj.readPutArray();
        assertEquals(al.size(), 4);//Test le nombre d'objet présent dans mon Arraylist
        System.out.println("T5 : Objets désérialisés.");
    }
}
