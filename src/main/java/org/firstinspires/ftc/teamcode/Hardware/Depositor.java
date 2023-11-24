package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Hardware_Optimisations.LimitSwitch;
import org.firstinspires.ftc.teamcode.Hardware_Optimisations.OptimisedMotor;
import org.firstinspires.ftc.teamcode.Hardware_Optimisations.OptimisedServo;
import org.firstinspires.ftc.teamcode.PID_Classes.PID_Coefficients;
import org.firstinspires.ftc.teamcode.PID_Classes.PID_Controller;

public class     Depositor{

    OptimisedMotor leftSlide = new OptimisedMotor();
    OptimisedMotor rightSlide = new OptimisedMotor();

    OptimisedServo leftHorizExt = new OptimisedServo();
    OptimisedServo rightHorizExt = new OptimisedServo();
    OptimisedServo leftDepoArm = new OptimisedServo();
    OptimisedServo rightDepoArm = new OptimisedServo();
    OptimisedServo leftDepoDoor = new OptimisedServo();
    OptimisedServo rightDepoDoor = new OptimisedServo();

    LimitSwitch slideSwitch = new LimitSwitch();

    PID_Coefficients pid = new PID_Coefficients(0.0,0.0,0.0);
    PID_Controller liftController = new PID_Controller(pid);

    LiftStates liftState = LiftStates.RETRACT;
    LeftArmStates leftArmState = LeftArmStates.IN;
    RightArmStates rightArmState = RightArmStates.IN;
    LeftExtension leftExtensionState = LeftExtension.IN;
    RightExtension rightExtensionState = RightExtension.IN;

    public Depositor(){
    }

    public void init (HardwareMap hwMap){
        leftSlide.setName("left_slide", hwMap);
        rightSlide.setName("right_slide", hwMap);

        leftSlide.setPower(0.0);
        rightSlide.setPower(0.0);

        leftSlide.setDirection(DcMotorSimple.Direction.FORWARD);
        rightSlide.setDirection(DcMotorSimple.Direction.REVERSE);

        leftSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftHorizExt.setName("left_horizontal_extension", hwMap);
        rightHorizExt.setName("right_horizontal_extension", hwMap);
        leftDepoArm.setName("left_depositor_arm", hwMap);
        rightDepoArm.setName("right_depositor_arm", hwMap);
        leftDepoDoor.setName("left_depositor_door", hwMap);
        rightDepoDoor.setName("right_depositor_door", hwMap);

        leftHorizExt.setPosition(leftExtensionState.get());
        rightHorizExt.setPosition(rightExtensionState.get());
        leftDepoArm.setPosition(leftArmState.getArmPos());
        rightDepoArm.setPosition(rightArmState.getArmPos());
        leftDepoDoor.setPosition(leftArmState.getDoorPos());
        rightDepoDoor.setPosition(rightArmState.getDoorPos());

        slideSwitch.setName("slide_switch", hwMap);

    }

    public enum LeftArmStates{
        IN(Constants.left_depo_arm_in, Constants.left_depo_door_closed),
        IDLE(Constants.left_depo_arm_idle, Constants.left_depo_door_closed),
        OUT(Constants.left_depo_arm_score, Constants.left_depo_door_closed),
        SCORE(Constants.left_depo_arm_score, Constants.left_depo_door_open);

        double armPos;
        double doorPos;

        LeftArmStates(double armPos, double doorPos){
            this.armPos = armPos;
            this.doorPos = doorPos;
        }

        double getArmPos(){
            return armPos;
        }

        double getDoorPos(){
            return doorPos;
        }
    }

    public enum RightArmStates{
        IN(Constants.right_depo_arm_in, Constants.right_depo_door_closed),
        IDLE(Constants.right_depo_arm_idle, Constants.right_depo_door_closed),
        OUT(Constants.right_depo_arm_score, Constants.right_depo_door_closed),
        SCORE(Constants.right_depo_arm_score, Constants.right_depo_door_open);

        double armPos;
        double doorPos;

        RightArmStates(double armPos, double doorPos){
            this.armPos = armPos;
            this.doorPos = doorPos;
        }

        double getArmPos(){
            return armPos;
        }

        double getDoorPos(){
            return doorPos;
        }
    }

    public enum LeftExtension{
        IN(Constants.left_horizontal_extension_in),
        OUT(Constants.left_horizontal_extension_out);

        double pos;

        LeftExtension(double pos){
            this.pos = pos;
        }

        double get(){
            return pos;
        }
    }

    public enum RightExtension{
        IN(Constants.right_horizontal_extension_in),
        OUT(Constants.right_horizontal_extension_out);

        double pos;

        RightExtension(double pos){
            this.pos = pos;
        }

        double get(){
            return pos;
        }
    }

    public enum LiftStates{
        RETRACT(0),
        PIXEL1(Constants.pixel_1_position),
        PIXEL2(Constants.pixel_1_position + Constants.pixel_level_increment),
        PIXEL3(Constants.pixel_1_position + Constants.pixel_level_increment * 2),
        PIXEL4(Constants.pixel_1_position + Constants.pixel_level_increment * 3),
        PIXEL5(Constants.pixel_1_position + Constants.pixel_level_increment * 4),
        PIXEL6(Constants.pixel_1_position + Constants.pixel_level_increment * 5),
        PIXEL7(Constants.pixel_1_position + Constants.pixel_level_increment * 6),
        PIXEL8(Constants.pixel_1_position + Constants.pixel_level_increment * 7),
        PIXEL9(Constants.pixel_1_position + Constants.pixel_level_increment * 8),
        PIXEL10(Constants.pixel_1_position + Constants.pixel_level_increment * 9),
        PIXEL11(Constants.pixel_1_position + Constants.pixel_level_increment * 10);

        int pos;

        LiftStates(int pos){
            this.pos = pos;
        }

        int get(){
            return pos;
        }
    }

    public void update(){
        leftSlide.setPower(liftController.update(leftSlide.getCurrentPosition(), liftState.get()));
        rightSlide.setPower(liftController.update(leftSlide.getCurrentPosition(), liftState.get()));
        leftDepoArm.setPosition(leftArmState.getArmPos());
        leftDepoDoor.setPosition(leftArmState.getDoorPos());
        rightDepoArm.setPosition(rightArmState.getArmPos());
        rightDepoDoor.setPosition(rightArmState.getDoorPos());
        leftHorizExt.setPosition(leftExtensionState.get());
        rightHorizExt.setPosition(rightExtensionState.get());
    }
}
