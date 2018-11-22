package TestsEntreprise;

import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.AffichageConsole;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.IntroDonneesSaveBin;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Personnes;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.PersonnesFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Class de test qui crée et initialise des objets, les stock dans un Arraylist, les sérialise et les copie dans un fichier binaire. Ensuite lecture de ce fichier binaire, désérialisation et mise de
 * tous les objets dans une autre Arraylist. Pour finir comparaison des deux Arraylist.
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
    HashSet<Personnes> hsetBefore = new HashSet();//création d'un HashSet, pour y stocker mes objets créé avant sérialisation
    ArrayList<Personnes> alAfter = new ArrayList();//création d'un HashSet, pour y stocker mes objets après désérialisation
    ObjectOutputStream sortie = null;
    ObjectInputStream entree = null;
    private boolean flag;
    protected Personnes pers;

    private Personnes directeur;
    private Personnes comptable;
    private Personnes ouvrier;
    private Personnes Secretaire;

    //Test qui initialise objets, les place dns une hashset et contrôle s'il y a bien objet dans ma hashset.  
    @Test
    public void T0_creationObjets() {//façon de nommer les tests, pour voir leur ordre d'exécution
        directeur = PersonnesFactory.getPers(idDir, prenomDir, nomDir, fonction1);
        hsetBefore.add(directeur);
        comptable = PersonnesFactory.getPers(idCom, prenomCom, nomCOm, fonction2);
        hsetBefore.add(comptable);
        Secretaire = PersonnesFactory.getPers(idSec, prenomSec, nomSec, fonction3);
        hsetBefore.add(Secretaire);
        ouvrier = PersonnesFactory.getPers(idOuv, prenomOuv, nomOuv, fonction4);
        hsetBefore.add(ouvrier);
        assertEquals(hsetBefore.size(), 4);//Test si objets ont bien été créé et rentré dans ma hashset 
        System.out.println("T0 : Création d'objets ok.");
        hsetBefore = new HashSet<>();//remise à zéro de ma hashset
    }

    //Test qui crée un objet de ma classe IntroDonneesSaveBin, et test si celle-ci ajoute bien mes objet à la hashset et les sérialise
    @Test
    public void T1_Serialisation() throws FileNotFoundException, IOException {
        IntroDonneesSaveBin obj = new IntroDonneesSaveBin();
        Boolean ajout = obj.ajoutPersonneToList(directeur, hsetBefore);//variablr booleen qui va me servir à récupérer ce que ma méthode ajoutPersonneToList me renvoi.
        Assert.assertTrue(ajout);//Si ma variable booleen est vrai alors mon objet à bien été introduit dans ma hashset et sérialisé
        System.out.println("T1 : Directeur ajouté et sérialisé.");
    }
    
    @Test
    public void T2_Deserialisation(){
        AffichageConsole obj = new AffichageConsole();
        
    }

    //Test qui lis le fichier binaire, désérialise et place mes objets dans une autre Arraylist
    /*  @Test
    public void T2_Deserialisation() throws FileNotFoundException, IOException, ClassNotFoundException {
        //création du flux d'entrée
        entree = new ObjectInputStream(new FileInputStream("fichierTest.dat"));
        //Lis le fichier binaire tant qu'il y a des objets dedans
        while (!flag) {
            try {
                // Lecture de l'objet
                pers = (Personnes) entree.readObject();
                alAfter.add(pers);
                System.out.println(pers);

            } catch (EOFException e) {
                // Sortie de boucle
                flag = true;
            }
        }
        entree.close();// Fermeture du flux
    }

    //Test qui compare les deux Arraylist avant et après sérialisation.
    @Test
    public void T3_CompareAl() {
        assertEquals(alBefore, alAfter);
    }*/
}
