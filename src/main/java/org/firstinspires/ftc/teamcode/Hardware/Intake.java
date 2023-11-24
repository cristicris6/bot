package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Hardware_Optimisations.OptimisedMotor;
import org.firstinspires.ftc.teamcode.Hardware_Optimisations.OptimisedServo;

public class Intake {

    OptimisedMotor intake = new OptimisedMotor();

    OptimisedServo leftIntakeAngle = new OptimisedServo();
    OptimisedServo rightIntakeAngle = new OptimisedServo();

    RevColorSensorV3 leftSensor;
    RevColorSensorV3 rightSensor;

    IntakeStates intakeState = IntakeStates.TRANSFER;
    IntakeSpinnerStates intakeSpinnerState = IntakeSpinnerStates.STOP;
    IntakePixelCount intakePixels = IntakePixelCount.EMPTY;

    public Intake(){
    }

    /**INIT*/
    public void init(HardwareMap hwMap){
        intake.setName("intake_motor", hwMap);

        intake.setPower(intakeSpinnerState.get());

        intake.setDirection(DcMotorSimple.Direction.FORWARD);

        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftIntakeAngle.setName("left_intake_angle", hwMap);
        rightIntakeAngle.setName("right_intake_angle", hwMap);

        leftIntakeAngle.setPosition(intakeState.getLeftPos());
        rightIntakeAngle.setPosition(intakeState.getRightPos());

        leftSensor = hwMap.get(RevColorSensorV3.class, "left_sensor");
        rightSensor = hwMap.get(RevColorSensorV3.class, "right_sensor");
    }

    /**STATE ENUMS*/
    public enum IntakeStates{
        TRANSFER(Constants.left_intake_transfer, Constants.right_intake_transfer),
        COLLECT(Constants.left_intake_collect, Constants.right_intake_collect),
        STACK_OF_3(Constants.left_intake_3_stack, Constants.right_intake_3_stack),
        STACK_OF_5(Constants.left_intake_5_stack, Constants.right_intake_5_stack);

        double leftPos;
        double rightPos;

        IntakeStates(double leftPos, double rightPos){
            this.leftPos = leftPos;
            this.rightPos = rightPos;
        }
        double getLeftPos(){
            return leftPos;
        }

        double getRightPos(){
            return rightPos;
        }
    }

    public enum IntakeSpinnerStates{
        STOP(0.0),
        COLLECT(Constants.intake_collect_power),
        REVERSE(Constants.intake_reverse_power);

        double power;

        IntakeSpinnerStates(double power){
            this.power = power;
        }

        double get(){
            return power;
        }
    }

    public enum IntakePixelCount{
        EMPTY,
        LEFT,
        RIGHT,
        FULL;
    }


    public void update() {
        intake.setPower(intakeSpinnerState.get());
        leftIntakeAngle.setPosition(intakeState.getLeftPos());
        rightIntakeAngle.setPosition(intakeState.getRightPos());
        /*if (leftSensor.seesPixel()){
              if (rightSensor.seesPixel())
                  intakePixels = IntakePixelCount.FULL;
              else intakePixels = IntakePixelCount.LEFT;
          else if (rightSensor.seesPixel()){
              intakePixels = IntakePixelCount.RIGHT;
          else intakePixels = IntakePixelCount.EMPTY;
        }*/
    }
}
