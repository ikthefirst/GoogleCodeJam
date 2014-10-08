package code.google.freecell.data;

public class Stats {

	private int numberOfGames;
	private int numberOfWin;
	private int numberOfLoss;

	public Stats() {
	}

	public Stats(int numberOfGames, int numberOfWin, int numberOfLoss) {
		super();
		this.numberOfGames = numberOfGames;
		this.numberOfWin = numberOfWin;
		this.numberOfLoss = numberOfLoss;
	}

	public int getNumberOfGames() {
		return numberOfGames;
	}

	public void setNumberOfGames(int numberOfGames) {
		this.numberOfGames = numberOfGames;
	}

	public int getNumberOfWin() {
		return numberOfWin;
	}

	public void setNumberOfWin(int numberOfWin) {
		this.numberOfWin = numberOfWin;
	}

	public int getNumberOfLoss() {
		return numberOfLoss;
	}

	public void setNumberOfLoss(int numberOfLoss) {
		this.numberOfLoss = numberOfLoss;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfGames;
		result = prime * result + numberOfLoss;
		result = prime * result + numberOfWin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stats other = (Stats) obj;
		if (numberOfGames != other.numberOfGames)
			return false;
		if (numberOfLoss != other.numberOfLoss)
			return false;
		if (numberOfWin != other.numberOfWin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stats(" + numberOfGames + ", " + numberOfWin + ", "
				+ numberOfLoss + ")";
	}

}
