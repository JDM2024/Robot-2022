package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.RobotMap;

public class FaceBack extends Command {

  public FaceBack() {
    requires(Robot.driveTrain);
  }


  @Override
  protected void initialize() {
    Robot.driveTrain.setLeftMotors(RobotMap.NOTHING);
    Robot.driveTrain.setRightMotors(RobotMap.NOTHING);
  }


  @Override
  protected void execute() {
      if (Robot.driveTrain.getAngle() > RobotMap.BACK_ANGLE) {
        Robot.driveTrain.setLeftMotors(-Robot.oi.getDrivingPower());
        Robot.driveTrain.setRightMotors(Robot.oi.getDrivingPower());
      }
      if (Robot.driveTrain.getAngle() < RobotMap.BACK_ANGLE) {
        Robot.driveTrain.setLeftMotors(Robot.oi.getDrivingPower());
        Robot.driveTrain.setRightMotors(-Robot.oi.getDrivingPower());
      }
  }


  @Override
  protected boolean isFinished() {
    if (Robot.driveTrain.getAngle() == RobotMap.BACK_ANGLE || Robot.driveTrain.getAngle() == -RobotMap.BACK_ANGLE) {
      return true;
    } else { return false;}
  }


  @Override
  protected void end() {
    Robot.driveTrain.setLeftMotors(RobotMap.NOTHING);
    Robot.driveTrain.setRightMotors(RobotMap.NOTHING);
  }


  @Override
  protected void interrupted() {
    Robot.driveTrain.setLeftMotors(RobotMap.NOTHING);
    Robot.driveTrain.setRightMotors(RobotMap.NOTHING);
  }
}
