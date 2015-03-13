package org.usfirst.frc.team5190.robot.oi;

import org.usfirst.frc.team5190.robot.commands.ArmLevelDownCommand;
import org.usfirst.frc.team5190.robot.commands.ArmLevelUpCommand;
import org.usfirst.frc.team5190.robot.commands.LockPawlCommand;
import org.usfirst.frc.team5190.robot.commands.UnlockPawlCommand;
import org.usfirst.frc.team5190.robot.joystick.LogitechGamepad;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class GamepadOI implements OI {

	private Joystick gamepad;
	private Button lockPawl;
	private Button unLockPawl;

	public GamepadOI() {
		this(0);
	}

	public GamepadOI(int port) {
		gamepad = new Joystick(port);
		lockPawl = new JoystickButton(gamepad, LogitechGamepad.Y_BUTTON);
		unLockPawl = new JoystickButton(gamepad, LogitechGamepad.X_BUTTON);
		lockPawl.whenPressed(new LockPawlCommand());
		unLockPawl.whenPressed(new UnlockPawlCommand());
		JoystickButton levelUpCommand = new JoystickButton(gamepad,
				LogitechGamepad.B_BUTTON);
		levelUpCommand.whenPressed(new ArmLevelUpCommand());
		JoystickButton levelDownCommand = new JoystickButton(gamepad,
				LogitechGamepad.A_BUTTON);
		levelDownCommand.whenPressed(new ArmLevelDownCommand());
	}

	public Joystick getGamepad() {
		return gamepad;
	}

	@Override
	public double getForwardReverseAxis() {
		return -gamepad.getRawAxis(LogitechGamepad.RIGHT_JOYSTICK_Y_AXIS);
	}

	@Override
	public double getLeftRightAxis() {
		return -gamepad.getRawAxis(LogitechGamepad.RIGHT_JOYSTICK_X_AXIS);
	}

	@Override
	public double getArmAxis() {
		return -gamepad.getRawAxis(LogitechGamepad.LEFT_JOYSTICK_Y_AXIS);
	}

	@Override
	public double getCherryPickerAxis() {
		double retractValue = gamepad
				.getRawAxis(LogitechGamepad.LEFT_TRIGGER_AXIS);
		double extendValue = gamepad
				.getRawAxis(LogitechGamepad.RIGHT_TRIGGER_AXIS);
		if (retractValue > 0.0) {
			return -retractValue;
		}
		return extendValue;
	}

	// @Override
	@Override
	public double getPawlAxis() {
		return -gamepad.getRawAxis(LogitechGamepad.LEFT_JOYSTICK_X_AXIS);
	}

}
