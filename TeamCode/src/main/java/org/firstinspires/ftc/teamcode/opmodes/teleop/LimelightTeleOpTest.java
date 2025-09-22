package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.LLStatus;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class LimelightTeleOpTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{


    }
    public void init_limelight(){
        //Config here (limelight is not what it is configuired as yet in the control hub)
        Limelight3A crashlimelight = hardwareMap.get(Limelight3A.class, "limelight");
        crashlimelight.setPollRateHz(100); //How many times a second we ask for data
        crashlimelight.start();
    }


}
