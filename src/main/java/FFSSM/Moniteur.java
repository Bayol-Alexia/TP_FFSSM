/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    private int numeroDiplome;
    private List<Embauche> embauches = new ArrayList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupe, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, groupe);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Club res;
        Embauche dernièreEmbauche = embauches.get(embauches.size() - 1);
        res = dernièreEmbauche.getEmployeur();

        if (dernièreEmbauche.estTerminee() || embauches.isEmpty()) {
            res = null;
        }
        return Optional.ofNullable(res);
    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        embauches.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
        return embauches;
    }

    public int getNumeroDiplome() {
        return numeroDiplome;
    }

    public void setNumeroDiplome(int numeroDiplome) {
        this.numeroDiplome = numeroDiplome;
    }

    public List<Embauche> getLesEmbauches() {
        return embauches;
    }

    public void setLesEmbauches(List<Embauche> embauches) {
        this.embauches = embauches;
    }

    
}
