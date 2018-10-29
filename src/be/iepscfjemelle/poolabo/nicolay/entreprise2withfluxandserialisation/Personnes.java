package be.iepscfjemelle.poolabo.nicolay.entreprise2withfluxandserialisation;

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
    
    // ***********************  Constructeurs ***************************************
    /**
     * Constructeur avec paramètres
     *
     * @param numeroNational
     * @param prenom
     * @param nom
     */
    public Personnes(String numeroNational, String prenom, String nom) {
        this.numeroNational = numeroNational;
        this.prenom = prenom;
        this.nom = nom;
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
    
//******************************* Méthodes ******************************************
    /**
     * Méthodes
     */
    @Override
    public abstract void joue();

    @Override
    public abstract void manger();
    
}
