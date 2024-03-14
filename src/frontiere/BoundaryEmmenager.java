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
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder questionDruide = new StringBuilder();
		int force = 0;
		int effetPotionMin = 0;
		int effetPotionMax = 0;
		questionDruide.append("Donnez la force,puis effetpotionmin puis effetpotionmax du Druide :\n");
		do {
			force = Clavier.entrerEntier(questionDruide.toString() + "force: ");
			effetPotionMin = Clavier.entrerEntier("effetPotionMin: ");
			effetPotionMax = Clavier.entrerEntier("effetPotionMax: ");
		} while (force < 1 && effetPotionMax < 1 && effetPotionMin < 1);

		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}

	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder questionGaulois = new StringBuilder();
		int choixForceUtilisateur = 0;
		questionGaulois.append("Donnez la force du gaulois\n");
		do {
			choixForceUtilisateur = Clavier.entrerEntier(questionGaulois.toString());

		} while (choixForceUtilisateur < 1);
		controlEmmenager.ajouterGaulois(nomVisiteur, choixForceUtilisateur);
	}
}
