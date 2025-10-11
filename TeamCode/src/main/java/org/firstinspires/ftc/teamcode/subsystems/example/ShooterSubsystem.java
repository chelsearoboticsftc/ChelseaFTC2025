package org.firstinspires.ftc.teamcode.subsystems.example;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class ShooterSubsystem {

    //Declare HW objects here

    DcMotorEx flyWheelMotorTop;
    DcMotorEx flyWheelMotorBottom;
    CRServo HoodServo;

    //Declare any other global variables for this class here
    private int motorSetPosition = 0;
    private double motorPower = 0;

    public ShooterSubsystem(HardwareMap hardwareMap){
        //Constructor for the SampleSubsystem class.  This code is called everytime you create
        //an object of this class type.  Rename to match your class name.

        //'this' keyword is to eliminate the confusion between objects/attributes which are part of and parameters
        // this class and with the same name.  It refers to objects in the SampleSubsystem class in this case

        //Device names in hardwareMap.get(class,deviceName) must match names from Control Hub
        //configuration exactly.  This is the connection with the Control Hub Config

        //Example code defining a DcMotor object to a motor in the config called "motorName"
        this.flyWheelMotorTop = hardwareMap.get(DcMotorEx.class,"FW1");
        this.flyWheelMotorBottom = hardwareMap.get(DcMotorEx.class,"FW2");
        //this.HoodServo = hardwareMap.get(CRServo.class, "Hood");


        //This defines the behavior at zero power (brake or coast)
        flyWheelMotorTop.setZeroPowerBehavior(ShooterSubsystemConstants.FLYWHEEL_ZERO_POWER_BEHAVIOR);
        flyWheelMotorBottom.setZeroPowerBehavior(ShooterSubsystemConstants.FLYWHEEL_ZERO_POWER_BEHAVIOR);

        //This defines the motor direction (forward or reversed)
        flyWheelMotorBottom.setDirection(ShooterSubsystemConstants.FLYWHEEL_REVERSE);
        flyWheelMotorTop.setDirection(ShooterSubsystemConstants.FLYWHEEL_REVERSE);

        /* This defines the motor velocity PIDF gains.  Velocity PIDF values determine control    *
         * around a target velocity (setTargetVelocity) OR how fast the system responds to a      *
         * change in set position (setTargetPosition).                                            */
        flyWheelMotorBottom.setVelocityPIDFCoefficients(
                ShooterSubsystemConstants.FLYWHEEL_VELOCITY_P, //Proportional Gain
                ShooterSubsystemConstants.FLYWHEEL_VELOCITY_I, //Integral Gain
                ShooterSubsystemConstants.FLYWHEEL_VELOCITY_D, //Derivative Gain
                ShooterSubsystemConstants.FLYWHEEL_VELOCITY_F);//Feed Forward Gain

        /* This defines the motor position PID P gain. Position control only needs P gain since   *
         * once the system reaches the target position since once at position you're only         *
         * disturbances in the system                                                             */
        flyWheelMotorBottom.setPositionPIDFCoefficients(
                ShooterSubsystemConstants.FLYWHEEL_POSITION_P);//Proportional Gain

        //motorName.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }
    /* Standard functions.  All Chelsea Robotics subsystems shall have init() and update() these  *
     * methods defined. Leave empty if not needed!                                                */
    public void init(){

    }

    public void update(){
        //Call this method each time your opmode logic loops (i.e. inside while(opModeIsActive()){}
        //to execute any logic you want to be called periodically. If none, leave empty!

        //setTargetPosition needs to be called once per loop to keep the REV watchdog happy
        //motorName.setTargetPosition(motorSetPosition);
    }

   public void runShooter(double power){
       flyWheelMotorBottom.setPower(power);
       flyWheelMotorTop.setPower(power);

   }
   public void runTopShooterMotor(double power){
       flyWheelMotorTop.setPower(power);
   }
   public void runBottomShooterMotor(double power){
       flyWheelMotorBottom.setPower(power);
   }
    public void setMotorPosition(int position){
        //Call this method when you want to change the motor set position
        motorSetPosition = position;

        //Call setTargetPositionTolerance to tell REV controller how close to the target position
        //can be considered "at" the target position (e.g. target postion +/- tolerance)
        flyWheelMotorBottom.setTargetPositionTolerance(ShooterSubsystemConstants.FLYWHEEL_POSITION_TOLERANCE);
        flyWheelMotorTop.setTargetPositionTolerance(ShooterSubsystemConstants.FLYWHEEL_POSITION_TOLERANCE);
        //Call setVelocity to tell the REV controller how fast you want to get to the target position
        flyWheelMotorBottom.setVelocity(ShooterSubsystemConstants.FLYWHEEL_VELOCITY_TICKS_PER_S);
        flyWheelMotorBottom.setVelocity(ShooterSubsystemConstants.FLYWHEEL_VELOCITY_TICKS_PER_S);
        //Call setTargetPosition to tell the REV controller the position you want to move to
        flyWheelMotorBottom.setTargetPosition(motorSetPosition);

        //Call setMode(DcMotor.RunMode.RUN_TO_POSITION) to tell the REV controller you're ready to
        //move to position
        flyWheelMotorBottom.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    //Use convention "set<Parameter>" to name methods which set something. Example set<motorName>Power
    public void setMotorPower(double power){
        //Note: Calling setPower stops position hand Velocity control!!!!
        motorPower = power;
        flyWheelMotorBottom.setPower(power);
    }

    //Use convention "get<Parameter>" to name methods which return something
    //Example return motorName position
    public int getMotorPosition(){
        return flyWheelMotorBottom.getCurrentPosition();
    }

    public int getMotorTargetPosition(){
        return flyWheelMotorBottom.getTargetPosition();
    }

    public double getMotorPower(){
        return motorPower;
    }

    //Use convention "is<Condition>" to return TRUE/FALSE in response to a logical test
    //Example return TRUE if motor position is greater than a threshold defined in constants
    public boolean isMotorBusy(){
        return flyWheelMotorBottom.isBusy();
    }
}
