package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Timer extends Subsystem {
  
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;
    
    
    public void start() {
      this.startTime = System.currentTimeMillis();
      this.running = true;
    }
    
    
    public void stop() {
      this.stopTime = System.currentTimeMillis();
      this.running = false;
    }
    
    public long getElapsedTime() {
      long elapsed;
      if (running) {
        elapsed = (System.currentTimeMillis() - startTime);
      } else {
        elapsed = (stopTime - startTime);
      }
      return elapsed;
    }


    @Override
    protected void initDefaultCommand() {}
  }
