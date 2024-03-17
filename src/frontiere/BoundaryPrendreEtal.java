package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis desole " + nomVendeur
					+ " mais il faut etre habitant dez notre village pour commercer ici.\n");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux trouver un etal.\n");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Desole " + nomVendeur + " je n'ai plus d etal qui ne soit pas deja occupe\n");
			} else {
				installerVendeur(nomVendeur);
			}
		}

	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("Cest parfait il me reste un etal pour vous !\n Il me faudrait quelques renseignments : \n");
		String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre ?\n");
		int nbProduit=Clavier.entrerEntier("Combien souhaitez vous en vendre ?\n");
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal!=-1)
			System.out.println("Le vendeur "+nomVendeur+" s'est installe a l etal n "+numeroEtal);
	}
}
