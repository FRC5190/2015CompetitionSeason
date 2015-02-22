package org.usfirst.frc.team5190.robot;

import edu.wpi.first.wpilibj.I2C.Port;

public class RobotMap {
	// arm
	public static final int ARM_POTENTIOMETER_PORT = 1;
	public static final int ARM_CANTALONLEFT_PORT = 11;
	public static final int ARM_CANTALONRIGHT_PORT = 12;
	public static final int ARM_MIN_LIMIT_SWITCH_PORT = 0; // Get a real value
	public static final int ARM_MAX_LIMIT_SWITCH_PORT = 1; // Get a real value

	// cherry picker
	public static final int CHERRY_PICKER_TALON_PORT = 2;
	public static final int CHERRY_PICKER_MIN_LIMIT_SWITCH_PORT = 3;
	public static final int CHERRY_PICKER_MAX_LIMIT_SWITCH_PORT = 2;

	// drive train
	public static final int FRONTLEFT = 1;
	public static final int BACKLEFT = 2;
	public static final int FRONTRIGHT = 3;
	public static final int BACKRIGHT = 0;

	public static final int ENCODER_RIGHT_CHANNEL_A = 2;
	public static final int ENCODER_RIGHT_CHANNEL_B = 3;
	public static final int ENCODER_LEFT_CHANNEL_A = 4;
	public static final int ENCODER_LEFT_CHANNEL_B = 5;

	// sensors
	public static final int GYRO_PORT = 1;
	public static final Port LIDAR_PORT = Port.kMXP;
}
