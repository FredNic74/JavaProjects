package be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory;

/**
 *Class Factory, renvoi un objet Personnes de type Directeur, Comptable, Secretaire ou Ouvrier, avec leurs attributs 
 * en fonctionde ce qui est demandé.
 * 
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class PersonnesFactory {

    public static Personnes getPers(String numeroNational, String prenom, String nom, String fonction) {
        if (fonction == null) {
            return null;
        }
        if (fonction.equalsIgnoreCase("DIRECTEUR")) {
            return new Directeur(numeroNational, prenom, nom, fonction);
        } else if (fonction.equalsIgnoreCase("COMPTABLE")) {
            return new Comptable(numeroNational, prenom, nom, fonction);
        } else if (fonction.equalsIgnoreCase("SECRETAIRE")) {
            return new Secretaire(numeroNational, prenom, nom, fonction);
        } else if (fonction.equalsIgnoreCase("OUVRIER")) {
            return new Ouvrier(numeroNational, prenom, nom, fonction);
        }
        return null;
    }
}
