package code.google;

import java.util.ArrayList;
import java.util.List;

public class Robot {

	private String name; // the name of the robot
	private List<ProgramEntry> program; // program of robot
	private int idx; // index of current goal in program
	private ProgramEntry goal; // current goal of robot
	private int position; // current position of robot
	private boolean finished; // inidcates if the robot has finished
	private boolean pressed; // inidcates if the robot has just pressed a button

	public Robot() {
		super();
		program = new ArrayList<ProgramEntry>();
		finished = true;
	}

	public Robot(String name) {
		this();
		this.name = name;
	}

	public void addProgramEntry(ProgramEntry entry) {
		if (entry.getRobot().equals(name)) {
			program.add(entry);
		}
	}

	/**
	 * Start the operation of the robot
	 */
	public void start() {
		position = 1;
		idx = 0;
		if (program.size() > 0) {
			finished = false;
			goal = program.get(idx);
		}
	}

	public void clearProgram() {
		program.clear();
	}

	/**
	 * This method will be called in every minute.
	 */
	public void operate(boolean otherPressed) {
		this.pressed = false;
		if (finished) {
			// System.out.println(name + " is finished.");
			return;
		}
		if (position != goal.getPosition()) {
			move();
			return;
		}
		ProgramEntry previous = goal.getPrevious();
		if (previous == null || previous.isDone()) {
			if (!otherPressed) {
				press();
			}
			return;
		}
	}

	public boolean isFinished() {
		return finished;
	}

	/**
	 * Robot operation: move towards destination
	 */
	private void move() {
		if (goal.getPosition() > position) {
			// System.out.println(name + " move up [" + position + " -> "
			// + (position + 1) + "]");
			position++;
			return;
		}
		if (goal.getPosition() < position) {
			// System.out.println(name + " move down [" + position + " -> "
			// + (position - 1) + "]");
			position--;
			return;
		}
	}

	/**
	 * Robot operation: press button
	 */
	private void press() {
		// System.out.println(name + " press button at [" + position + "]");
		pressed = true;
		goal.setDone(true);
		idx++;
		if (idx >= program.size()) {
			finished = true;
		} else {
			goal = program.get(idx);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProgramEntry> getProgram() {
		return program;
	}

	public void setProgram(List<ProgramEntry> program) {
		this.program = program;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public ProgramEntry getGoal() {
		return goal;
	}

	public void setGoal(ProgramEntry goal) {
		this.goal = goal;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

}
