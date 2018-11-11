package be.iepscfjemelle.poolabo.nicolay.entreprise2withcollections;

import java.io.Serializable;

/**
 * Classe d'objet directeur, qui hérite de l'objet personnes (interface et abstrait)
 * 
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class Directeur extends Personnes implements Serializable{
    // ***********************  Attributs ***************************************
    /**
     * Attributs spécifique au Directeur
     */
    public String portefeuille = "Ca frôle l'indécence!";;
    //public String fonction = "Directeur";
    
    // ***********************  Constructeurs ***************************************
    /**
     * Constructeur avec paramètres
     *
     * @param numeroNational
     * @param prenom
     * @param nom
     * @param fonction
     * @param portefeuille
     */  
    public Directeur(String numeroNational, String prenom, String nom, String fonction, String portefeuille) {
        super(numeroNational, prenom, nom, fonction);//Super pour reprendre les attributs de la classe parent (Personnes) dans le constructeur
        this.portefeuille = portefeuille;//ajout des deux attributs spécifique à cette classe dans le constructeur.
    }

    /**
     * Constructeur par défaut
     */
    public Directeur() {
    }
    
    //******************************* Getters and setters ********************************************
    /**
     * Getters and Setters propore à cette Classe
     * @return
     */
    public String getPortefeuille() {
        return portefeuille;
    }
    
    public void setPortefeuille(String portefeuille) {
        this.portefeuille = portefeuille;
    }
    
    //******************************* Méthodes ******************************************
    /**
     * Méthodes à overrider
     */
    @Override
    public void joue() {
        System.out.println("Joue au golf.");     
    }

    @Override
    public void manger() {
    System.out.println("Mange au restaurant."); 
    }
    
    /**
     * Mise en forme de mon affichage
     * @return 
     */
    @Override
    public String toString() {
        return "Numéro National: " + this.numeroNational + ", Prénom: " + this.prenom + 
                ", Nom: " + this.nom + ", Fonction: " + this.fonction + ", Portefeuille: " + this.portefeuille 
                + ", Job description: Dirige la société.";
    } 
}
