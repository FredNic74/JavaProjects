package be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe héritant de l'interface Prog, qui va lire des objets personne dans un
 * fichier binaire les désérialisent et les affiche dans la console. Propose un
 * retour au menu principal à la fin.
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class AffichageConsole implements Prog {

    /**
     * Objet pour récuperer chaque objet du fichier binaire
     */
    protected Personnes pers;

    /**
     * Booléen de contrôle de boucle
     */
    protected boolean flag = false;

    /**
     * Méthode qui parcour mon fichier binaire et affiche le contenu dans la console
     * 
     */
    @Override
    public void execute(MenuDepart programme) {
        try {
            readFile();
        } catch (IOException ex) {
            Logger.getLogger(AffichageConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.endProg(programme);//appel de la méthode fin de programme

    }

    //*****************************************Méthodes*************************************************
    /**
     * Méthode qui va lire un fichier binaire tant qu'il y a des objet dedans et
     * les affiche dans la console
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void readFile() throws FileNotFoundException, IOException {
        ObjectInputStream entree = null;

        System.out.println("================================================================");
        System.out.println("Liste des personnes de l'entreprise:");
        System.out.println("================================================================");

        // Crétion du flux d'entrée
        entree = new ObjectInputStream(new FileInputStream("fichier.dat"));

        // Boucle de lecture, sortie lorsu'il n'y a plus d'objet
        while (!flag) {
            try {
                // Lecture de l'objet
                pers = (Personnes) entree.readObject();
                // Affichage des caractéristiques de l'objet
                System.out.println(pers.toString());
                System.out.println("------------------------------------------------------------");
            } catch (EOFException e) {
                // Sortie de boucle
                flag = true;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AffichageConsole.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        entree.close();// Fermeture du flux
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
