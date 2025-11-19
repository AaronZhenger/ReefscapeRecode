package team5427.frc.robot.subsystems.Cascade;

import static edu.wpi.first.units.Units.Centimeters;
import static edu.wpi.first.units.Units.Feet;
import static edu.wpi.first.units.Units.Inches;
import static edu.wpi.first.units.Units.Meters;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.math.filter.Debouncer.DebounceType;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.units.measure.Distance;
import team5427.lib.drivers.CANDeviceId;
import team5427.lib.drivers.ComplexGearRatio;
import team5427.lib.motors.MotorConfiguration;
import team5427.lib.motors.MotorConfiguration.IdleState;
import team5427.lib.motors.MotorConfiguration.MotorMode;
import team5427.lib.motors.MotorUtil;

public class CascadeConstants {
  public static final CANDeviceId kCascadeMasterId = new CANDeviceId(20);
  public static final CANDeviceId kCascadeSlaveId = new CANDeviceId(21);

  // public static final double kCascadeDriverGravityFF = 0.0;

  public static final Rotation2d kCascadePivotBuffer = Rotation2d.fromDegrees(30);
  public static final Debouncer kCascadePivotDebouncer = new Debouncer(0.25, DebounceType.kBoth);

  public static final Rotation2d kCascadePivotMaximumAngle = Rotation2d.fromDegrees(30);
  public static final Rotation2d kCascadePivotMinimumAngle = Rotation2d.fromDegrees(-30);

  public static final Distance kCascadeMinimumHeight = Meters.of(0.0);
  public static final Distance kCascadeMaximumHeight = Meters.of(2.0);

  public static final MotorConfiguration kCascadeDriverConfiguration = new MotorConfiguration();

  static {
    kCascadeDriverConfiguration.gearRatio = new ComplexGearRatio(12.0 / 72.0);
    kCascadeDriverConfiguration.currentLimit = 60;
    kCascadeDriverConfiguration.idleState = IdleState.kBrake;
    kCascadeDriverConfiguration.mode = MotorMode.kLinear;
    kCascadeDriverConfiguration.isInverted = true;
    kCascadeDriverConfiguration.withFOC = true;

    kCascadeDriverConfiguration.maxVelocity =
        kCascadeDriverConfiguration.getStandardMaxVelocity(MotorUtil.kKrakenX60FOC_MaxRPM) * 0.5;
    kCascadeDriverConfiguration.maxAcceleration = kCascadeDriverConfiguration.maxVelocity * 2;

    kCascadeDriverConfiguration.finalDiameterMeters = Units.inchesToMeters(1.4875);

    kCascadeDriverConfiguration.kP = 0.35;
    // kCascadeDriverConfiguration.kI = .08;
    // kCascadeDriverConfiguration.kG = 0.036;
    kCascadeDriverConfiguration.kD = 0.01;
    // kCascadeDriverConfiguration.kV = 3.0;
    // kCascadeDriverConfiguration.kV = .50;
    // kCascadeDriverConfiguration.kA = 0.05;
    // kCascadeDriverConfiguration.kS = 0.1;
    // kCascadeDriverConfiguration.kFF = 0.0125;

    kCascadeDriverConfiguration.altA = kCascadeDriverConfiguration.maxAcceleration;
    kCascadeDriverConfiguration.altV = kCascadeDriverConfiguration.maxVelocity;
    // kCascadeDriverConfiguration.altJ = 0.0;
  }

  public static final CANDeviceId kPivotMasterId = new CANDeviceId(16, "*");
  public static final CANDeviceId kPivotSlaveId = new CANDeviceId(17, "*");

  public static final MotorConfiguration kPivotConfiguration = new MotorConfiguration();

  static {
    kPivotConfiguration.gearRatio =
        new ComplexGearRatio((1.0 / 5.0), (1.0 / 3.0), (1.0 / 5.0), (32.0 / 48.0), (9.0 / 44.0));
    kPivotConfiguration.currentLimit = 80;
    kPivotConfiguration.idleState = IdleState.kBrake;
    kPivotConfiguration.mode = MotorMode.kServo;
    kPivotConfiguration.isInverted = true;

    kPivotConfiguration.maxVelocity =
        kPivotConfiguration.getStandardMaxVelocity(MotorUtil.kKrakenX60FOC_MaxRPM);
    kPivotConfiguration.maxAcceleration = kPivotConfiguration.maxVelocity * 1.1;

    kPivotConfiguration.kP = 80.0;
    kPivotConfiguration.kD = 0.1;
    // kPivotConfiguration.kV = 22.76;
    // kPivotConfiguration.kA = 0.19;
    // kPivotConfiguration.kS = 0.0;
    // kPivotConfiguration.kG = 3.0;

    kPivotConfiguration.altA = kPivotConfiguration.maxAcceleration;
    kPivotConfiguration.altV = kPivotConfiguration.maxVelocity;
  }

