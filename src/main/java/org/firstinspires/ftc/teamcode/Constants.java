package org.firstinspires.ftc.teamcode;

public class Constants {

    /**Depositor constants*/
    public static double left_horizontal_extension_in = 0.0;
    public static double right_horizontal_extension_in = 0.0;
    public static double left_horizontal_extension_out = 1.0;
    public static double right_horizontal_extension_out = 1.0;

    public static double left_depo_arm_in = 0.0;
    public static double right_depo_arm_in = 1.0 - left_depo_arm_in;
    public static double left_depo_arm_idle = 0.0;
    public static double right_depo_arm_idle = 0.0;
    public static double left_depo_arm_score = 0.0;
    public static double right_depo_arm_score = 1.0 - left_depo_arm_score;

    public static double left_depo_door_closed = 0.0;
    public static double right_depo_door_closed = 0.0;
    public static double left_depo_door_open = 0.0;
    public static double right_depo_door_open = 0.0;

    public static int pixel_1_position = 0;
    public static int pixel_level_increment = 0;
    
    /**Intake constants*/
    public static double left_intake_collect = 0.0;
    public static double right_intake_collect = 1.0 - left_intake_collect;
    public static double left_intake_3_stack = 0.0;
    public static double right_intake_3_stack = 1.0 - left_intake_3_stack;
    public static double left_intake_5_stack = 0.0;
    public static double right_intake_5_stack = 1.0 - left_intake_5_stack;
    public static double left_intake_transfer = 0.0;
    public static double right_intake_transfer = 1.0 - left_intake_transfer;

    public static double intake_collect_power = 1.0;
    public static double intake_reverse_power = -0.5;

    /**Launcher constants*/
    public static double trigger_loaded = 0.0;
    public static double trigger_released = 0.0;
}
