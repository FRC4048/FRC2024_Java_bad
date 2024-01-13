package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkLimitSwitch.Type;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Ramp extends SubsystemBase {
    private CANSparkMax neoMotor;
    private RelativeEncoder encoder;
    private SparkPIDController pidController;
    private double pidP = Constants.RAMP_PID_P;
    private double pidI = Constants.RAMP_PID_I;
    private double pidD = Constants.RAMP_PID_D;
    private double pidFF = Constants.RAMP_PID_FF;
    private double iZoneError = Constants.RAMP_ERROR_IZONE;

    public Ramp() {
        neoMotor = new CANSparkMax(Constants.RAMP_ID, MotorType.kBrushless);
        neoMotor.restoreFactoryDefaults();
        encoder = neoMotor.getEncoder();
        neoMotor.getForwardLimitSwitch(Type.kNormallyOpen);
        neoMotor.getReverseLimitSwitch(Type.kNormallyOpen);

        pidController = neoMotor.getPIDController();
        pidController.setP(pidP);
        pidController.setI(pidI);
        pidController.setD(pidD);
        pidController.setIZone(iZoneError);
        pidController.setFF(pidFF);
        pidController.setOutputRange(-1, 1);

        pidController.setSmartMotionMaxVelocity(500.0, 0);
        pidController.setSmartMotionMinOutputVelocity(0.0, 0);
        pidController.setSmartMotionMaxAccel(1500.0, 0);
        pidController.setSmartMotionAllowedClosedLoopError(0.0, 0);

        //SmartShuffleboard.put("Ramp", "PID P", pidP);
        //SmartShuffleboard.put("Ramp", "PID I", pidI);
        //SmartShuffleboard.put("Ramp", "PID D", pidD);
    }
        public void periodic() {

            //SmartShuffleboard.put("Arm", "P Gain", pidController.getP());
            //SmartShuffleboard.put("Arm", "I Gain", pidController.getI());
            //SmartShuffleboard.put("Arm", "D Gain", pidController.getD());
            //SmartShuffleboard.put("Arm", "FF Gain", pidController.getFF());
            //SmartShuffleboard.put("Arm", "Encoder Value", encoder.getPosition());
            //SmartShuffleboard.put("Arm", "Desired pos", armpos);
        
    }
 }
