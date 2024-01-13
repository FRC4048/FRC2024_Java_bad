package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;

public class Shoot extends Command {

    private Shooter shooter;
    Timer timer = new Timer();

    @Override
    public void initialize() {
        //Reset & Start timer
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        //Spin motors once started
        shooter.spinMotor(0.75);
    }

    @Override public boolean isFinished() {
        //Check if sensor has been activated and it has been 1 second
        if ((shooter.getShooterSensorActivated() == true) && (timer.advanceIfElapsed(1))) {
            shooter.stopMotor();
            return true;
        }

        else {
            return false;
        }
    }
    
}
