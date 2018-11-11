package be.iepscfjemelle.poolabo.nicolay.entreprise2withcollections;

import java.io.Serializable;

/**
 * Classe d'objet comptable, qui hérite de l'objet personnes (interface et abstrait)
 * 
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class Comptable extends Personnes implements Serializable{
    
    // ***********************  Attributs ***************************************
    /**
     * Attributs spécifique au Comptable
     */
    

    // ***********************  Constructeurs ***************************************
    /**
     * Constructeur avec paramètres
     *
     * @param numeroNational
     * @param prenom
     * @param nom
     * @param fonction
     */
    public Comptable(String numeroNational, String prenom, String nom, String fonction) {
        super(numeroNational, prenom, nom, fonction);
    }

    /**
     * Constructeur par défaut
     */
    public Comptable() {
    }

    //******************************** Getters and setters *******************************************
    

    //******************************* Méthodes ******************************************
    /**
     * Méthodes à overrider
     */
    @Override
    public void joue() {
        System.out.println("Joue au tennis.");    
    }

    @Override
    public void manger() {
    System.out.println("Mange au restaurant avec le directeur."); 
    }
    
    /**
     * Mise en forme de mon affichage
     * @return 
     */
    @Override
    public String toString() {
        return "Numéro National: " + this.numeroNational + ", Prénom: " + this.prenom + 
                ", Nom: " + this.nom + ", Fonction: " + this.fonction + ", Job description: s'occupe de la facturation.";
    }   
}
