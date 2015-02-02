package org.usfirst.frc.team5190.robot.subsystems;

import org.usfirst.frc.team5190.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;

public class PIDEncoderDriveTrain implements PIDSource {
	private Encoder right, left;

	PIDEncoderDriveTrain() {
		right = new Encoder(RobotMap.ENCODER_RIGHT_CHANNEL_A,
				RobotMap.ENCODER_RIGHT_CHANNEL_B, false, EncodingType.k4X);
		right.setDistancePerPulse(0.068);
		left = new Encoder(RobotMap.ENCODER_LEFT_CHANNEL_A,
				RobotMap.ENCODER_LEFT_CHANNEL_B, true, EncodingType.k4X);
		left.setDistancePerPulse(0.068);
	}

	public Encoder getRight() {
		return right;
	}

	public Encoder getLeft() {
		return left;
	}

	@Override
	public double pidGet() {
		return (right.getDistance() + left.getDistance()) / 2;
	}

}
