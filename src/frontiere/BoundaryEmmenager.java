package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			int choixUtilisateur = -1;
			do {
				question.append("Êtes-vous :\n");
				question.append("1 - un druide.\n");
				question.append("2 - un gaulois.\n");

				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois " + nomVisiteur);
					int force = Clavier.entrerEntier("Quelle est votre force ?\t");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		
		int force;
		int effetPotionMax;
		int effetPotionMin;
		do {
			force = Clavier.entrerEntier("Quelle est votre force ?\t");
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?\t ");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?\t ");
			if (effetPotionMax<effetPotionMin)
				System.out.println("Attention Druide, vous vous etes trompe entre le minimum et le maximum\n");
		} while (effetPotionMax<effetPotionMin);

		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}

}
