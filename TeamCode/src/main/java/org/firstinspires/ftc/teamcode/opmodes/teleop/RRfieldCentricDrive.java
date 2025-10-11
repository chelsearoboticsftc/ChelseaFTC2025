package org.firstinspires.ftc.teamcode.opmodes.teleop;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MecanumDrive;


@TeleOp
public class RRfieldCentricDrive extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException{

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

        waitForStart();

        while(opModeIsActive()) {
            //update the robot's idea of where we are
            PoseVelocity2d posEstimate = drive.updatePoseEstimate();

            //get the vector of input
            Vector2d input = new Vector2d(
                    -gamepad1.left_stick_y,
                    -gamepad1.left_stick_x
            );

            //manipulate the direction to allways be the direction you input.

            PoseVelocity2d powers = new PoseVelocity2d(input, -gamepad1.right_stick_x);


            drive.setDrivePowers(
                    powers
            );
        }

    }
}
