package code.google.rpi.logic;

public class RatingsPercentageCalculator {

	private byte[] numGames = null;
	private byte[] numWins = null;

	public byte[] getNumGames() {
		return numGames;
	}

	public byte[] getNumWins() {
		return numWins;
	}

	public float[] calculateWP(byte[][] games, int N) {
		float[] wp = new float[N];
		this.numGames = new byte[N];
		numWins = new byte[N];
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (games[i][j] == -1) {
					continue;
				}
				numGames[i]++;
				numGames[j]++;
				if (games[i][j] == 1) {
					numWins[i]++;
				} else {
					numWins[j]++;
				}
			}
			wp[i] = (float) numWins[i] / (float) numGames[i];
		}

		return wp;
	}

	public float[] calculateOWP(byte[][] games, byte[] numGames, int N) {
		float[] owp = new float[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (games[i][j] == -1) {
					continue;
				}
				owp[i] += (float) (numWins[j] - games[j][i])
						/ (numGames[j] - 1);
			}
			owp[i] = owp[i] / numGames[i];
		}

		return owp;
	}

	public float[] calculateOOWP(byte[][] games, float[] owp, int N) {
		float[] oowp = new float[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (games[i][j] == -1) {
					continue;
				}
				oowp[i] += owp[j];
			}
			oowp[i] = oowp[i] / numGames[i];
		}

		return oowp;
	}

	public float[] calculateRPI(float[] wp, float[] owp, float[] oowp, int N) {
		float[] rpi = new float[N];
		for (int i = 0; i < N; i++) {
			rpi[i] = 0.25f * wp[i] + 0.5f * owp[i] + 0.25f * oowp[i];
		}
		return rpi;
	}

}
