package team5427.frc.robot.subsystems.ProngEffector;

import static edu.wpi.first.units.Units.MetersPerSecond;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.units.measure.LinearVelocity;
import team5427.lib.drivers.CANDeviceId;
import team5427.lib.drivers.ComplexGearRatio;
import team5427.lib.motors.MotorConfiguration;
import team5427.lib.motors.MotorConfiguration.IdleState;
import team5427.lib.motors.MotorConfiguration.MotorMode;
import team5427.lib.motors.MotorUtil;

public class ProngConstants {
  public static final CANDeviceId kWristServoId = new CANDeviceId(24); // 24
  public static final CANDeviceId kRollerServoId = new CANDeviceId(23); // 23

  public static final MotorConfiguration kWristConfiguration = new MotorConfiguration();

  static {
    kWristConfiguration.gearRatio =
        new ComplexGearRatio((14.0 / 70.0), (18.0 / 72.0), (17.0 / 32.0));
    kWristConfiguration.idleState = IdleState.kBrake;
    kWristConfiguration.isInverted = false;
    kWristConfiguration.mode = MotorMode.kServo;
    kWristConfiguration.withFOC = true;

    kWristConfiguration.maxVelocity =
        kWristConfiguration.getStandardMaxVelocity(MotorUtil.kKrakenX60FOC_MaxRPM);
    kWristConfiguration.maxAcceleration = kWristConfiguration.maxVelocity;

    kWristConfiguration.kP = 3.0; // 5.0, 4.5
    kWristConfiguration.kD = 0.2;

    kWristConfiguration.altA = kWristConfiguration.maxAcceleration;
    kWristConfiguration.altV = kWristConfiguration.maxVelocity;
  }

  public static final MotorConfiguration kRollerConfiguration = new MotorConfiguration();

  static {
    kRollerConfiguration.gearRatio = new ComplexGearRatio(24.0 / 36.0);
    kRollerConfiguration.idleState = IdleState.kCoast;
    kRollerConfiguration.isInverted = true;
    kRollerConfiguration.mode = MotorMode.kFlywheel;
    kRollerConfiguration.withFOC = true;
    kRollerConfiguration.finalDiameterMeters = Units.inchesToMeters(4.0);
    kRollerConfiguration.currentLimit = 60;

    kRollerConfiguration.maxVelocity =
        kRollerConfiguration.getStandardMaxVelocity(MotorUtil.kKrakenX60FOC_MaxRPM);
    kRollerConfiguration.maxAcceleration = kRollerConfiguration.maxVelocity;

    kRollerConfiguration.kP = .1;
    kRollerConfiguration.kV = .5;
  }

  public static final Rotation2d kStowPosition = Rotation2d.fromDegrees(10);
  public static final Rotation2d kAlgaeStowPosition = Rotation2d.fromDegrees(25.0);
  public static final Rotation2d kZeroPosition = Rotation2d.fromDegrees(-45.0);
  public static final Rotation2d kIntakePosition = Rotation2d.fromDegrees(157.0); // 200.0
  public static final Rotation2d kFloorIntakePosition = Rotation2d.fromDegrees(15.0);

  public static final Rotation2d kClimbRotation = Rotation2d.fromDegrees(5.0);

  public static final Rotation2d kL1Rotation = Rotation2d.fromDegrees(42.0);
  public static final Rotation2d kL2Rotation = Rotation2d.fromDegrees(-10.0);
  public static final Rotation2d kL3Rotation = Rotation2d.fromDegrees(-10.132);
  public static final Rotation2d kL3RotationInverse = Rotation2d.fromDegrees(200.0);
  public static final Rotation2d kL4Rotation = Rotation2d.fromDegrees(-35.5); // 32.5
  public static final Rotation2d kL4RotationInverse = Rotation2d.fromDegrees(280.0);
  public static final Rotation2d kBargePosition = Rotation2d.fromDegrees(92.5);
  public static final Rotation2d kProcessorPosition = Rotation2d.fromDegrees(85.0);

  public static final Rotation2d kLowReefAlgaeRotation = Rotation2d.fromDegrees(45.0);
  public static final Rotation2d kHighReefAlgaeRotation = Rotation2d.fromDegrees(40.0);

  public static final LinearVelocity kAlgaeFloorIntakeVelocity = MetersPerSecond.of(4.0);
  public static final LinearVelocity kAlgaeReefIntakeVelocity = MetersPerSecond.of(4.0);

  public static final LinearVelocity kCoralIntakeVelocity = MetersPerSecond.of(-4.0);

  public static final LinearVelocity kAlgaeProcesserVelocity = MetersPerSecond.of(2.0);
  public static final LinearVelocity kAlgaeBargeVelocity = MetersPerSecond.of(2.0);

  public static final LinearVelocity kCoralScoringVelocity = MetersPerSecond.of(1.0);

  public static final LinearVelocity kStowVelocity = MetersPerSecond.of(-0.5);
}
