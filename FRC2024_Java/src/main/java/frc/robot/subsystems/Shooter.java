// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;

public class Shooter extends SubsystemBase {
  
  private final Spark shooterWheel1;
  private final Spark shooterWheel2;
  private final DigitalInput shooterSensor;

  public Shooter() {
    shooterWheel1 = new Spark(Constants.SHOOTER_MOTOR_ID_1);
    shooterWheel2 = new Spark(Constants.SHOOTER_MOTOR_ID_2);
    shooterSensor = new DigitalInput(Constants.SHOOTER_SENSOR_ID);
  }

  //Method to spin shooter motors
  public void spinMotors(double speed) {
    shooterWheel1.set(speed);
    shooterWheel2.set(speed);
  }

  //Method to stop shooter motors
  public void stopMotor() {
    shooterWheel1.stopMotor();
    shooterWheel2.stopMotor();
  }

  //Get the status of the shooter sensor
  public boolean getShooterSensorActivated() {
    return shooterSensor.get();
  }

}
