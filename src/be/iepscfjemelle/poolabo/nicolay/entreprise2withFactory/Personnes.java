package be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe abstraite de l'objet Personnes, contenant les attributs et méthodes d'une personnes.
 * 
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public abstract class Personnes implements  Serializable {

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
     * Méthodes Overridé
     */
    
    public abstract void joue();

    
    public abstract void manger();

    /**
     * Méthode hashCode pour mon hashset
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.nom);
        return hash;
    }
    
    /**
     * Méthode equals pour mon hashset
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }      
        final Personnes other = (Personnes) obj;
        return Objects.equals(this.nom, other.nom);
    }    
}
