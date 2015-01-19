package org.usfirst.frc.team5190.robot.subsystems;

import org.usfirst.frc.team5190.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RobotGrabberSubsystem extends Subsystem {
	private Talon grabberTalon = new Talon(RobotMap.GRABBER_TALON_PORT);
	public Ultrasonic grabberUltrasonic = new Ultrasonic(1,1);

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	// Opens the grabber. Sets the speed 
	public void openGrabber() {
			grabberTalon.set(1);
	}
	// Close the grabber
	public void closeGrabber() {
			grabberTalon.set(-1);
	}
	
	// Stop the grabber
	public void stopGrabber() {
			grabberTalon.set(0);
	}
}
