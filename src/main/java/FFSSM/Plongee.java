/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    private Site lieu;
    private Moniteur chefDePalanquee;
    private LocalDate date;
    private int profondeur;
    private int duree;

    private Set<Licence> palanquee = new HashSet<>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
        palanquee.add(participant.derniereLicence().orElseThrow(IllegalStateException::new));
    }

    public LocalDate getDate() {
        return date;
    }

    public Site getLieu() {
        return lieu;
    }

    public void setLieu(Site lieu) {
        this.lieu = lieu;
    }

    public Moniteur getChefDePalanquee() {
        return chefDePalanquee;
    }

    public void setChefDePalanquee(Moniteur chefDePalanquee) {
        this.chefDePalanquee = chefDePalanquee;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Set<Licence> getPalanquee() {
        return palanquee;
    }

    public void setPalanquee(Set<Licence> palanquee) {
        this.palanquee = palanquee;
    }

    /**
     * Détermine si la plongée est conforme. Une plongée est conforme si tous
     * les plongeurs de la palanquée ont une licence valide à la date de la
     * plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        boolean res = true;
        for (Licence l : palanquee) {
            if (!l.estValide(date)) {
                res = false;
            }
        }
        return res;

    }

}
