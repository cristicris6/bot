package org.firstinspires.ftc.teamcode.Hardware;

import static com.sun.tools.doclint.Entity.or;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Hardware_Optimisations.OptimisedMotor;

public class Drivetrain {

    OptimisedMotor frontLeft = new OptimisedMotor();
    OptimisedMotor frontRight = new OptimisedMotor();
    OptimisedMotor rearLeft = new OptimisedMotor();
    OptimisedMotor rearRight = new OptimisedMotor();

    public Drivetrain(){
    }

    public void init(HardwareMap hwMap){
        frontLeft.setName("frontLeft", hwMap);
        frontRight.setName("frontRight", hwMap);
        rearLeft.setName("rearLeft", hwMap);
        rearRight.setName("rearRight", hwMap);

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        rearLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        rearRight.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rearRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeft.setPower(0.0);
        frontRight.setPower(0.0);
        rearLeft.setPower(0.0);
        rearRight.setPower(0.0);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void mecanumDrive(Gamepad gamepad){
        double drive = -gamepad.left_stick_y;
        double strafe = gamepad.left_stick_x;
        double turn = gamepad.right_stick_x;

        double flPower = drive + strafe + turn;
        double frPower = drive - strafe - turn;
        double rlPower = drive - strafe + turn;
        double rrPower = drive + strafe - turn;

        double maxPower = Math.max(Math.max(Math.abs(flPower), Math.abs(rlPower)), Math.max(Math.abs(frPower), Math.abs(rrPower)));
        if (maxPower > 1.0){
            flPower/=maxPower;
            frPower/=maxPower;
            rlPower/=maxPower;
            rrPower/=maxPower;
        }

        frontLeft.setPower(flPower);
        frontRight.setPower(frPower);
        rearLeft.setPower(rlPower);
        rearRight.setPower(rrPower);
    }
}
