package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput; 
import frc.robot.Robot;
import frc.robot.Constants;
import frc.robot.utils.SmartShuffleboard;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class IntakeSubsystem extends SubsystemBase{
    private WPI_TalonSRX intakeMotor1;
    private WPI_TalonSRX intakeMotor2;
    private DigitalInput intakeSensor1;
    private DigitalInput intakeSensor2;

    public IntakeSubsystem() {
        intakeMotor1 = new WPI_TalonSRX(Constants.INTAKE_MOTOR_ID_1);
        intakeMotor2 = new WPI_TalonSRX(Constants.INTAKE_MOTOR_ID_2)
        intakeSensor1 = new DigitalInput(Constants.INTAKE_SENSOR_ID_1);
        intakeSensor2 = new DigitalInput(Constants.INTAKE_SENSOR_ID_2);
        int TIMEOUT = 100;

        intakeMotor1.configNominalOutputForward(0, TIMEOUT);
        intakeMotor2.configNominalOutputForward(0, TIMEOUT);
        intakeMotor1.configNominalOutputReverse(0, TIMEOUT);
        intakeMotor2.configNominalOutputReverse(0, TIMEOUT);
        intakeMotor1.configPeakOutputForward(1, TIMEOUT);
        intakeMotor2.configPeakOutputForward(1, TIMEOUT);
        intakeMotor1.configPeakOutputReverse(-1, TIMEOUT);
        intakeMotor2.configPeakOutputReverse(-1, TIMEOUT);
        intakeMotor1.setNeutralMode(NeutralMode.Brake);
        intakeMotor2.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic() {
      if (Constants.ENABLE_DEBUG) {
        SmartShuffleboard.put("Intake Sensors", "intake sensor 1", intakeSensor1.get());
        SmartShuffleboard.put("Intake Sensors", "intake sensor 2", intakeSensor2.get());
      }
    }

    public void spinMotor1(double speed) {
        intakeMotor1.set(speed);
    }

    public void spinMotor2(double speed) {
        intakeMotor2.set(speed);
    }

    public boolean isRingInIntake() {
        return !intakeSensor1.get() || !intakeSensor2.get();
    }

    public boolean getIntakeSensor1() {
        return intakeSensor1.get();
    }
    
    public boolean getIntakeSensor2() {
        return intakeSensor2.get();
    }
}
