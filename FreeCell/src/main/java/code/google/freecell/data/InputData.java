package code.google.freecell.data;

public class InputData {

	private int winPercentageToday;
	private int winPercentageTotal;
	private int maxGamesToday; // max possible games played today

	public int getWinPercentageToday() {
		return winPercentageToday;
	}

	public void setWinPercentageToday(int winPercentageToday) {
		this.winPercentageToday = winPercentageToday;
	}

	public int getWinPercentageTotal() {
		return winPercentageTotal;
	}

	public void setWinPercentageTotal(int winPercentageTotal) {
		this.winPercentageTotal = winPercentageTotal;
	}

	public int getMaxGamesToday() {
		return maxGamesToday;
	}

	public void setMaxGamesToday(int maxGamesToday) {
		this.maxGamesToday = maxGamesToday;
	}

}
