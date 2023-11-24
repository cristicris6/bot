package org.firstinspires.ftc.teamcode.Hardware_Optimisations;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import static org.firstinspires.ftc.teamcode.Utils.toAbsolutePosition;

public class OptimisedCRServo {

    CRServo crservo;
    double lastPower = 2.0;
    double powerTolerance = 0.01;
    AnalogInput encoder;
    boolean hasEncoder = false;

    public OptimisedCRServo(boolean hasEncoder){
        this.hasEncoder = hasEncoder;
    }

    public void setName(String name, HardwareMap hwMap){
        crservo = hwMap.get(CRServo.class, name);
    }

    public void setEncoderName(String name, HardwareMap hwMap){
        encoder = hwMap.get(AnalogInput.class, name);
    }

    public void setPower(double power){
        if (Math.abs(power - lastPower) > powerTolerance) {
            crservo.setPower(power);
            lastPower = power;
        }
    }

    public double getPower(){
        return crservo.getPower();
    }

    public void setDirection(CRServo.Direction direction){
        crservo.setDirection(direction);
    }

    public double getPosition(){
        if (hasEncoder)
            return toAbsolutePosition(encoder.getVoltage());
        else return 0;
    }
}
