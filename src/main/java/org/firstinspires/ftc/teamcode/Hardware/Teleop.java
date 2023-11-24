package org.firstinspires.ftc.teamcode.Hardware;
import android.graphics.ColorSpace;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.Hardware.Depositor.LiftStates;
import org.firstinspires.ftc.teamcode.Hardware.Intake.IntakeStates;



public class TeleOp{
    boolean currentGamepad;
    boolean previousGamepad;
    public void(Gamepad Gamepad    LiftStates LiftStates) {
        boolean currentGamepad;
        boolean previousGamepad;
        LiftStates = LiftStates.RETRACT;
        if (!currentGamepad.dpad_up && previousGamepad.dpad_up) {
            LiftStates = (LiftStates + 1) % 11;


        }
    }
        public void(IntakeStates IntakeStates Gamepad Gamepad){
        if(!currentGamepad.a && previousGamepad.a){
            Intake.IntakeStates.COLLECT = Intake.IntakeStates.TRANSFER
        }
        }


        }
