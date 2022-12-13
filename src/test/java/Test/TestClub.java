/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Personne;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Alexia
 */
public class TestClub {
    Club club;
    Moniteur president, moniteur;
    Plongeur plongeurValide1, plongeurValide2, plongeurNonValide;
    Plongee plongeeConforme1, plongeeConforme2, plongeeNonConforme;
		
	@BeforeEach
	public void setUp() {
        //création président
        president = new Moniteur( "12345", "Ben Touhami", "Haythem", "adresse1", "0745968575", LocalDate.of(1995, 05, 06), 2, GroupeSanguin.AMOINS, 123456);
		
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
        plongeeConforme1 = new Plongee(new Site("Castres", "Lieu1"), moniteur, LocalDate.of(2021, 11, 7), 100, 1);
        plongeeConforme2 = new Plongee(new Site("Gramat", "Lieu2"), moniteur, LocalDate.of(2021, 12, 7), 200, 2);

        //création plongée non conforme : participant sans licence valide
        plongeeNonConforme = new Plongee(new Site("Toulouse", "Lieu3"), moniteur, LocalDate.of(2021, 10, 3), 300, 1);
        plongeeNonConforme.ajouteParticipant(plongeurValide1);
        plongeeNonConforme.ajouteParticipant(plongeurNonValide);

	}

	@Test
	public void testNouvellePlongee() {
        club.organisePlongee(plongeeConforme1);
        club.organisePlongee(plongeeConforme2);
		assertEquals(2, club.getActivites().size(), "Le club doit avoir 2 plongées");
	}

    @Test
	public void testPlongeeNonConforme() {
        club.organisePlongee(plongeeConforme1);
        club.organisePlongee(plongeeNonConforme);
		assertEquals(1, club.plongeesNonConformes().size(), "Le club doit avoir 1 plongée non conforme");
	}

    @Test
	public void testDelivreLicence() {
		assertEquals(3, club.getLicencesDelivrees().size(), "Le club doit avoir 3 licences enregistrées");

        //ajout d'une licence
        Personne plongeurTest = new Personne("43683426", "unNom", "Luc", "adresse de Luc", "0742555567", LocalDate.of(2003, 05, 9));
        club.ajouteLicence(new Licence(plongeurTest, "569750", LocalDate.of(2020, 04, 30), club));
        assertEquals(4, club.getLicencesDelivrees().size(), "Le club doit avoir 4 licences enregistrées");
	}
}
