package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
    private Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER);
    private int isButtonPressedValue = 0;
    private static SendableChooser<Integer> drivingType = new SendableChooser<>();
    private static SendableChooser<Integer> autonomousCommand = new SendableChooser<>();
    private static SendableChooser<Double> drivingMotorPower = new SendableChooser<>();
    private static SendableChooser<Double> shootingMotorPower = new SendableChooser<>();
    private static SendableChooser<Double> intakeMotorPower = new SendableChooser<>();
    private static SendableChooser<Double> climberMotorPower = new SendableChooser<>();
    private static SendableChooser<Double> engagerMotorPower = new SendableChooser<>();


    public double getDriverRawAxis(int axis) {
        return driverController.getRawAxis(axis);
    }

    public double getDifferenceInTriggers() {
        double triggerDifference = 
        getDriverRawAxis(RobotMap.RIGHT_TRIGGER) - getDriverRawAxis(RobotMap.LEFT_TRIGGER);
        return triggerDifference;
    }

    public int isButtonPressed(int buttonID) {
        if (driverController.getRawButton(buttonID) == true) {
            isButtonPressedValue = 1;
            return isButtonPressedValue;
        }

        else {
            isButtonPressedValue = 0;
            return isButtonPressedValue;
        } 
    }

    public boolean getIsButtonPressed(int buttonID) {
        return driverController.getRawButton(buttonID);
    }

    public double getDifferenceInBumpers() {
        double diffInBumpers = isButtonPressed(RobotMap.RIGHT_BUMPER) 
        - isButtonPressed(RobotMap.LEFT_BUMPER);
        return diffInBumpers;
    }


  public void startGui() {
    SmartDashboard.putData("Driving Type", drivingType);
    drivingType.setDefaultOption("Tank Drive", RobotMap.TANK_DRIVE_DRIVING);
    drivingType.addOption("Video Game Driving", RobotMap.VIDEO_GAME_DRIVING);
    
    SmartDashboard.putData("Autonomous", autonomousCommand);
    autonomousCommand.addOption("Face Right", RobotMap.FACE_RIGHT);
    autonomousCommand.addOption("Face Left", RobotMap.FACE_LEFT);
    autonomousCommand.addOption("Face Back", RobotMap.FACE_BACK);
    autonomousCommand.addOption("Drive Straight", RobotMap.DRIVE_STRAIGHT);
    

    SmartDashboard.putData("Driving Power", drivingMotorPower);
    drivingMotorPower.setDefaultOption("100%", 1.0);
    drivingMotorPower.addOption("90%", 0.9);
    drivingMotorPower.addOption("80%", 0.8);
    drivingMotorPower.addOption("70%", 0.7);
    drivingMotorPower.addOption("60%", 0.6);
    drivingMotorPower.addOption("50%", 0.5);
    drivingMotorPower.addOption("40%", 0.4);
    drivingMotorPower.addOption("30%", 0.3);
    drivingMotorPower.addOption("20%", 0.2);
    drivingMotorPower.addOption("10%", 0.1);
    drivingMotorPower.addOption("Off", 0.0);

    SmartDashboard.putData("Shooting Power", shootingMotorPower);
    shootingMotorPower.setDefaultOption("100%", 1.0);
    shootingMotorPower.addOption("90%", 0.9);
    shootingMotorPower.addOption("80%", 0.8);
    shootingMotorPower.addOption("70%", 0.7);
    shootingMotorPower.addOption("60%", 0.6);
    shootingMotorPower.addOption("50%", 0.5);
    shootingMotorPower.addOption("40%", 0.4);
    shootingMotorPower.addOption("30%", 0.3);
    shootingMotorPower.addOption("20%", 0.2);
    shootingMotorPower.addOption("10%", 0.1);
    shootingMotorPower.addOption("Off", 0.0);
    shootingMotorPower.addOption("Backwards", -0.5);

    SmartDashboard.putData("Intake Power", intakeMotorPower);
    intakeMotorPower.setDefaultOption("100%", 1.0);
    intakeMotorPower.addOption("90%", 0.9);
    intakeMotorPower.addOption("80%", 0.8);
    intakeMotorPower.addOption("70%", 0.7);
    intakeMotorPower.addOption("60%", 0.6);
    intakeMotorPower.addOption("50%", 0.5);
    intakeMotorPower.addOption("40%", 0.4);
    intakeMotorPower.addOption("30%", 0.3);
    intakeMotorPower.addOption("20%", 0.2);
    intakeMotorPower.addOption("10%", 0.1);
    intakeMotorPower.addOption("Off", 0.0);
    
    SmartDashboard.putData("Conveyor Power", climberMotorPower);
    climberMotorPower.setDefaultOption("100%", 1.0);
    climberMotorPower.addOption("90%", 0.9);
    climberMotorPower.addOption("80%", 0.8);
    climberMotorPower.addOption("70%", 0.7);
    climberMotorPower.addOption("60%", 0.6);
    climberMotorPower.addOption("50%", 0.5);
    climberMotorPower.addOption("40%", 0.4);
    climberMotorPower.addOption("30%", 0.3);
    climberMotorPower.addOption("20%", 0.2);
    climberMotorPower.addOption("10%", 0.1);
    climberMotorPower.addOption("Off", 0.0);

    SmartDashboard.putData("Lift Power", engagerMotorPower);
    engagerMotorPower.setDefaultOption("100%", 1.0);
    engagerMotorPower.addOption("90%", 0.9);
    engagerMotorPower.addOption("80%", 0.8);
    engagerMotorPower.addOption("70%", 0.7);
    engagerMotorPower.addOption("60%", 0.6);
    engagerMotorPower.addOption("50%", 0.5);
    engagerMotorPower.addOption("40%", 0.4);
    engagerMotorPower.addOption("30%", 0.3);
    engagerMotorPower.addOption("20%", 0.2);
    engagerMotorPower.addOption("10%", 0.1);
    engagerMotorPower.addOption("Off", 0.0);
  }
  
  public double getDrivingPower() {
    return drivingMotorPower.getSelected();
  }

  public double getIntakePower() {
    return intakeMotorPower.getSelected();
  }

  public double getShootingPower() {
    return shootingMotorPower.getSelected();
  }

  public double getEngagerPower() {
    return engagerMotorPower.getSelected();
  }

  public int getDrivingType() {
    return drivingType.getSelected();
  }

  public double getClimbingPower() {
    return climberMotorPower.getSelected();
  }

  public int getAutonomousCommand() {

    if (autonomousCommand.getSelected() == null) {
        return 0;
    } else { return autonomousCommand.getSelected(); }
  }
  
  public String sayCurrentCommand() {
    switch (getDrivingType()) {
      case RobotMap.TANK_DRIVE_DRIVING:
        return "Tank Driving";
      case RobotMap.VIDEO_GAME_DRIVING:
        return "Video Game Driving";
      default:
        return "Nothing";
    }
  }
  
  public void showClimberPower(double current) {
    SmartDashboard.putNumber("climb_power", current);
  }

  public String sayCurrentAutonomousCommand() {
    switch (getAutonomousCommand()) {
      case RobotMap.FACE_LEFT:
        return "Facing Left";
      case RobotMap.FACE_RIGHT:
        return "Facing Right";
      case RobotMap.FACE_BACK:
        return "Facing Back";
      case RobotMap.DRIVE_STRAIGHT:
        return "Driving Straight";
      default:
        return "Nothing";
    }
  }
}
