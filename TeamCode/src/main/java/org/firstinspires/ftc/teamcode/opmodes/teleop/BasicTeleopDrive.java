package org.firstinspires.ftc.teamcode.opmodes.teleop;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.example.SampleVision;
import org.firstinspires.ftc.teamcode.subsystems.example.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.example.ShooterSubsystem;

//Vaughn
@TeleOp
public class BasicTeleopDrive extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));

        waitForStart();
        double distance;

        while(opModeIsActive()){
           //Start of Rob's vision
            SampleVision GoalDistance = new SampleVision(hardwareMap);

                distance = GoalDistance.getDistanceToGoal(20);
                //20 equals BLUE team
                telemetry.addLine(String.format("range %6.1f inch",
                        distance));
                telemetry.update();
                sleep(5000);
            //End of Rob's vision
            ShooterSubsystem Shooter = new ShooterSubsystem(hardwareMap);
            drive.setDrivePowers(
                    new PoseVelocity2d(
                            new Vector2d(-gamepad1.left_stick_y,
                                         -gamepad1.left_stick_x),
                            -gamepad2.right_stick_x));
            if(gamepad1.a){
                Shooter.runShooter(-1);
            }else{
                Shooter.runShooter(0);
            }
        }
    }
}
