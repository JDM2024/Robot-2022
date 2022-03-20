package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.RobotMap;

public class FaceRight extends Command {

  public FaceRight() {
    requires(Robot.driveTrain);
  }

  @Override
  protected void initialize() {
    Robot.driveTrain.setLeftMotors(RobotMap.NOTHING);
    Robot.driveTrain.setRightMotors(RobotMap.NOTHING);
  }

  @Override
  protected void execute() {

      if (Robot.driveTrain.getAngle() < RobotMap.RIGHT_ANGLE) {
        Robot.driveTrain.setLeftMotors(Robot.oi.getDrivingPower());
        Robot.driveTrain.setRightMotors(-Robot.oi.getDrivingPower());
      }
      if (Robot.driveTrain.getAngle() > RobotMap.RIGHT_ANGLE) {
        Robot.driveTrain.setLeftMotors(-Robot.oi.getDrivingPower());
        Robot.driveTrain.setLeftMotors(Robot.oi.getDrivingPower());
      }
  }

  @Override
  protected boolean isFinished() {
    if (Robot.driveTrain.getAngle() == RobotMap.RIGHT_ANGLE) {
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
