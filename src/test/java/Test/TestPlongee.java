/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Alexia
 */
public class TestPlongee {

    Club club;
    Moniteur president, moniteur;
    Plongeur plongeurValide1, plongeurValide2, plongeurNonValide;
    Plongee plongeeConforme, plongeeNonConforme;

    @BeforeEach
    public void setUp() {
        //création président
        president = new Moniteur("12345", "Ben Touhami", "Haythem", "adresse1", "0745968575", LocalDate.of(1995, 05, 06), 2, GroupeSanguin.AMOINS, 123456);
        //création club
        club = new Club(president, "Le Club de Haythem", "0745968575");
        //création moniteur
        moniteur = new Moniteur("98765", "Bastide", "Rémi", "adresse2", "0685713204", LocalDate.of(1985, 01, 3), 5, GroupeSanguin.BMOINS, 764336);

        //création plongeurs avec licence valide
        plongeurValide1 = new Plongeur("547457", "Lacroix", "Noëlie", "adresse3", "0783945678", LocalDate.of(2002, 02, 07), 1, GroupeSanguin.BPLUS);
        plongeurValide1.ajouteLicence("1", LocalDate.of(2021, 12, 07), club);
        plongeurValide2 = new Plongeur("426245", "Roland", "Salomé", "adresse4", "0645321689", LocalDate.of(2002,11, 02), 2, GroupeSanguin.BPLUS);
        plongeurValide2.ajouteLicence("2", LocalDate.of(2021, 10, 07), club);
        
        //création plongeur avec licence non valide
        plongeurNonValide = new Plongeur("865378", "Ferreira", "Mélia", "adresse5", "0703254698", LocalDate.of(2003, 02, 15), 3, GroupeSanguin.BMOINS);
        plongeurNonValide.ajouteLicence("3", LocalDate.of(2017, 9, 01), club);
        
        //création plongée conforme
        plongeeConforme = new Plongee(new Site("Castres", "Lieu1"), moniteur, LocalDate.of(2021, 11, 7), 100, 1);

        //création plongée non conforme : participant sans licence valide
        plongeeNonConforme = new Plongee(new Site("Toulouse", "Lieu2"), moniteur, LocalDate.of(2021, 10, 3), 300, 1);
        plongeeNonConforme.ajouteParticipant(plongeurValide1);
        plongeeNonConforme.ajouteParticipant(plongeurNonValide);

    }

    @Test
    public void testAjouterParticipant() {
        plongeeConforme.ajouteParticipant(plongeurValide1);
        plongeeConforme.ajouteParticipant(plongeurValide2);
        assertEquals(2, plongeeConforme.getPalanquee().size(), "La plongée doit avoir 2 participants");
    }

    @Test
    public void testEstConforme() {
        //on ajoute un participant ayant une licence valide dans une plongée qui doit donc être conforme
        plongeeConforme.ajouteParticipant(plongeurValide1);
        assertTrue(plongeeConforme.estConforme(), "La plongée doit être conforme");

        //on ajoute un participant ayant une licence non valide dans une plongée qui doit donc être non conforme
        plongeeConforme.ajouteParticipant(plongeurNonValide);
        assertFalse(plongeeNonConforme.estConforme(), "La plongée ne doit pas être conforme");
    }

}
