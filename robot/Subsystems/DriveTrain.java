package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Commands.SwitchDrive;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SPI;


public class DriveTrain extends Subsystem {

    private static final ADXRS450_Gyro gyroscope = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
    private static final WPI_VictorSPX intake = new WPI_VictorSPX (RobotMap.INTAKE);
    private static final WPI_VictorSPX shooter = new WPI_VictorSPX(RobotMap.SHOOTER);
    private static final WPI_VictorSPX engager = new WPI_VictorSPX(RobotMap.ENGAGER);
    private static final WPI_VictorSPX leftFrontDrive = new WPI_VictorSPX(RobotMap.LEFT_FRONT_DRIVE);
    private static final WPI_VictorSPX rightFrontDrive = new WPI_VictorSPX(RobotMap.RIGHT_FRONT_DRIVE);
    private static final WPI_VictorSPX leftRearDrive = new WPI_VictorSPX(RobotMap.LEFT_REAR_DRIVE);
    public final WPI_VictorSPX climber = new WPI_VictorSPX(RobotMap.CLIMBER);
    private static final WPI_VictorSPX rightRearDrive = new WPI_VictorSPX(RobotMap.RIGHT_REAR_DRIVE);
    private static double batteryVoltage;
    private static double realAngle;
    public double currentClimbPower = 0.0;
    

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new SwitchDrive());
  }

  
  public void setLeftMotors(double leftSpeed) {
      leftRearDrive.set(ControlMode.PercentOutput, leftSpeed, DemandType.ArbitraryFeedForward, 0);
      leftFrontDrive.set(ControlMode.PercentOutput, leftSpeed, DemandType.ArbitraryFeedForward, 0);
      
  }

  public void setRightMotors(double rightSpeed) {
      rightRearDrive.set(ControlMode.PercentOutput, -rightSpeed, DemandType.ArbitraryFeedForward, 0);
      rightFrontDrive.set(ControlMode.PercentOutput, -rightSpeed, DemandType.ArbitraryFeedForward, 0);
  }

  public void takeIn (double power) {
    intake.set(ControlMode.PercentOutput, power);;
  }

  public void shoot (double power) {
    shooter.set(ControlMode.PercentOutput, power);
  }

  public void engage (double power) {
    engager.set(ControlMode.PercentOutput, power);
  }

  public void climb (double power) {
    climber.set(ControlMode.PercentOutput, power);
    currentClimbPower = power;
  }

  public double getRate() {
    return Math.round(gyroscope.getRate());
  }

  public long getAngle() {
    if (gyroscope.getAngle() >= 360) {
      realAngle = gyroscope.getAngle() - 360;
    } else { realAngle = gyroscope.getAngle(); }
    return Math.round(realAngle);
  }

  public void calibrate() {
    gyroscope.calibrate();
  }

  public double getBatteryVoltage() {
    batteryVoltage = RobotController.getBatteryVoltage();
    return batteryVoltage;
  }


  public boolean doWeHavePower() {
    if (batteryVoltage <= 10) {
      return false;
    }
    else {
      return true;
    }
  }

}