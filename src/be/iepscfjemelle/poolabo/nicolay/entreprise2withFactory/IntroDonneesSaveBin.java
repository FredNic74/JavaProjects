package be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe héritant de l'interface Prog, qui à partir d'un menu secondaire, crée
 * des objets Personnes et leurs attributs via un factory, (fonctions d'après un hashmap).
 * Places ces objets Personnes dans un hashset, pour éviter les doublons.
 * Ensuite, parcours le hashset, sérialise chaque ojets et l'enregistre dans un
 * fichier binaire. Propose un retour au menu principal à la fin.
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class IntroDonneesSaveBin implements Prog {

    /**
     * Methode qui remplis mon hashset et les attributs de chaques employés
     *
     */
    @Override
    public void execute(MenuDepart programme) {
        //Création d'une haspMap qui définira la fonction d'un objet
        HashMap<Integer, String> mesFonctions = new HashMap<>();
        // Insertion des valeurs dans la hashmap
        mesFonctions.put(1, "Directeur");
        mesFonctions.put(2, "Comptable");
        mesFonctions.put(3, "Secretaire");
        mesFonctions.put(4, "Ouvrier");

        // Création d'un hashSet d'objets Personnes
        HashSet<Personnes> hset = new HashSet<>();

        ObjectOutputStream sortie = null;

        int nbr = nombreEmploye();//nombre d'employé dans l'entreprise pour définir le nombre de boucles      

        for (int i = 0; i < nbr; i++) {
            int choix = menuFonction();//Appel de ma méthode MenuFonction    
            //Lecture des données de chaque employé dans la console pour remplir les attributs de chaque objet Personnes
            System.out.println("Entrer les informations demandée sur l'employé:  ");
            System.out.print("Numéro National: ");
            String numeroNational = Clavier.lireString();
            System.out.print("Prénom: ");
            String prenom = Clavier.lireString();
            System.out.print("Nom: ");
            String nom = Clavier.lireString();
            System.out.println("Fonction: " + mesFonctions.get(choix));
            String fonction = mesFonctions.get(choix);
            System.out.println("\n");
            //Switch pour remplir les attributs d'une classe en fonction du choix fait avant           
            switch (choix) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    Directeur directeur = (Directeur) PersonnesFactory.getPers(numeroNational, prenom, nom, fonction);//utilisation du factory                  
                    i = ajoutPersonneToList(directeur, hset)? i : i-1;//appel la méthode ajoutPersonne ToList avec ternaire                 
                    System.out.println("\n");
                    break;
                case 2:
                    Comptable comptable = (Comptable) PersonnesFactory.getPers(numeroNational, prenom, nom, fonction);//utilisation du factory
                    i = ajoutPersonneToList(comptable, hset) ? i : i - 1;//appel la méthode ajoutPersonne ToList avec ternaire                  
                    System.out.println("\n");
                    break;
                case 3:
                    Secretaire secretaire = (Secretaire) PersonnesFactory.getPers(numeroNational, prenom, nom, fonction);//utilisation du factory                
                    i = ajoutPersonneToList(secretaire, hset) ? i : i - 1;//appel la méthode ajoutPersonne ToList avec ternaire                
                    System.out.println("\n");
                    break;
                case 4:
                    Ouvrier ouvrier = (Ouvrier) PersonnesFactory.getPers(numeroNational, prenom, nom, fonction);//utilisation du factory               
                    i = ajoutPersonneToList(ouvrier, hset) ? i : i - 1;//appel la méthode ajoutPersonne ToList avec ternaire                   
                    System.out.println("\n");
                    break;
                case 5:
                    programme.showMenuDépart();
                default:
                    this.menuFonction();
            }
        }

        try {
            saveDataHset(hset);//appel de ma méthode saveDataHset
        } catch (IOException ex) {
            Logger.getLogger(IntroDonneesSaveBin.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.endProg(programme);//appel de la méthode fin de programme
    }

    //****************************************Méthodes*****************************************************  
    /**
     * Méthode avec condition ajout de l'objet, si le nom existe déjà, msg
     * erreur et demande à nouveau les attributs du nouvel employé.
     *
     * @param pers
     * @param hset
     * @return
     */
    private boolean ajoutPersonneToList(Personnes pers, HashSet<Personnes> hset) {
        if (hset.add(pers)) {
            return true;
        } else {
            System.out.println("Cet employé occupe déjà une fonction dans l'entreprise.\n");
            System.out.println("Veuillez rentrer à nouveau les informations sur l'employé.\n");
            return false;
        }
    }

    /**
     * Méthode qui parcour mon hashset via un itérateur et encode mes objets
     * Personnes dans un fichier binaire
     *
     * @param hs
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void saveDataHset(HashSet<Personnes> hs) throws FileNotFoundException, IOException {
        // Création d'un itérateur
        Iterator<Personnes> iter = hs.iterator();
        ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream("fichier.dat"));
        // Boucle tant qu'il y a un objet dans le hashset
        while (iter.hasNext()) {
            Personnes empl = iter.next();
            sortie.writeObject(empl);
        }
        System.out.println();
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

    /**
     * Méthode pour choisir la fonction, quitter ou retour au menu principale
     *
     * @return
     */
    private int menuFonction() {
        System.out.println("Veuillez choisir un chiffre dans la liste ci-dessous: ");
        System.out.println("0  ==> Quitter");
        System.out.println("1  ==> Directeur");
        System.out.println("2  ==> Comptable");
        System.out.println("3  ==> Secretaire");
        System.out.println("4  ==> Ouvrier");
        System.out.println("5  ==> Retour au menu de départ");
        System.out.print("Votre choix: ");
        int choix;
        choix = (Clavier.lireInt());
        return choix;
    }

    /**
     * Méthode pour choisir le nombre d'employé et renvoyé un int
     *
     * @return
     */
    private int nombreEmploye() {
        int taille;
        System.out.print("Entrer le nombre d'employé dans l'entreprise: ");
        taille = Clavier.lireInt();
        return taille;
    }
}
