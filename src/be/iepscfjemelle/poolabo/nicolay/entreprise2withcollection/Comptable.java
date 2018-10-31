package be.iepscfjemelle.poolabo.nicolay.entreprise2withcollection;

import java.io.Serializable;

/**
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class Comptable extends Personnes implements Serializable{
    
    // ***********************  Attributs ***************************************
    /**
     * Attributs spécifique au Comptable
     */
    public String fonction = "Comptable";

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
        super(numeroNational, prenom, nom);
        this.fonction = fonction;
    }

    /**
     * Constructeur par défaut
     */
    public Comptable() {
    }

    //******************************** Getters and setters *******************************************
    /**
     * Getters and Setters propore à cette Classe 
     * @return
     */
    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

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
