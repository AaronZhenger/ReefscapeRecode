package team5427.frc.robot.commands.cascade;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.Command;
import team5427.frc.robot.subsystems.Cascade.CascadeSubsystem;

public class MoveElevator extends Command {
  private CascadeSubsystem cascadeSubsystem;

  private Distance position;

  public MoveElevator(Distance position) {
    cascadeSubsystem = CascadeSubsystem.getInstance();
    addRequirements(cascadeSubsystem);

    this.position = position;
  }

  @Override
  public void initialize() {
    cascadeSubsystem.setCascadeSetpoint(position);
  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    super.execute();
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
