/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Moniteur;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Alexia
 */
public class TestMoniteur {
    Club club1, club2;
	Moniteur president1, president2, moniteur;
		
	@BeforeEach
	public void setUp() {
        //création président
        president1 = new Moniteur( "12345", "Matton", "Hugo", "adresse d'Hugo", "0657869479", LocalDate.of(2001, 05, 06), 2, GroupeSanguin.AMOINS, 123456);
		president2 = new Moniteur( "43665", "Untel", "Marc", "adresse de Marc", "0657869479", LocalDate.of(1980, 05, 06), 2, GroupeSanguin.AMOINS, 54773);
		
        //création clubs
        club1 = new Club(president1, "Club1", "0640196743");
        club2 = new Club(president2, "Club2", "0683444444");

        //création moniteur
        moniteur = new Moniteur("98765", "Bencharef", "Rayane", "adresse de Rayane", "0673546575", LocalDate.of(2001, 01, 3), 5, GroupeSanguin.BMOINS, 764336);

        //création embauche

	}

    @Test
	public void testNouvelleEmbauche() {
        moniteur.nouvelleEmbauche(club1, LocalDate.of(2020, 03, 01));
		assertEquals(1, moniteur.getLesEmbauches().size(), "Le moniteur doit avoir 1 embauche");
	}

}
