/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import FFSSM.Club;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Personne;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Alexia
 */
public class TestLicence {
    Club club;
    Moniteur president;
    Licence licenceValide, licenceNonValide;
    Personne personne1, personne2;
		
	@BeforeEach
	public void setUp() {
    
        //création club
        club = new Club(president, "Club1", "0641326598");

        //création personnes
        personne1 = new Personne("43683426", "Bayol", "ALexia", "adresse1", "0648956875", LocalDate.of(2002, 07, 23));
        personne2 = new Personne("45636357", "Ferreira", "Mélia", "adresse2", "0683567819", LocalDate.of(2003, 02, 15));

        //création licence valide
        licenceValide = new Licence(personne1, "1", LocalDate.of(2022, 12, 13), club);

        //création licence non valide
        licenceNonValide = new Licence(personne2, "2", LocalDate.of(2021, 12, 13), club);

	}

	@Test
	public void testLicenceValide() {
		assertTrue(licenceValide.estValide(LocalDate.of(2022, 12, 25)));
	}

    @Test
	public void testLicenceNonValide() {
		assertFalse(licenceNonValide.estValide(LocalDate.of(2022, 12, 25)));
	}
}
