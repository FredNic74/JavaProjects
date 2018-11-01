package be.iepscfjemelle.poolabo.nicolay.entreprise2withcollections;

import java.io.Serializable;

/**
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class Ouvrier extends Personnes implements Serializable{
    
    // ***********************  Attributs ***************************************
    /**
     * Attributs spécifique a l'ouvrier
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
    public Ouvrier(String numeroNational, String prenom, String nom, String fonction) {
        super(numeroNational, prenom, nom, fonction);
    }

    /**
     * Constructeur par défaut
     */
    public Ouvrier() {
    }

    //**************************** Getters and setters ***********************************************
    
    //******************************* Méthodes ******************************************
    /**
     * Méthodes à overrider
     */
    @Override
    public void joue() {
        System.out.println("Joue au football.");    
    }

    @Override
    public void manger() {
        System.out.println("Mange sur le chantier .");    
    }
    
    /**
     * Mise en forme de mon affichage
     * @return 
     */
    @Override
    public String toString() {
        return "Numéro National: " + this.numeroNational + ", Prénom: " + this.prenom + 
                ", Nom: " + this.nom + ", Fonction: " + this.fonction + ", Job description: travail sur chantier.";
    }
}
