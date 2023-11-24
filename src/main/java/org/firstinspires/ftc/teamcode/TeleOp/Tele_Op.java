package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.ftccommon.external.OnCreateEventLoop;
import org.firstinspires.ftc.teamcode.Hardware.Depositor;
import org.firstinspires.ftc.teamcode.Hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.Hardware.Drone_Launcher;
import org.firstinspires.ftc.teamcode.Hardware.Intake;

@TeleOp(name="TeleOp", group="TeleOp")
public class Tele_Op extends LinearOpMode {

    Drivetrain dt = new Drivetrain();
    Intake intake = new Intake();
    Depositor depo = new Depositor();
    Drone_Launcher launcher = new Drone_Launcher();

    @Override
    public void runOpMode(){

        dt.init(hardwareMap);
        intake.init(hardwareMap);
        depo.init(hardwareMap);
        launcher.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()){
            /**Drivetrain controls*/
            //if (dt.isRequested())
                dt.mecanumDrive(gamepad1);

            /**Intake controls*/
                intake.update();

            /**Depositor controls*/
                depo.update();

            /**Launcher controls*/
                launcher.update();
        }

    }
}
