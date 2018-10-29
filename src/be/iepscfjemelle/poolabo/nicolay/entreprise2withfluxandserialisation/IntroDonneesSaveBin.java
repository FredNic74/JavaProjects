package be.iepscfjemelle.poolabo.nicolay.entreprise2withfluxandserialisation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class IntroDonneesSaveBin implements Prog {

    /**
     * Tableau d'objets Personnes
     */
    public Personnes[] tabPersonnel = null;

    /**
     * Methode qui remplis mon tableau et les attributs de chaques employés
     *
     */
    @Override
    public void execute(MenuDepart programme) {

        ObjectOutputStream sortie = null;
        try {//Gestion des erreurs ajouté automatiquement par Netbeans  
            //dimensionnement de mon tableau de personnel avec ma méthode taille tableau
            this.tabPersonnel = new Personnes[tailleTableau()];
            for (int i = 0; i < tabPersonnel.length; i++) {

                int choix = menuFonction();//Appel de ma méthode MenuFonction
                System.out.println("\n");
                //Switch pour remplir les attributs d'une classe en fonction du choix fait avant
                //A FAIRE: CREER DES VARIABLES NUMNATIONAL,PRENOM,NOM ET LES UTILISER COMME PARAMETRE DANS MON CONSTRUCTEUR PERSONNE OU DIRECTEUR VOIR SAMPLE ROMU ENTREPRISE2
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
                        this.tabPersonnel[i] = directeur;
                        directeur = null;
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
                        this.tabPersonnel[i] = comptable;
                        comptable = null;
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
                        this.tabPersonnel[i] = secretaire;
                        secretaire = null;
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
                        this.tabPersonnel[i] = ouvrier;
                        ouvrier = null;
                        System.out.println("\n");
                        break;
                    case 5:
                        programme.showMenuDépart();
                    default:
                        this.menuFonction();
                }
            }
            this.saveDataTab(this.tabPersonnel);//appel de la méthode de sauvegarde en fichier binaire
            this.endProg(programme);//appel de la méthode fin de programme

            //Gestion des erreurs ajouté automatiquement par Netbeans ?????  
        } catch (IOException ex) {
            Logger.getLogger(IntroDonneesSaveBin.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * Méthode pour sauvegarder en binaire les objets de mon tableau(flux de sortie d'objet)
     *
     * @param tableau
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void saveDataTab(Personnes[] tableau) throws FileNotFoundException, IOException {
        try (ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream("fichier.dat"))) {
            for (Personnes tabPersonnel1 : tabPersonnel) {
                sortie.writeObject(tabPersonnel1);
            }
        }
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
