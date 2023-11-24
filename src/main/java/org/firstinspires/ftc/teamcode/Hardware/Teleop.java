package org.firstinspires.ftc.teamcode.Hardware;
import android.graphics.ColorSpace;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.Hardware.Depositor.LiftStates;
import org.firstinspires.ftc.teamcode.Hardware.Intake.IntakeStates;
import org.firstinspires.ftc.teamcode.Hardware.Intake.IntakeSpinnerStates



public class TeleOp{

    public void(Gamepad currentgamepad Gamepad previousgamepad   LiftStates LiftStates) {
        boolean currentgamepad;
        boolean previousgamepad;
        LiftStates = LiftStates.RETRACT;
        if (currentgamepad.dpad_up && !previousgamepad.dpad_up) {
            LiftStates = (LiftStates + 1) % 11;


        }
    }
        public void(Gamepad gamepad IntakeStates IntakeStates ) {
            boolean currentgamepad;
            boolean previousgamepad;
            if (!currentgamepad.a && !previousgamepad.a) {
                Intake.IntakeStates.COLLECT = Intake.IntakeStates.TRANSFER
            }
        }

        public void(Gamepad gamepad IntakeSpinnerStates IntakeSpinnerStates ){
        if(gamepad.right_trigger){
            IntakeSpinnerStates.COLLECT;
        }
        else if(gamepad.left_trigger){
            IntakeSpinnerStates.REVERSE
        }
        else IntakeSpinnerStates.STOP



        }
