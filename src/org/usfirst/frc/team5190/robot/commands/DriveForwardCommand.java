package org.usfirst.frc.team5190.robot.commands;

import org.usfirst.frc.team5190.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * drive forward until 11 inches from an object
 */
public class DriveForwardCommand extends Command {

	/**
	 * 
	 */
	public DriveForwardCommand() {
		// needs drive train
		requires(Robot.driveTrainSubsystem);
		Robot.driveTrainSubsystem.setPower(0.1);
		// ini the ultrasonics
	}

	@Override
	protected void initialize() {
	}

	/**
	 * drive at full speed forward until is 11 inches from an object
	 */
	@Override
	protected void execute() {
		Robot.driveTrainSubsystem.driveToPoint(10);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.driveTrainSubsystem.stopAll();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
