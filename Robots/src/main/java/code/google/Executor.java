package code.google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Executor {

	private List<ProgramEntry> program;
	private Map<String, Robot> robots;

	public Executor() {
		super();
		robots = new HashMap<String, Robot>();
	}

	public void initRobots() {
		for (Robot robot : robots.values()) {
			robot.clearProgram();
		}
		for (ProgramEntry entry : program) {
			robots.get(entry.getRobot()).addProgramEntry(entry);
		}
	}

	public int execute() {
		int stepNum = 0;
		for (Robot robot : robots.values()) {
			robot.start();
		}
		ProgramEntry lastEntry = program.get(program.size() - 1);
		while (!lastEntry.isDone()) {
			// System.out.println(stepNum);
			boolean pressed = false;
			for (Robot robot : robots.values()) {
				if (!robot.isFinished()) {
					robot.operate(pressed);
					pressed = pressed || robot.isPressed();
				}
			}
			stepNum++;
		}

		return stepNum;
	}

	public void addRobot(Robot robot) {
		robots.put(robot.getName(), robot);
	}

	public List<ProgramEntry> getProgram() {
		return program;
	}

	public void setProgram(List<ProgramEntry> program) {
		this.program = program;
	}

}
