package org.usfirst.frc.team5190.robot.commands;

import org.usfirst.frc.team5190.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team5190.robot.subsystems.DriveTrainSubsystem.Turn;

import edu.wpi.first.wpilibj.command.Command;

/**
 * turn for 3 second
 */
public class TurnCommand extends Command {

	private double degree;
	private Turn turn;
	private DriveTrainSubsystem driveTrainSubsystem = DriveTrainSubsystem
			.getInstance();

	public TurnCommand(double degree) {
		this.degree = degree;
		requires(driveTrainSubsystem);
	}

	@Override
	protected void initialize() {
		// Robot.driveTrainSubsystem.setPower(0.3);
		turn = driveTrainSubsystem.turn();
		turn.start(degree);
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return turn.finishedTurn();
	}

	/**
	 * stop the turn
	 */
	@Override
	protected void end() {
		turn.end();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
