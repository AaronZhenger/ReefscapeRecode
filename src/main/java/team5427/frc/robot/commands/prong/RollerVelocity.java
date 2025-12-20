package team5427.frc.robot.commands.prong;

import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.wpilibj2.command.Command;
import team5427.frc.robot.subsystems.ProngEffector.ProngSubsystem;

public class RollerVelocity extends Command {
  private ProngSubsystem prongSubsystem;

  private LinearVelocity rollerVelocity;

  public RollerVelocity(LinearVelocity rollerVelocity) {
    prongSubsystem = ProngSubsystem.getInstance();
    addRequirements(prongSubsystem);

    this.rollerVelocity = rollerVelocity;
  }

  @Override
  public void initialize() {
    prongSubsystem.setRollerVelocity(rollerVelocity);
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
