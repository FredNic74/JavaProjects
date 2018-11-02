package be.iepscfjemelle.poolabo.nicolay.entreprise2withcollections;

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
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class IntroDonneesSaveBin implements Prog {

    /**
     * Tableau de int qui servira pour boucler autant de fois qu'il y a
     * d'employé dans l'entreprise
     */
    public int[] tableau = null;

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
        //dimensionnement de mon tableau  avec ma méthode taille tableau
        this.tableau = new int[tailleTableau()];
        for (int i = 0; i < tableau.length; i++) {

            int choix = menuFonction();//Appel de ma méthode MenuFonction     

            System.out.println("\n");
            //Switch pour remplir les attributs d'une classe en fonction du choix fait avant           
            switch (choix) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    Personnes directeur = new Directeur();
                    System.out.println("Entrer les informations demandée sur le directeur:  ");
                    System.out.print("Numéro National: ");
                    directeur.setNumeroNational(Clavier.lireString());
                    System.out.print("Prénom: ");
                    directeur.setPrenom(Clavier.lireString());
                    System.out.print("Nom: ");
                    directeur.setNom(Clavier.lireString());
                    System.out.println("Fonction: " + mesFonctions.get(choix));
                    directeur.setFonction(mesFonctions.get(choix));//Utilisation de la clé du HashMap pour définir la fonction
                    //condition ajout de l'objet, si le nom existe déjà, msg erreur et demande à nouveau les attributs du nouvel employé
                    if (hset.add(directeur)) {
                    } else {
                        System.out.println("Cet employé occupe déjà une fonction dans l'entreprise.\n");
                        i--;
                    }
                    System.out.println("\n");
                    break;
                case 2:
                    Personnes comptable = new Comptable();
                    System.out.println("Entrer les informations demandée sur le comptable:  ");
                    System.out.print("Numéro National: ");
                    comptable.setNumeroNational(Clavier.lireString());
                    System.out.print("Prénom: ");
                    comptable.setPrenom(Clavier.lireString());
                    System.out.print("Nom: ");
                    comptable.setNom(Clavier.lireString());
                    System.out.println("Fonction: " + mesFonctions.get(choix));
                    comptable.setFonction(mesFonctions.get(choix));//Utilisation de la clé du HashMap pour définir la fonction
                    //condition ajout de l'objet, si le nom existe déjà, msg erreur et demande à nouveau les attributs du nouvel employé
                    if (hset.add(comptable)) {
                    } else {
                        System.out.println("Cet employé occupe déjà une fonction dans l'entreprise.\n");
                        i--;
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    Personnes secretaire = new Secretaire();
                    System.out.println("Entrer les informations demandée sur la/le secretaire:  ");
                    System.out.print("Numéro National: ");
                    secretaire.setNumeroNational(Clavier.lireString());
                    System.out.print("Prénom: ");
                    secretaire.setPrenom(Clavier.lireString());
                    System.out.print("Nom: ");
                    secretaire.setNom(Clavier.lireString());
                    System.out.println("Fonction: " + mesFonctions.get(choix));
                    secretaire.setFonction(mesFonctions.get(choix));//Utilisation de la clé du HashMap pour définir la fonction
                    //condition ajout de l'objet, si le nom existe déjà, msg erreur et demande à nouveau les attributs du nouvel employé
                    if (hset.add(secretaire)) {
                    } else {
                        System.out.println("Cet employé occupe déjà une fonction dans l'entreprise.\n");
                        i--;
                    }
                    System.out.println("\n");
                    break;
                case 4:
                    Personnes ouvrier = new Ouvrier();
                    System.out.println("Entrer les informations demandée sur l'ouvrier:  ");
                    System.out.print("Numéro National: ");
                    ouvrier.setNumeroNational(Clavier.lireString());
                    System.out.print("Prénom: ");
                    ouvrier.setPrenom(Clavier.lireString());
                    System.out.print("Nom: ");
                    ouvrier.setNom(Clavier.lireString());
                    System.out.println("Fonction: " + mesFonctions.get(choix));
                    ouvrier.setFonction(mesFonctions.get(choix));//Utilisation de la clé du HashMap pour définir la fonction
                    //condition ajout de l'objet, si le nom existe déjà, msg erreur et demande à nouveau les attributs du nouvel employé
                    if (hset.add(ouvrier)) {
                    } else {
                        System.out.println("Cet employé occupe déjà une fonction dans l'entreprise.\n");
                        i--;
                    }
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
     * Méthode pour choisir le nombre d'employé et donc la taille de mon tableau
     *
     * @return
     */
    private int tailleTableau() {
        int taille;
        System.out.print("Entrer le nombre d'employé dans l'entreprise: ");
        taille = Clavier.lireInt();
        return taille;
    }
}
