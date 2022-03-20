package frc.robot;

import java.text.DecimalFormat;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Commands.DriveStraight;
import frc.robot.Commands.FaceBack;
import frc.robot.Commands.FaceLeft;
import frc.robot.Commands.FaceRight;
import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.OI;
import frc.robot.Subsystems.RobotMap;

public class Robot extends TimedRobot {
  public static DriveTrain driveTrain = new DriveTrain();
  public static final DecimalFormat twoDecimalPlaceFormat = new DecimalFormat("###.##");
  public static final DecimalFormat wholeNumberFormat = new DecimalFormat("###");
  public static OI oi = new OI();


  @Override
  public void robotInit() {
    driveTrain.calibrate();
  }

  @Override
  public void robotPeriodic() {
    
    SmartDashboard.putString
    ("Battery Voltage", wholeNumberFormat.format(driveTrain.getBatteryVoltage()) + " Volts");

    SmartDashboard.putBoolean("Power Avaliability", driveTrain.doWeHavePower());

    SmartDashboard.putString
    ("Gyroscope Angle", driveTrain.getAngle() + " Degrees");

    SmartDashboard.putString
    ("Gyroscope Rate", driveTrain.getRate() + " Degrees Per Second");

    oi.showClimberPower(driveTrain.currentClimbPower);

    Scheduler.getInstance().run();

  }


  @Override
  public void autonomousInit() {

    switch (oi.getAutonomousCommand()) {
      case RobotMap.FACE_LEFT:
        FaceLeft faceLeft = new FaceLeft();
        faceLeft.start();
        break;
      case RobotMap.FACE_RIGHT:
        FaceRight faceRight = new FaceRight();
        faceRight.start();
        break;
      case RobotMap.FACE_BACK:
        FaceBack faceBack = new FaceBack();
        faceBack.start();
        break;
      case RobotMap.DRIVE_STRAIGHT:
        DriveStraight driveStraight = new DriveStraight();
        driveStraight.start();
        break;
    }
  }


  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putString("Current Autonomous Command", oi.sayCurrentAutonomousCommand());
  }
  

  @Override
  public void teleopInit() {
  }
  

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }


  @Override
  public void testInit() {
    oi.startGui();
  }


  @Override
  public void testPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    driveTrain.climber.set(ControlMode.PercentOutput, driveTrain.currentClimbPower);
  }

}
