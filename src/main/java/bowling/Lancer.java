package bowling;

public class Lancer {
	private final int quilles;

	public Lancer(int quilles) {
		if (quilles < 0 || quilles > 10) {
			throw new IllegalArgumentException("Le nombre de quilles doit être entre 0 et 10.");
		}
		this.quilles = quilles;
	}

	public int getQuilles() {
		return quilles;
	}
}
