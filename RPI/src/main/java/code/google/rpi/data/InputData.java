package code.google.rpi.data;

public class InputData {

	// win : 1
	// lose : 0
	// not played: -1
	private byte[][] games;

	// number of teams
	private int N;

	public InputData(int n) {
		super();
		this.N = n;
		this.games = new byte[N][N];
	}

	public byte[][] getGames() {
		return games;
	}

	public void setGames(byte[][] games) {
		this.games = games;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

}
