package org.usfirst.frc.team5190.robot.subsystems;

import org.usfirst.frc.team5190.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * the arm subsystem
 */
public class ArmSubsystem extends PIDSubsystem {
	private TalonSRX armLengthTalon = new TalonSRX(
			RobotMap.ARMLENGTH_TALONSRX_PORT);
	private TalonSRX armAngleTalon = new TalonSRX(
			RobotMap.ARMANGLE_TALONSRX_PORT);
	double motorSpeed = 0.5;
	public Encoder armLengthEncoder = new Encoder(3, 4, false,
			Encoder.EncodingType.k4X);
	// Counterclockwise for getdirection() is true
	public double currentdegrees = 0;
	public DigitalInput armLimitSwitch = new DigitalInput(
			RobotMap.ARM_LIMIT_SWITCH_PORT);
	public final double shaftcircumference = 0; // Give this a real value when
												// we find the circumference of
												// the shaft

	/**
	 * nothing needs to go here.
	 */
	public void initDefaultCommand() {

	}

	/**
	 * Turns the arm on, and extends it with a positive speed.
	 */

	public ArmSubsystem() {
		super("Arm", 1.0, 0.0, 0.0);
		enable();
		setPercentTolerance(5.0);
		getPIDController().setContinuous(false);
		armLengthEncoder.setMaxPeriod(.1);
		armLengthEncoder.setMinRate(10);
		armLengthEncoder.setDistancePerPulse(5);
		armLengthEncoder.setReverseDirection(true);
		armLengthEncoder.setSamplesToAverage(7);
	}

	/**
	 * extends the arm
	 */
	public void extendArm() {
		armLengthTalon.set(motorSpeed);
	}

	/**
	 * Turns the arm off, by putting the motor to a stop with a speed of 0.
	 */
	public void stopArmLengthChange() {
		armLengthTalon.set(0);
	}

	/**
	 * This sets the speed as negative, retracting the arm.
	 */
	public void retractArm() {
		armLengthTalon.set(-motorSpeed);

	}

	/**
	 * This raises the arm by using motorSpeed (positive value).
	 */
	public void raiseArm() {
		armAngleTalon.set(motorSpeed);

	}

	/**
	 * This stops the arm angle from changing (No rise or lowering) = speed is
	 * 0.
	 */
	public void stopArmAngleChange() {
		armAngleTalon.set(0);
	}

	/**
	 * This sets the motorSpeed to negative, lowering the arm.
	 */
	public void lowerArm() {
		armAngleTalon.set(-motorSpeed);

	}

	protected double returnPIDInput() {
		return armLengthEncoder.getDistance();
	}

	protected void usePIDOutput(double output) {
		armAngleTalon.set(output);

	}
}