  public static final CANDeviceId kPivotCANcoderId = new CANDeviceId(18, "*");

  public static final CANcoderConfiguration pivotEncoderConfig = new CANcoderConfiguration();

  static {
    pivotEncoderConfig.MagnetSensor.SensorDirection = SensorDirectionValue.Clockwise_Positive;
    pivotEncoderConfig.MagnetSensor.MagnetOffset = CascadeConstants.kPivotCancoderOffset;
    pivotEncoderConfig.MagnetSensor.AbsoluteSensorDiscontinuityPoint = 0.5;
  }

  public static final Distance kCascadeTolerance = Centimeters.of(1.5);
  public static final Distance kCascadeToleranceAutonomous = Centimeters.of(2.0);
  public static final Rotation2d kPivotTolerance = Rotation2d.fromDegrees(0.5);

  public static final double kPivotCancoderOffset = -0.26611328125;

  public static final Distance kStowDistance = Feet.of(0.35);
  public static final Distance kZeroPosition = Feet.of(00);
  public static final Distance kIntakeDistance = Inches.of(0.5);
  public static final Distance kRSCIntakeDistance = Inches.of(1.5);
  public static final Distance kFloorIntakeDistance = Inches.of(0.25);

  public static final Distance kL1Distance = Feet.of(0.25);

  public static final Distance kL2Distance = Meters.of(0.0);

  public static final Distance kL3Distance = Meters.of(0.338);
  public static final Distance kL3DistanceInverse = Feet.of(1.25);
  public static final Distance kL4Distance = Meters.of(1.145); // 1.124 , 1.110 , 1.175
  public static final Distance kL4DistanceInverse = Feet.of(3.8);
  public static final Distance kBargeDistance = Feet.of(3.65);
  public static final Distance kProcessorDistance = Feet.of(0.1);
  // public static final Distance kFloorIntakeDistance = Feet.of(0.2);

  public static final Distance kLowReefAlgaeDistance = Feet.of(0.60);
  public static final Distance kHighReefAlgaeDistance = Feet.of(1.75);

  public static final Rotation2d kStowRotation = Rotation2d.kZero;
  public static final Rotation2d kAlgaeIntakeRotation = Rotation2d.fromDegrees(60.0);
  public static final Rotation2d kTempClimbRotation = Rotation2d.fromDegrees(75.0);
  public static final Rotation2d kClimbPrepRotation = Rotation2d.fromDegrees(-10.0);
  public static final Rotation2d kIntakeRotation = Rotation2d.fromDegrees(6.0);

  public static final Rotation2d kL1Rotation = Rotation2d.fromDegrees(47.0);
  public static final Rotation2d kL2Rotation = Rotation2d.fromDegrees(10.898);
  public static final Rotation2d kL3Rotation = Rotation2d.fromDegrees(6.395);
  public static final Rotation2d kL3RotationInverse = Rotation2d.fromDegrees(0.0);
  public static final Rotation2d kL4Rotation = Rotation2d.fromDegrees(5.0); // 4.3
  public static final Rotation2d kL4RotationInverse = Rotation2d.fromDegrees(0.0);
  public static final Rotation2d kBargeRotation = Rotation2d.fromDegrees(0.0);
  public static final Rotation2d kProcessorRotation = Rotation2d.fromDegrees(50.0);
  public static final Rotation2d kFloorIntakeRotation = Rotation2d.fromDegrees(50.0);

  public static final Rotation2d kCoralFloorIntakeRotationJITB = Rotation2d.fromDegrees(75.0);

  public static final Rotation2d kLowReefAlgaeRotation = Rotation2d.fromDegrees(25.0);
  public static final Rotation2d kHighReefAlgaeRotation = Rotation2d.fromDegrees(20.0);
}
