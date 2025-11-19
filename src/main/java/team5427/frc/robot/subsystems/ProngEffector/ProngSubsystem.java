package team5427.frc.robot.subsystems.ProngEffector;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import lombok.Getter;
import lombok.Setter;
import team5427.frc.robot.subsystems.ProngEffector.io.ProngIO;
import team5427.frc.robot.subsystems.ProngEffector.io.ProngIOInputsAutoLogged;

public class ProngSubsystem extends SubsystemBase {
  public static enum GamePieceMode {
    CORAL,
    ALGAE
  }

  @Getter @Setter private static GamePieceMode gamePieceMode = GamePieceMode.CORAL;

  private ProngIO io;
  private ProngIOInputsAutoLogged inputsAutoLogged = new ProngIOInputsAutoLogged();

  public static ProngSubsystem m_instance;

  public static ProngSubsystem getInstance() {
    if (m_instance == null) m_instance = new ProngSubsystem();
    return m_instance;
  }

  public ProngSubsystem() {}
}
