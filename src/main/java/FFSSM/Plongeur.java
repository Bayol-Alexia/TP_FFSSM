package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Plongeur extends Personne {

    protected int niveau;
    protected GroupeSanguin groupe;
    protected List<Licence> licences = new ArrayList<>();

    ;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone,
            LocalDate naissance, int niveau, GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.groupe = groupe;
        this.licences = licences;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public GroupeSanguin getGpeSanguin() {
        return groupe;
    }

    public void setGpeSanguin(GroupeSanguin gpeSanguin) {
        this.groupe = gpeSanguin;
    }

    public List<Licence> getLicences() {
        return licences;
    }

    public void setLicences(List<Licence> licences) {
        this.licences = licences;
    }

    /**
     * Ajoute une licence aux licences du plongeur
     *
     * @param numero le numero de la licence à ajouter
     * @param delivrance la date de delivrance de la licence à ajouter
     * @param c le club correspondant à la licence à ajouter
     *
     *
     */
    public void ajouteLicence(String numero, LocalDate delivrance, Club c) {
        Licence licence = new Licence(this, numero, delivrance, c);
        //ajout de la licence aux licences su plongeur
        licences.add(licence);
        //ajout de la licence aux licences du club
        c.ajouteLicence(licence);

    }

    /**
     * Retourne la derniere licence du plongeur
     *
     * @return la derniere licence du joueur
     *
     *
     */
    public Optional<Licence> derniereLicence() {
        Licence res = licences.get(licences.size() - 1);
        if (this.licences.isEmpty()) {
            res = null;
        }
        return Optional.ofNullable(res);
    }
}
