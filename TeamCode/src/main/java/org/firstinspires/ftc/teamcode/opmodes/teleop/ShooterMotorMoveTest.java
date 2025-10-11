package org.firstinspires.ftc.teamcode.opmodes.teleop;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.subsystems.example.ShooterSubsystem;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp
public class ShooterMotorMoveTest extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        while (opModeIsActive()) {
            ShooterSubsystem Shooter = new ShooterSubsystem(hardwareMap);
            double power = gamepad1.right_trigger;

            if (gamepad1.a) {
                Shooter.runTopShooterMotor(power);

            } else if (gamepad1.b) {
                Shooter.runBottomShooterMotor(power);
            } else if (gamepad1.y) {
                Shooter.runShooter(power);
            }else{
                Shooter.runShooter(0);
            }


        }

    }
}