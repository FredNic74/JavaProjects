package be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory;

/**
 * Classe de mon menu de départ, qui permet de faire 4 choix:
 * 1. créer et introduire les données des employés, les sérialiser et les copier dans un fichier binaire
 * 2. lire un fichier binaire, désérialiser et afficher dans la console
 * 3. lire un fichier binaire et mettre tout nos employés dans un fichier texte
 * 4. Quitter et sortir du programme
 * 
 * Chacun des choix, va lancer une classe différente.
 * 
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class MenuDepart {
    
    /**
     * Choix sélectionné
     */
    private int choix;
    
    /**
     * Affichage du menu et Execute les méthodes d'une des Classe en fonction du choix
     */
    public void showMenuDépart(){

        System.out.println("Faite votre choix dans le menu ci-dessous.");
        System.out.println("-----------------------------");      
        System.out.println("1. Introduire les données des employés et les sérialiser.");
        System.out.println("2. Lire les employés et les afficher dans la console.");
        System.out.println("3. Sauvegarder les employés sur le disque dur, dans un fichier texte.");
        System.out.println("4. Quitter");
        System.out.println("Entrez votre choix: ");

        this.choix = Clavier.lireInt();

        switch (choix) {
            case 1:
                Prog programme1 = new IntroDonneesSaveBin();
                programme1.execute(this);
                break;
            case 2:
                Prog programme2 = new AffichageConsole();
                programme2.execute(this);
                break;
            case 3:
                Prog programme3 = new WrFichierTexte();
                programme3.execute(this);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                this.showMenuDépart();
                break;

        }
    }
}
