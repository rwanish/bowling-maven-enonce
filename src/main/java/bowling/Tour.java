package bowling;

import java.util.ArrayList;
import java.util.List;

public class Tour {
	private final int numero;
	private final List<Lancer> lancers = new ArrayList<>();
	private boolean termine = false;

	public Tour(int numero) {
		this.numero = numero;
	}
	
	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (termine) {
			throw new IllegalStateException("Ce tour est déjà terminé.");
		}

		lancers.add(new Lancer(nombreDeQuillesAbattues));

		// Dernier tour (10e)
		if (numero == 10) {
			if (lancers.size() == 1 && nombreDeQuillesAbattues == 10) { // Strike
				return true;
			} else if (lancers.size() == 2) {
				termine = true;
				return false;
			} else if (lancers.size() == 3) {
				termine = true;
				return false;
			}
		} else {
			if (lancers.size() == 1 && nombreDeQuillesAbattues == 10) { // Strike
				termine = true;
				return false;
			} else if (lancers.size() == 2) { // Fin normale du tour
				termine = true;
				return false;
			}
		}

		return true; // Sinon, le joueur doit relancer
	}

	public int score(List<Tour> tours, int index) {
		return score;
	}

	public boolean estTermine() {
		return termine;
	}

	public int numeroProchainLancer() {
		return lancers.size() + 1;
	}

	public int getNumero() {
		return numero;
	}
	
	



}
