package org.firstinspires.ftc.teamcode.subsystems.example;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class ShooterSubsystemConstants {
    //Add subsystem constants here.  Use this to avoid magic numbers
    public static final int MOTOR_NAME_THRESHOLD = 5;
    public static final DcMotor.ZeroPowerBehavior FLYWHEEL_ZERO_POWER_BEHAVIOR = DcMotor.ZeroPowerBehavior.FLOAT;

    public static final DcMotorSimple.Direction FLYWHEEL_REVERSE = DcMotorSimple.Direction.REVERSE;
    public static final DcMotorSimple.Direction FLYWHEEL_FORWARD = DcMotorSimple.Direction.FORWARD;
    public static final double FLYWHEEL_VELOCITY_P = 1.0;
    public static final double FLYWHEEL_VELOCITY_I = 0.0;
    public static final double FLYWHEEL_VELOCITY_D = 0.0;
    public static final double FLYWHEEL_VELOCITY_F = 14.5;
    public static final int FLYWHEEL_POSITION_TOLERANCE = 5;
    public static final double FLYWHEEL_VELOCITY_TICKS_PER_S = 2200;
    public static final int FLYWHEEL_A_POSITION = 500;
    public static final int FLYWHEEL_B_POSITION = 1000;
    public static double FLYWHEEL_POSITION_P = 5.0;
}
