package team5427.frc.robot.subsystems.Cascade.io;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.MetersPerSecondPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecondPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static edu.wpi.first.units.Units.Volts;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.LinearAcceleration;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Voltage;
import org.littletonrobotics.junction.AutoLog;

public interface CascadeIO {
  @AutoLog
  public static class CascadeIOInputs {
    public Distance cascadeHeight = Meters.of(0);
    public LinearVelocity cascadeLinearVelocity = MetersPerSecond.of(0);
    public AngularVelocity cascadeAngularVelocity = RotationsPerSecond.of(0);
    public LinearAcceleration cascadeLinearAcceleration = MetersPerSecondPerSecond.of(0);
    
    public Voltage cascadeMasterMotorVoltage = Volts.of(0);
    public Current cascadeMasterMotorCurrent = Amps.of(0);

    public Voltage cascadeSlaveMotorVoltage = Volts.of(0);
    public Current cascadeSlaveMotorCurrent = Amps.of(0);

    public Rotation2d pivotAngle = new Rotation2d();
    public AngularVelocity pivotVelocity = RadiansPerSecond.of(0);
    public AngularAcceleration pivotAcceleration = RadiansPerSecondPerSecond.of(0);
    public Rotation2d pivotAbsoluteAngle = new Rotation2d();

    public Voltage pivotMasterMotorVoltage = Volts.of(0);
    public Current pivotMasterMotorCurrent = Amps.of(0);

    public Voltage pivotSlaveMotorVoltage = Volts.of(0);
    public Current pivotSlaveMotorCurrent = Amps.of(0);
  }

  public void updateInputs(CascadeIOInputs inputs);

  public void setCascadeSetpoint(Distance setpoint);

  public void setCascadeEncoderPosition(Distance setpoint);

  public void setPivotSetpoint(Rotation2d setpoint);

  public void setCANCoderPosition(Rotation2d angle);

  public void stopCascadeMotors(boolean stopped);

  public void stopPivotMotors(boolean stopped);
}
