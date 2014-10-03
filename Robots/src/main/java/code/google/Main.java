package code.google;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Parser parser = new Parser();
		List<List<ProgramEntry>> testcases = new ArrayList<>();
		if (args.length > 0) {
			try {
				parser.parseFile(args[0], testcases);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				parser.parseFile("in/example.in", testcases);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// for (List<ProgramEntry> program : testcases) {
		// System.out.println(program);
		// }

		Executor executor = new Executor();
		executor.addRobot(new Robot("O"));
		executor.addRobot(new Robot("B"));
		int n = 1;
		for (List<ProgramEntry> program : testcases) {
			executor.setProgram(program);
			executor.initRobots();
			int steps = executor.execute();
			System.out.println("Case #" + n + ": " + steps);
			n++;
		}
	}
}
