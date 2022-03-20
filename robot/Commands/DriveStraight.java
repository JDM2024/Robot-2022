package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.RobotMap;

public class DriveStraight extends Command {

  private double rightDrivePower;
  private double leftDrivePower;
  private double initalAngle;

  public DriveStraight() {
    requires(Robot.driveTrain);
  }

  
  @Override
  protected void initialize() {
    Robot.driveTrain.setLeftMotors(RobotMap.NOTHING);
    Robot.driveTrain.setRightMotors(RobotMap.NOTHING);
    initalAngle = Robot.driveTrain.getAngle();
    leftDrivePower = Robot.oi.getDrivingPower();
    rightDrivePower = Robot.oi.getDrivingPower();
  }

  
  @Override
  protected void execute() {
    Robot.driveTrain.setRightMotors(rightDrivePower);
    Robot.driveTrain.setLeftMotors(leftDrivePower);

    if (Robot.driveTrain.getAngle() > initalAngle) {
      rightDrivePower = rightDrivePower + 0.01;
    }
    if (Robot.driveTrain.getAngle() < initalAngle) {
      leftDrivePower = leftDrivePower + 0.01;
    }
  }

  
  @Override
  protected boolean isFinished() {
    return Robot.oi.getIsButtonPressed(RobotMap.CIRCLE_BUTTON);
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
