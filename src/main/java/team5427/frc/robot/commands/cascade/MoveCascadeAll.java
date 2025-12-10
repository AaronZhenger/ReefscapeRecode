package team5427.frc.robot.commands.cascade;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.Command;
import team5427.frc.robot.subsystems.Cascade.CascadeSubsystem;

public class MoveCascadeAll extends Command {
  private CascadeSubsystem cascadeSubsystem;

  private Distance distance;
  private Rotation2d angle;

  public MoveCascadeAll(Distance distance, Rotation2d angle) {
    cascadeSubsystem = CascadeSubsystem.getInstance();
    addRequirements(cascadeSubsystem);

    this.distance = distance;
    this.angle = angle;
  }

  @Override
  public void initialize() {
    cascadeSubsystem.setCascadeSetpoint(distance);
    cascadeSubsystem.setPivotSetpoint(angle);
  }

  @Override
  public boolean isFinished() {
    return cascadeSubsystem.cascadeAtGoal();
  }

  @Override
  public void end(boolean interrupted) {
    // TODO Auto-generated method stub
    super.end(interrupted);
  }
}
