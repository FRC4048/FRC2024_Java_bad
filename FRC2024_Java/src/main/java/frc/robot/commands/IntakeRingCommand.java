package frc.robot.commands.IntakeRingCommand;

import frc.robot.commands.LoggedCommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeRingCommand extends LoggedCommandBase {
    private IntakeSubsystem intakeSubsystem;
    private double initTime;
    private int ringDetections;
    private int timeOut = 60;

    public IntakeRingCommand(IntakeSubsystem intakeSubsystem, int timeOut) {
        addRequirements(intakeSubsystem);
        this.intakeSubsystem = intakeSubsystem;
        this.timeOut = timeOut;
    }

    @Override
    public void initialize() {
        initTime = Timer.getFPGATimestamp();
    }
  
    @Override
    public void execute() {
        intakeSubsystem.spinMotor1(Constants.INTAKE_MOTOR_SPEED_1);
        intakeSubsystem.spinMotor2(Constants.INTAKE_MOTOR_SPEED_2);
        if (intakeSubsystem.isRingInIntake()) {
            ringDetections++;
        } else {
            ringDetections = 0;
        }
        SmartDashboard.putNumber("Ring Detectors", ringDetections);
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.spinMotor1(0);
        intakeSubsystem.spinMotor2(0);
    }

    @Override
    public boolean isFinished() {
        return((ringDetections>=5) || (Timer.getFPGATimestamp() - initTime) >= timeOut);
    }
}