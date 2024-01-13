package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class WheelAlign extends Command {
    private Drivetrain drivetrain;
    private int delay = 1000;
    private double startTime;

    public WheelAlign(Drivetrain drivetrain){
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        drivetrain.getM_frontLeft().setSteerOffset(Constants.FRONT_LEFT_ABS_ENCODER_ZERO);
        drivetrain.getM_frontRight().setSteerOffset(Constants.FRONT_RIGHT_ABS_ENCODER_ZERO);
        drivetrain.getM_backLeft().setSteerOffset(Constants.BACK_LEFT_ABS_ENCODER_ZERO);
        drivetrain.getM_backRight().setSteerOffset(Constants.BACK_RIGHT_ABS_ENCODER_ZERO);
    }

    @Override
    public void initialize() {
        super.initialize();
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public boolean isFinished() {
        return (Timer.getFPGATimestamp() - startTime) >= delay;
    }

    @Override
    public boolean runsWhenDisabled() {
        return true;
    }
}
