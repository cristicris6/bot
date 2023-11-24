package org.firstinspires.ftc.teamcode.PID_Classes;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PID_Controller {

    PID_Coefficients pid_coefficients;
    int lastError = 0;
    int errorSum = 0;
    int numberOfEntries = 0;

    public PID_Controller (PID_Coefficients pid_coefficients) {
        this.pid_coefficients = pid_coefficients;
    }

    public double update(int currentPos, int targetPos) {
        int error = targetPos - currentPos;
        numberOfEntries++;
        errorSum += error;
        double power = pid_coefficients.p * error + pid_coefficients.d * Math.abs(error - lastError) + pid_coefficients.i * (errorSum)/numberOfEntries;
        lastError = error;
        return power;
    }
}
