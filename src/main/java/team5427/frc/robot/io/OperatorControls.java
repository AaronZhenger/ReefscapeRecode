package team5427.frc.robot.io;

import static edu.wpi.first.units.Units.MetersPerSecond;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import team5427.frc.robot.Superstructure;
import team5427.frc.robot.Constants.DriverConstants;
import team5427.frc.robot.Superstructure.GamePieceMode;
import team5427.frc.robot.Superstructure.ProngStates;
import team5427.frc.robot.commands.cascade.MoveCascadeAll;
import team5427.frc.robot.commands.cascade.MoveProngAll;
import team5427.frc.robot.subsystems.Cascade.CascadeConstants;
import team5427.frc.robot.subsystems.ProngEffector.ProngConstants;

public class OperatorControls {
  private CommandXboxController joy;

  public OperatorControls() {
    joy = new CommandXboxController(DriverConstants.kOperatorJoystickPort);
    initalizeTriggers();
  }

  public OperatorControls(CommandXboxController joy) {
    this.joy = joy;
    initalizeTriggers();
  }

  /** Made private to prevent multiple calls to this method */
  private void initalizeTriggers() {
    Superstructure.disabledTrigger
      .toggleOnTrue(
        new InstantCommand(() -> {
          Superstructure.kSelectedProngState = ProngStates.DISABLED;
        })
      )
      .toggleOnFalse(
        new InstantCommand(() -> {
          Superstructure.kSelectedProngState = ProngStates.IDLE;
        })
      );
    joy.x()
        .onTrue(new MoveCascadeAll(CascadeConstants.kL2Distance, CascadeConstants.kL2Rotation))
        .onTrue(new MoveProngAll(MetersPerSecond.of(-0.5), ProngConstants.kL2Rotation));
    joy.b()
        .onTrue(new MoveCascadeAll(CascadeConstants.kL3Distance, CascadeConstants.kL3Rotation))
        .onTrue(new MoveProngAll(MetersPerSecond.of(-0.5), ProngConstants.kL3Rotation));
    joy.y()
        .onTrue(new MoveCascadeAll(CascadeConstants.kL4Distance, CascadeConstants.kL4Rotation))
        .onTrue(new MoveProngAll(MetersPerSecond.of(-0.5), ProngConstants.kL4Rotation));

    joy.leftTrigger()
        .whileTrue(
            new MoveCascadeAll(CascadeConstants.kIntakeDistance, CascadeConstants.kIntakeRotation))
        .whileTrue(
            new MoveProngAll(ProngConstants.kCoralIntakeVelocity, ProngConstants.kIntakePosition));

    joy.povDown()
        .onTrue(new MoveCascadeAll(CascadeConstants.kStowDistance, CascadeConstants.kStowRotation))
        .onTrue(new MoveProngAll(MetersPerSecond.of(-0.5), ProngConstants.kStowPosition));

    joy.povLeft()
        .onTrue(
          new InstantCommand(
            () -> Superstructure.kSelectedGamePieceMode = GamePieceMode.ALGAE
          )
        );
    joy.povRight()
        .onTrue(
          new InstantCommand(
            () -> Superstructure.kSelectedGamePieceMode = GamePieceMode.CORAL
          )
        );
  }
}
