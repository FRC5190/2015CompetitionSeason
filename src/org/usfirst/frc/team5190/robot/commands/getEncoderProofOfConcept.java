package org.usfirst.frc.team5190.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class getEncoderProofOfConcept extends Command {
	boolean isFinished = false;
	private Encoder testEncoder;

	public getEncoderProofOfConcept() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		testEncoder = new Encoder(3, 4);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		testEncoder.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		@SuppressWarnings("unused")
		int test1 = testEncoder.get();
		boolean test2 = testEncoder.getDirection();
		double test3 = testEncoder.getDistance();
		double test4 = testEncoder.getRate();
		isFinished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}