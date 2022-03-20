package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.Subsystems.RobotMap;

public class SwitchDrive extends Command {
  static double rightTurnValue;
  static double leftTurnValue;
  static double leftTurnPercent;
  static double rightTurnPercent;
  
  public SwitchDrive() {
    requires(Robot.driveTrain);
  }


  @Override
  protected void initialize() {
    Robot.driveTrain.setLeftMotors(RobotMap.NOTHING);
    Robot.driveTrain.setRightMotors(RobotMap.NOTHING);
  }


  @Override
  public void execute() {
    switch (Robot.oi.getDrivingType()) {
      case RobotMap.TANK_DRIVE_DRIVING:
        tankDriveExecute();
        break;
      case RobotMap.VIDEO_GAME_DRIVING:
        videoGameDriveExecute();
        break;
      default:
        tankDriveExecute();
        break;
    }
    SmartDashboard.putString("Drive Mode", Robot.oi.sayCurrentCommand());
  }


  @Override
  protected boolean isFinished() {
    return false;
  }


  @Override
  protected void end() {
    Robot.driveTrain.setLeftMotors(RobotMap.NOTHING);
    Robot.driveTrain.setRightMotors(RobotMap.NOTHING);
  }


  @Override
  protected void interrupted() {
  }

  private static void tankDriveExecute() {
    double leftStickY = Robot.oi.getDriverRawAxis(RobotMap.LEFT_STICK_Y);
    double rightStickY = Robot.oi.getDriverRawAxis(RobotMap.RIGHT_STICK_Y);

    Robot.driveTrain.setLeftMotors(leftStickY * Robot.oi.getDrivingPower());
    Robot.driveTrain.setRightMotors(rightStickY * Robot.oi.getDrivingPower());

    Robot.driveTrain.takeIn(Robot.oi.getDifferenceInBumpers() * Robot.oi.getIntakePower());

    Robot.driveTrain.shoot(Robot.oi.isButtonPressed(1) * Robot.oi.getShootingPower());

    Robot.driveTrain.engage(Robot.oi.isButtonPressed(RobotMap.X_BUTTON) * Robot.oi.getEngagerPower());

    Robot.driveTrain.climb(Robot.oi.getDifferenceInTriggers());
  }

  private static void videoGameDriveExecute() {
    double turnValue = Robot.oi.getDriverRawAxis(RobotMap.LEFT_STICK_X);

    if (turnValue >= 0) { rightTurnValue = turnValue; } else { rightTurnValue = 0; }
    if (turnValue < 0) { leftTurnValue = -turnValue; } else { leftTurnValue = 0; }

    Robot.driveTrain.setLeftMotors
    ((Robot.oi.getDifferenceInTriggers() - leftTurnValue) * Robot.oi.getDrivingPower());

    Robot.driveTrain.setRightMotors
    ((Robot.oi.getDifferenceInTriggers() - rightTurnValue) * Robot.oi.getDrivingPower());
    
    Robot.driveTrain.takeIn(Robot.oi.getDifferenceInBumpers()* Robot.oi.getIntakePower());

    Robot.driveTrain.shoot(Robot.oi.isButtonPressed(1) * Robot.oi.getShootingPower());

    Robot.driveTrain.climb(Robot.oi.getDriverRawAxis
    (RobotMap.RIGHT_STICK_Y) * Robot.oi.getClimbingPower());

  }
}
