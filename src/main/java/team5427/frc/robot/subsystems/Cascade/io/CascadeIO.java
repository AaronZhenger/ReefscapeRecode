package team5427.frc.robot.subsystems.Cascade.io;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Celsius;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.MetersPerSecondPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecondPerSecond;
import static edu.wpi.first.units.Units.Volts;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.LinearAcceleration;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;

public interface CascadeIO {
    @AutoLog
    public static class CascadeIOInputs {
        public Distance cascadeMasterDistance = Meters.of(0);
        public LinearVelocity cascadeMasterVelocity = MetersPerSecond.of(0);
        public LinearAcceleration cascadeMasterAcceleration = MetersPerSecondPerSecond.of(0);
        public Voltage cascadeMasterVoltage = Volts.of(0);
        public Current cascadeMasterCurrent = Amps.of(0);
        public Temperature cascadeMasterTemperature = Celsius.of(0);

        public Distance cascadeSlaveDistance = Meters.of(0);
        public LinearVelocity cascadeSlaveVelocity = MetersPerSecond.of(0);
        public LinearAcceleration cascadeSlaveAcceleration = MetersPerSecondPerSecond.of(0);
        public Voltage cascadeSlaveVoltage = Volts.of(0);
        public Current cascadeSlaveCurrent = Amps.of(0);
        public Temperature cascadeSlaveTemperature = Celsius.of(0);
        
        public Rotation2d pivotMasterDistance = new Rotation2d();
        public AngularVelocity pivotMasterVelocity = RadiansPerSecond.of(0);
        public AngularAcceleration pivotMasterAcceleration = RadiansPerSecondPerSecond.of(0);
        public Voltage pivotMasterVoltage = Volts.of(0);
        public Current pivotMasterCurrent = Amps.of(0);
        public Temperature pivotMasterTemperature = Celsius.of(0);

        public Rotation2d pivotSlaveDistance = new Rotation2d();
        public AngularVelocity pivotSlaveVelocity = RadiansPerSecond.of(0);
        public AngularAcceleration pivotSlaveAcceleration = RadiansPerSecondPerSecond.of(0);
        public Voltage pivotSlaveVoltage = Volts.of(0);
        public Current pivotSlaveCurrent = Amps.of(0);
        public Temperature pivotSlaveTemperature = Celsius.of(0);
    }

    public void updateInputs(CascadeIOInputs inputs);

    public void setCascadeSetpoint(Distance setpoint);

    public void setCascadeEncoderPosition(Distance setpoint);
    
    public void setPivotSetpoint(Rotation2d setpoint);
    
    public void setCANCoderPosition(Rotation2d angle);
    
    public void stopCascadeMotors(boolean stopped);
    
    public void stopPivotMotors(boolean stopped);
}
