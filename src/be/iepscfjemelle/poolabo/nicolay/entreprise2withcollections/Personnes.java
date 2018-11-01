package be.iepscfjemelle.poolabo.nicolay.entreprise2withcollections;

import java.io.Serializable;

/**
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public abstract class Personnes implements IntPersonne, Serializable{
    // ***********************   Attributs  ***************************************
    /**
     * Numero national de la personne
     */
    public String numeroNational;
    /**
     * Prénom de la personne
     */
    public String prenom;
    /**
     * Nom de la personne
     */
    public String nom;
    /**
     * Fonction de la personne
     */
    public String fonction;
    
    
    // ***********************  Constructeurs ***************************************
    /**
     * Constructeur avec paramètres
     *
     * @param numeroNational
     * @param prenom
     * @param nom
     * @param fonction
     */
    public Personnes(String numeroNational, String prenom, String nom, String fonction) {
        this.numeroNational = numeroNational;
        this.prenom = prenom;
        this.nom = nom;
        this.fonction = fonction;
    }
    
    /**
     * Constructeur par défaut
     */
    public Personnes() {
    }
    
    // *********************** Getters and setters *********************************
    /**
     * Getters and Setters commun à toutes les classes
     * @return
     */
    public String getNumeroNational() {
        return numeroNational;
    }

    public void setNumeroNational(String numeroNational) {
        this.numeroNational = numeroNational;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    
//******************************* Méthodes ******************************************
    /**
     * Méthodes
     */
    @Override
    public abstract void joue();

    @Override
    public abstract void manger();

}
