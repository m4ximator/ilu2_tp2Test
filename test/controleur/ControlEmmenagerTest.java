package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village= new Village("Le village des irr�ductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
	}
	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("bonemine"));
		assertFalse(controlEmmenager.isHabitant("ILU2 c'est g�nial"));
		controlEmmenager.ajouterDruide("panoramixu", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("panoramixu"));
	}
	
	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("pano",10,1,5);
		assertTrue(controlEmmenager.isHabitant("pano"));
	}
	
	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Gaulois", 15);
        assertTrue(controlEmmenager.isHabitant("Gaulois"));
	}
	

}
