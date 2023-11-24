package org.firstinspires.ftc.teamcode.Hardware_Optimisations;

import static org.firstinspires.ftc.teamcode.Utils.toAbsolutePosition;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class OptimisedServo {

    Servo servo;
    double lastPosition = 0.0;
    double posTolerance = 0.01;
    AnalogInput encoder;

    public OptimisedServo(){
    }

    public void setPosition(double position){
        if (Math.abs(position - lastPosition) > posTolerance) {
            servo.setPosition(position);
            lastPosition = position;
        }
    }

    public void setName(String name, HardwareMap hwMap){
        servo = hwMap.get(Servo.class, name);
    }

    public double getPosition(){
        return toAbsolutePosition(encoder.getVoltage());
    }

    public double getLastPosition(){
        return lastPosition;
    }
}
