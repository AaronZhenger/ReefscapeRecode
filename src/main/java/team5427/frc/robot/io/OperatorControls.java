package team5427.frc.robot.io;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import team5427.frc.robot.Constants.DriverConstants;
import team5427.frc.robot.Superstructure;
import team5427.frc.robot.Superstructure.GamePieceMode;
import team5427.frc.robot.Superstructure.ProngStates;
import team5427.frc.robot.commands.ResetSubsystems;
import team5427.frc.robot.commands.cascade.MoveCascadeAll;
import team5427.frc.robot.commands.prong.EjectCoral;
import team5427.frc.robot.commands.prong.MoveProngAll;
import team5427.frc.robot.commands.prong.RollerVelocity;
import team5427.frc.robot.commands.prong.RotateWrist;
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
            new InstantCommand(
                () -> {
                  Superstructure.kSelectedProngState = ProngStates.DISABLED;
                }))
        .toggleOnFalse(
            new InstantCommand(
                () -> {
                  Superstructure.kSelectedProngState = ProngStates.IDLE;
                }));
    joy.x()
        .onTrue(new MoveCascadeAll(CascadeConstants.kL2Distance, CascadeConstants.kL2Rotation))
        .onTrue(new RotateWrist(ProngConstants.kL2Rotation));
    joy.b()
        .onTrue(new MoveCascadeAll(CascadeConstants.kL3Distance, CascadeConstants.kL3Rotation))
        .onTrue(new RotateWrist(ProngConstants.kL3Rotation));
    joy.y()
        .onTrue(new MoveCascadeAll(CascadeConstants.kL4Distance, CascadeConstants.kL4Rotation))
        .onTrue(new RotateWrist(ProngConstants.kL4Rotation));

    joy.leftTrigger()
        .whileTrue(
            new MoveCascadeAll(
                CascadeConstants.kRSCIntakeDistance, CascadeConstants.kIntakeRotation))
        .whileTrue(
            new MoveProngAll(ProngConstants.kCoralIntakeVelocity, ProngConstants.kIntakePosition))
        .onFalse(new ResetSubsystems());
    joy.rightTrigger()
        .whileTrue(new EjectCoral())
        .onFalse(new RollerVelocity(ProngConstants.kStowVelocity));

    joy.povDown().onTrue(new ResetSubsystems());

    joy.povLeft()
        .onTrue(
            new InstantCommand(() -> Superstructure.kSelectedGamePieceMode = GamePieceMode.ALGAE));
    joy.povRight()
        .onTrue(
            new InstantCommand(() -> Superstructure.kSelectedGamePieceMode = GamePieceMode.CORAL));
  }
}
