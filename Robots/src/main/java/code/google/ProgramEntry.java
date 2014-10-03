package code.google;

public class ProgramEntry {

	private String robot;
	private int position;
	private ProgramEntry previous;
	private boolean isDone = false;

	public ProgramEntry() {
		super();
	}

	public ProgramEntry(String robot, int position) {
		super();
		this.robot = robot;
		this.position = position;
	}

	public ProgramEntry(String robot, int position, ProgramEntry previous) {
		super();
		this.robot = robot;
		this.position = position;
		this.previous = previous;
	}

	public String getRobot() {
		return robot;
	}

	public void setRobot(String robot) {
		this.robot = robot;
	}

	public int getPosition() {
		return position;
	}

	public void getPosition(int button) {
		this.position = button;
	}

	public ProgramEntry getPrevious() {
		return previous;
	}

	public void setPrevious(ProgramEntry previous) {
		this.previous = previous;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "[" + robot + " " + position + "]";
	}
}
