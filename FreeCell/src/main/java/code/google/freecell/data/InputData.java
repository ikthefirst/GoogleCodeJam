package code.google.freecell.data;

public class InputData {

	private int winPercentageToday;
	private int winPercentageTotal;
	private long maxGamesToday; // max possible games played today

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

	public long getMaxGamesToday() {
		return maxGamesToday;
	}

	public void setMaxGamesToday(long maxGamesToday) {
		this.maxGamesToday = maxGamesToday;
	}

}
