package org.usfirst.frc.team5190.robot.subsystems;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team5190.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	RobotDrive mDrive;

	/**
	 * Init the drive train at default port, in RobotMap
	 */
	public DriveTrainSubsystem() {
		mDrive = new RobotDrive(RobotMap.ROBOT_DRIVE_PORT1,
				RobotMap.ROBOT_DRIVE_PORT2, RobotMap.ROBOT_DRIVE_PORT3, RobotMap.ROBOT_DRIVE_PORT4);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	/**
	 * drive forward at the full speed
	 */

	public void driveForward() {
		mDrive.tankDrive(1, 1);
	}

	/**
	 * drive at a speed, forward is 0 - 1, back is 0 - -1
	 * 
	 * @param speed
	 *            the speed robot will go at, -1 to 1, 1 goes forward
	 */

	public void drive(double speed) {
		mDrive.tankDrive(speed, speed);
	}
	
	/**
	 * drive the robot at speed for time second
	 * @param speed the speed(-1 -1), which the robot will go at
	 * @param time the number of second it will run
	 */
	
	public void drive(double speed, long time) {
		mDrive.tankDrive(speed, speed);
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			
		} finally {
			this.stopAll();
		}
	}
	
	/**
	 * stop the robot
	 */

	public void stopAll() {
		mDrive.tankDrive(0, 0);
	}

	/**
	 * turn right at speed of 0.1
	 */

	public void turnRight() {
		mDrive.tankDrive(0, 0.1);
	}

	/**
	 * turn left at speed of 0.1
	 */

	public void turnLeft() {
		mDrive.tankDrive(0.1, 0);
	}

	/**
	 * turn at rate of amount
	 * 
	 * @param amount
	 *            the rate of turn, from -1 - 1
	 */

	public void turn(double amount) {
		mDrive.arcadeDrive(0, amount, false);
	}

	/**
	 * control the drive train with a arcade drive
	 * 
	 * @param stick
	 *            the one joystick
	 */

	public void arcadeJoystickDrive(Joystick stick) {
		mDrive.arcadeDrive(stick);
	}

	/**
	 * control the robot with tank drive joystick configuration
	 * 
	 * @param s1
	 *            the left stick
	 * @param s2
	 *            the right stick
	 */

	public void tankJoystickDrive(Joystick s1, Joystick s2) {
		mDrive.tankDrive(s1, s2);
	}
}
