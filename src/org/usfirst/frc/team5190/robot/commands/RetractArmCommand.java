package org.usfirst.frc.team5190.robot.commands;

import org.usfirst.frc.team5190.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RetractArmCommand extends Command {

    public RetractArmCommand() {
        requires(Robot.armSubsystem);
        setTimeout(1.0);
        
    }

    /**
     * This starts the command, and begins to retract the Arm.
     */
    protected void initialize() {
    	Robot.armSubsystem.retractArm();
    	
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
    	
    }

    /**
     * This is the returned value after the time is finished.
     */
    protected boolean isFinished() {
        return isTimedOut();
        
    }

    /**
     * This stops the arm when the time is "out"/ended, and it will start to rerun.
     */
    protected void end() {
    	Robot.armSubsystem.stopArmLengthChange();
    	
    }

    /**
     * This stops the arm from retracting when the code is interrupted.
     */
    protected void interrupted() {
    	Robot.armSubsystem.stopArmLengthChange();
    	
    }
}
