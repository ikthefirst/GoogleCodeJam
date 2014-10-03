package code.google;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RobotTest {

	@Test
	public void newlyCreatedRobotShouldBeInFinishedState() {
		Robot robot = new Robot("test_robot");
		robot.start();

		assertTrue("Newly created robot should be in finished state.",
				robot.isFinished());
	}

	@Test
	public void robotWithEmptyProbramShouldBeInFinishedState() {
		Robot robot = new Robot("test_robot");
		robot.setProgram(new ArrayList<ProgramEntry>());
		robot.start();

		assertTrue("Robot with empty program should be in finished state.",
				robot.isFinished());
	}

	@Test
	public void startedRobotShouldBeInStartingPosition() {
		Robot robot = new Robot("test_robot");
		robot.start();

		assertEquals(
				"Started robot should be in starting position (position=1).",
				1, robot.getPosition());
	}

	@Test
	public void robotShouldMoveUpTowardsItsGoalIfPositionIsSmaller() {
		Robot robot = new Robot("test_robot");
		robot.addProgramEntry(new ProgramEntry("test_robot", 5));
		robot.start();
		robot.setPosition(3);
		robot.operate(false);

		assertEquals("Robot should move towards its goal ", 4,
				robot.getPosition());
	}

	@Test
	public void robotShouldMoveUpTowardsItsGoalIfPositionIsGreater() {
		Robot robot = new Robot("test_robot");
		robot.addProgramEntry(new ProgramEntry("test_robot", 7));
		robot.start();
		robot.setPosition(10);
		robot.operate(false);

		assertEquals("Robot should move towards its goal ", 9,
				robot.getPosition());
	}

	@Test
	public void robotShouldPressButtonIfAtRightPositionAndPreviousGoalIsDone() {
		Robot robot = new Robot("test_robot");
		ProgramEntry pe0 = new ProgramEntry("test_robot", 2);
		pe0.setDone(true);
		ProgramEntry pe1 = new ProgramEntry("test_robot", 7);
		pe1.setDone(false);
		pe1.setPrevious(pe0);

		robot.addProgramEntry(pe0);
		robot.addProgramEntry(pe1);
		robot.setPosition(7);
		robot.setIdx(1);
		robot.setGoal(pe1);
		robot.setFinished(false);

		robot.operate(false);

		assertEquals(
				"Robot should press button if it is at right position and previous goal is done.",
				true, pe1.isDone());
	}

	@Test
	public void robotShouldNotPressButtonIfAtRightPositionAndPreviousGoalIsNotDone() {
		Robot robot = new Robot("test_robot");
		ProgramEntry pe0 = new ProgramEntry("test_robot", 2);
		pe0.setDone(false);
		ProgramEntry pe1 = new ProgramEntry("test_robot", 7);
		pe1.setDone(false);
		pe1.setPrevious(pe0);

		robot.addProgramEntry(pe0);
		robot.addProgramEntry(pe1);
		robot.setPosition(7);
		robot.setIdx(1);
		robot.setGoal(pe1);
		robot.setFinished(false);

		robot.operate(false);

		assertEquals(
				"Robot should not press button if it is at right position and previous goal is not done.",
				false, pe1.isDone());
	}

	@Test
	public void robotShouldNotPressButtonIfNotAtRightPosition() {
		Robot robot = new Robot("test_robot");
		ProgramEntry pe0 = new ProgramEntry("test_robot", 2);
		pe0.setDone(false);

		robot.addProgramEntry(pe0);
		robot.setPosition(7);
		robot.setIdx(0);
		robot.setGoal(pe0);
		robot.setFinished(false);

		robot.operate(false);

		assertEquals(
				"Robot should not press button if it is at right position and previous goal is not done.",
				false, pe0.isDone());
	}

}
