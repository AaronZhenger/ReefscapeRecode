package team5427.frc.robot.commands.prong;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import team5427.frc.robot.subsystems.ProngEffector.ProngSubsystem;

public class RotateWrist extends Command {
  private ProngSubsystem prongSubsystem;

  private Rotation2d wristSetpoint;

  public RotateWrist(Rotation2d wristSetpoint) {
    prongSubsystem = ProngSubsystem.getInstance();
    addRequirements(prongSubsystem);
    this.wristSetpoint = wristSetpoint;
  }

  @Override
  public void initialize() {
    prongSubsystem.setWristSetpoint(wristSetpoint);
  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    super.execute();
  }

  @Override
  public boolean isFinished() {
    // TODO Auto-generated method stub
    return super.isFinished();
  }

  @Override
  public void end(boolean interrupted) {
    // TODO Auto-generated method stub
    super.end(interrupted);
  }
}
