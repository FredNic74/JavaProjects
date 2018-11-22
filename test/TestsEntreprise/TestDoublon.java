package TestsEntreprise;

import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.Personnes;
import be.iepscfjemelle.poolabo.nicolay.entreprise2withFactory.PersonnesFactory;
import java.util.HashSet;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Frederic Nicolay 2ème Bachelier Informatique
 */
public class TestDoublon {

    HashSet<Personnes> hset = new HashSet<>();
    public String fonction1 = "directeur";
    public String fonction2 = "comptable";
    public String fonction3 = "secretaire";
    public String fonction4 = "ouvrier";
    public String idDir = "1234";
    public String prenomDir = "Fred";
    public String nomDir = "Nicolay";
    public String idCom = "4567";
    public String prenomCom = "Jecompte";
    public String nomCOm = "Bien";
    public String idSec = "9874";
    public String prenomSec = "Mimi";
    public String nomSec = "Lafrappe";
    public String idOuv = "4561";
    public String prenomOuv = "Gege";
    public String nomOuv = "Lapelle";

    @BeforeClass
    private boolean ajoutPersonneToList(Personnes pers, HashSet<Personnes> hset) {
        if (hset.add(pers)) {
            return true;
        } else {
            System.out.println("Doublon.\n");
            return false;
        }
    }

    @Test
    public void TestDuplicateDirecteur(Personnes p, HashSet<Personnes> hset) {
        Personnes directeur = PersonnesFactory.getPers(idDir, prenomDir, nomDir, fonction1);
        ajoutPersonneToList(directeur, hset);
        Personnes directeur2 = PersonnesFactory.getPers(idDir, prenomDir, nomDir, fonction1);
        ajoutPersonneToList(directeur2, hset);
    }

    @Test
    public void TestDuplicateComptable(Personnes p, HashSet<Personnes> hset) {
        Personnes comptable = PersonnesFactory.getPers(idCom, prenomCom, nomCOm, fonction2);
        ajoutPersonneToList(comptable, hset);
        Personnes comptable2 = PersonnesFactory.getPers(idCom, prenomCom, nomCOm, fonction2);
        ajoutPersonneToList(comptable2, hset);
    }

    @Test
    public void TestDuplicateSecretaire(Personnes p, HashSet<Personnes> hset) {
        Personnes Secretaire = PersonnesFactory.getPers(idSec, prenomSec, nomSec, fonction3);
        ajoutPersonneToList(Secretaire, hset);
        Personnes Secretaire2 = PersonnesFactory.getPers(idSec, prenomSec, nomSec, fonction3);
        ajoutPersonneToList(Secretaire2, hset);
    }

    @Test
    public void TestDuplicateOuvrier(Personnes p, HashSet<Personnes> hset) {
        Personnes ouvrier = PersonnesFactory.getPers(idOuv, prenomOuv, nomOuv, fonction4);
        ajoutPersonneToList(ouvrier, hset);
        Personnes ouvrier2 = PersonnesFactory.getPers(idOuv, prenomOuv, nomOuv, fonction4);
        ajoutPersonneToList(ouvrier2, hset);
    }
}
