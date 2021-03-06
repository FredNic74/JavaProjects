package be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe héritant de l'interface Prog, récupère et désérialise les objets
 * Personnes dans un fichier binaire. Les places dans une Arraylist, parcour cet
 * Arraylist et resérialise chaque objet Personne, pour les placer cette fois-ci
 * dans un fichier texte. Propose un retour au menu principal à la fin.
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class WrFichierTexte implements Prog {

    /**
     * Objet pour récuperer chaque objet du fichier binaire
     */
    protected Personnes pers;

    /**
     * Booléen de contrôle de boucle
     */
    protected boolean flag = false;

    /**
     * Nom du fichier utilisé
     */
    private String nomfich;

    /**
     * Arraylist pour y stocker les objet lu dans le fichier binaire, s'adaptera
     * au nombre d'objet
     *
     * @param programme
     */
    ArrayList<Personnes> al = new ArrayList();

    /**
     * Méthode qui lis un fichier binaire, stock les objets personnes dans une
     * ArrayList, ensuite parcours de l'arraylist pour écrire les objets dans un
     * fichier texte.
     *
     * @param programme
     */
    @Override
    public void execute(MenuDepart programme) {
        try {
            readPutArray();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(WrFichierTexte.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Initialisation des variables
        this.nomfich = "fichier.txt";

        try ( // Création du flux de sortie vers un fichier texte
                PrintWriter sortie = new PrintWriter(new FileWriter(nomfich))) {
            //Boucle qui récupère mes objets dans mon ArrayList via un itérateur et les mets dans mon fichier.txt.
            Iterator<Personnes> iter = al.iterator();
            while (iter.hasNext()) {
                Personnes empl = iter.next();
                sortie.println(empl);
            }

            System.out.println("Vous trouverez le fichier.txt dans les répertoires du programme.\n");
            // Fermeture du flux
        } catch (IOException ex) {
            Logger.getLogger(WrFichierTexte.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.endProg(programme);//appel de la méthode fin de programme         
    }

    //*********************************************Méthodes**************************************************
    /**
     * Méthode qui lis un fichier binaire tant qu'il y a des objets dedans et
     * les met dans une arraylist.
     *
     * @return 
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ArrayList<Personnes> readPutArray() throws IOException, ClassNotFoundException {
        ObjectInputStream entree = null;

        try {
            // Crétion du flux d'entrée
            entree = new ObjectInputStream(new FileInputStream("fichier.dat"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WrFichierTexte.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Boucle de lecture du fichier binaire, sortie lorsu'il n'y a plus d'objet
        while (!flag) {
            try {
                // Lecture de l'objet
                pers = (Personnes) entree.readObject();
                // introduction de l'objet dans mon ArrayList
                al.add(pers);
            } catch (EOFException e) {
                // Sortie de boucle
                flag = true;
            }
        }
        entree.close();// Fermeture du flux  
        return al;
    }

    /**
     * Fin du programme, retour au menu principale
     *
     * @param programme
     */
    @Override
    public void endProg(MenuDepart programme) {
        System.out.println("Appuyer sur une touche pour retourner au menu.");
        String str = Clavier.lireString();
        programme.showMenuDépart();
    }
}
