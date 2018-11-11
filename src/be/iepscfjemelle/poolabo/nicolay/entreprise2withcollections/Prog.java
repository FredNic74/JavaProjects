package be.iepscfjemelle.poolabo.nicolay.entreprise2withcollections;

/**
 * Interface de mon programme principal, chaques classes qui en hérite, devra comporter
 * les méthodes execute et endProg.
 * 
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public interface Prog {
    /**
     * Methode d'exécution d'un des choix du menu de départ
     *
     * @param programme
    */
    public void execute(MenuDepart programme);
    
    /**
     * Fin de mon programme et retour au menu après confirmation
     *
     * @param programme
     */
    public void endProg(MenuDepart programme);
}
