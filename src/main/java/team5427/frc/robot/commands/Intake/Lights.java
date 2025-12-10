package team5427.frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import team5427.frc.robot.subsystems.Lights.LightsConstants;
import team5427.frc.robot.subsystems.Lights.LightsSubsystem;
import team5427.frc.robot.subsystems.ProngEffector.ProngSubsystem;

public class Lights extends Command {
  private LightsSubsystem lightsSubsystem;
  private ProngSubsystem prongSubsystem;

  private double pattern;

  public Lights() {
    lightsSubsystem = LightsSubsystem.getInstance();
    prongSubsystem = ProngSubsystem.getInstance();
  }

  @Override
  public void initialize() {
    // if (ProngSubsystem.task == EETask.INTAKING) {
    //     if (ProngSubsystem.getGamePieceMode() == GamePieceMode.ALGAE) {
    //         pattern = LightsConstants.kAqua;
    //     } else {
    //         pattern = LightsConstants.kWhite;
    //     }
    // }

    // if (ProngSubsystem.task == EETask.EJECTING) {
    //     if (CascadeSubsystem.getInstance().cascadeAtGoal()) {
    //         pattern = LightsConstants.kCp1BreathFast;
    //     }
    // }

    if (DriverStation.isDisabled()) {
      pattern = LightsConstants.kLightChaseRed;
    }

    lightsSubsystem.setPattern(pattern);
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
