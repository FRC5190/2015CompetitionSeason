package org.usfirst.frc.team5190.robot.commands;

import org.usfirst.frc.team5190.robot.IndependentSensors;
import org.usfirst.frc.team5190.robot.Robot;
import org.usfirst.frc.team5190.robot.subsystems.DriveTrainSubsystem.DriveSetDistance;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToObjectCommand extends Command {

	private DriveSetDistance d;
	private double distanceBuffer;

	public DriveToObjectCommand() {
		requires(Robot.driveTrainSubsystem);
		d = Robot.driveTrainSubsystem.driveSetDistance();
		IndependentSensors.getGyro().reset();
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.driveTrainSubsystem.setPower(0.5);
		distanceBuffer = IndependentSensors.getLidar().getValue();
		distanceBuffer = 6 * 12;
		d.start(distanceBuffer);

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return d.drivenDistance();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		IndependentSensors.getGyro().reset();
		d.end();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}