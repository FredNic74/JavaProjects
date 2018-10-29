package be.iepscfjemelle.poolabo.nicolay.entreprise2withfluxandserialisation;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
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
     * Arraylist pour y stocker les objet lu dans le fichier binair, s'adaptera
     * au nombre d'objet
     *
     * @param programme
     */
    ArrayList al = new ArrayList();

    /**
     * Méthode qui lis un fichier binaire, stock les objets personnes dans une ArrayList,
     * ensuite parcours de l'arraylist pour écrire les objets dans un fichier texte.
     * @param programme 
     */
    @Override
    public void execute(MenuDepart programme) {
        ObjectInputStream entree = null;
        try {

            // Crétion du flux d'entrée
            entree = new ObjectInputStream(new FileInputStream("fichier.dat"));

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
            
            // Initialisation des variables
            this.nomfich = "fichier.txt";
            // Création du flux de sortie vers un fichier texte
            PrintWriter sortie = new PrintWriter(new FileWriter(nomfich));
            
            //Boucle qui récupère mes objets dans mon ArrayList et les mets dans mon fichier.txt ouvert.
            for(int i=0; i<al.size(); i++){
                sortie.println(al.get(i));
            }
            System.out.println("Vous trouverez le fichier.txt dans les répertoires du programme.\n");
            // Fermeture du flux
            sortie.close();
            this.endProg(programme);//appel de la méthode fin de programme
            //Gestion des erreurs ajouté automatiquement par Netbeans ?????  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AffichageConsole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AffichageConsole.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
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
