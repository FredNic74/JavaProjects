package be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory;

/**
 * Classe starter, qui contient la méthode main, qui crée l'objet MenuDepart
 * et lance mon programme.
 * 
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class Starter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Création d'un objet MenuDépart
        MenuDepart monProgramme = new MenuDepart();
        // Appel méthode ShowMenuDépart qui lance le programme avec différents choix
        monProgramme.showMenuDépart();        
    }
}
