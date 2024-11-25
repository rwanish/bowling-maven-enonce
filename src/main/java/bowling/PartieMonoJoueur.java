package bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {

	private final List<Tour> tours = new ArrayList<>();
	private boolean partieTerminee = false;

	/**
	 * Constructeur
	 */
	public PartieMonoJoueur() {
		for (int i = 0; i < 10; i++) {
			tours.add(new Tour(i + 1));
		}
	}

	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de ce lancer
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon
	 * @throws IllegalStateException si la partie est terminée
	 */

	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (partieTerminee) {
			throw new IllegalStateException("La partie est terminée.");
		}
		for (Tour tour : tours) {
			if (!tour.estTermine()) {
				boolean doitRelancer = tour.enregistreLancer(nombreDeQuillesAbattues);

				if (tours.get(9).estTermine()) {partieTerminee = true;
				}

				return doitRelancer;
			}
		}
		return false;
	}


	/**
	 * Cette méthode donne le score du joueur.
	 * Si la partie n'est pas terminée, on considère que les lancers restants
	 * abattent 0 quille.
	 * @return Le score du joueur
	 */
	public int score() {
		int score = 0;
		for (int i = 0; i < tours.size(); i++) {
			Tour tour = tours.get(i);
			score += tour.score(tours, i);
		}
		return score;
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		return partieTerminee;
	}


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		for (Tour tour : tours) {
			if (!tour.estTermine()) {
				return tour.getNumero();
			}
		}
		return 0;
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
	public int numeroProchainLancer() {
		for (Tour tour : tours) {
			if (!tour.estTermine()) {
				return tour.numeroProchainLancer();
			}
		}
		return 0;
	}
	
	

}
