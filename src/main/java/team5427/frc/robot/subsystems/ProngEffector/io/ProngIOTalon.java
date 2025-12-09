package team5427.frc.robot.subsystems.ProngEffector.io;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.MetersPerSecondPerSecond;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.ParentDevice;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import team5427.frc.robot.subsystems.ProngEffector.ProngConstants;
import team5427.lib.motors.MagicSteelTalonFX;
import team5427.lib.motors.SteelTalonFX;

public class ProngIOTalon implements ProngIO {
  private MagicSteelTalonFX wrist;
  private SteelTalonFX roller;

  private StatusSignal<Angle> wristPosition;
  private StatusSignal<AngularVelocity> wristVelocity;
  private StatusSignal<AngularAcceleration> wristAcceleration;

  private StatusSignal<Current> wristCurrent;
  private StatusSignal<Voltage> wristVoltage;

  private StatusSignal<AngularVelocity> rollerVelocity;
  private StatusSignal<AngularAcceleration> rollerAcceleration;

  private StatusSignal<Current> rollerCurrent;
  private StatusSignal<Voltage> rollerVoltage;

  private StatusSignal<Temperature> rollerTemperature;

  public ProngIOTalon() {
    wrist = new MagicSteelTalonFX(ProngConstants.kWristServoId);
    wrist.useTorqueCurrentFOC(true);

    wrist.apply(ProngConstants.kWristConfiguration);
    wrist.talonConfig.ClosedLoopGeneral.ContinuousWrap = false;
    wrist.getTalonFX().getConfigurator().apply(wrist.talonConfig);
    
    roller = new SteelTalonFX(ProngConstants.kRollerServoId);
    
    roller.apply(ProngConstants.kRollerConfiguration);

    wristPosition = wrist.getTalonFX().getPosition();
    wristVelocity = wrist.getTalonFX().getVelocity();
    wristAcceleration = wrist.getTalonFX().getAcceleration();

    wristCurrent = wrist.getTalonFX().getStatorCurrent();
    wristVoltage = wrist.getTalonFX().getMotorVoltage();

    rollerVelocity = roller.getTalonFX().getVelocity();
    rollerAcceleration = roller.getTalonFX().getAcceleration();

    rollerCurrent = roller.getTalonFX().getStatorCurrent();
    rollerVoltage = roller.getTalonFX().getMotorVoltage();

    rollerTemperature = roller.getTalonFX().getDeviceTemp();

    BaseStatusSignal.setUpdateFrequencyForAll(
      50, 
      wristPosition,
      wristVelocity,
      wristAcceleration,
      wristCurrent,
      wristVoltage,
      rollerVelocity,
      rollerAcceleration,
      rollerCurrent,
      rollerVoltage
    );

    BaseStatusSignal.setUpdateFrequencyForAll(10, rollerTemperature);

    BaseStatusSignal.waitForAll(
      0.02, 
      wristPosition,
      wristVelocity,
      wristAcceleration,
      wristCurrent,
      wristVoltage,
      rollerVelocity,
      rollerAcceleration,
      rollerCurrent,
      rollerVoltage,
      rollerTemperature
    );

    ParentDevice.optimizeBusUtilizationForAll(wrist.getTalonFX(), roller.getTalonFX());
    wrist.setEncoderPosition(ProngConstants.kZeroPosition);
  }

  @Override
  public void updateInputs(ProngIOInputs inputs) {
    BaseStatusSignal.refreshAll(
      wristPosition,
      wristVelocity,
      wristAcceleration,
      wristCurrent,
      wristVoltage,
      rollerVelocity,
      rollerAcceleration,
      rollerCurrent,
      rollerVoltage,
      rollerTemperature
    );

    inputs.wristPosition = Rotation2d.fromRotations(wristPosition.getValue().in(Rotations));
    inputs.wristVelocity = wristVelocity.getValue();
    inputs.wristAcceleration = wristAcceleration.getValue();

    inputs.wristCurrent = wristCurrent.getValue();
    inputs.wristVoltage = wristVoltage.getValue();

    inputs.rollerVelocity = MetersPerSecond.of(roller.getEncoderVelocity(rollerVelocity));
    inputs.rollerAcceleration =
        MetersPerSecondPerSecond.of(roller.getEncoderAcceleration(rollerAcceleration));

    inputs.rollerCurrent = rollerCurrent.getValue();
    inputs.rollerVoltage = rollerVoltage.getValue();
    inputs.rollerTemperature = rollerTemperature.getValue();
  }

  @Override
  public void setWristSetpoint(Rotation2d setpoint) {
    wrist.setSetpoint(setpoint);
  }

  @Override
  public void setRollerSpeeds(LinearVelocity velocity) {
    roller.setSetpoint(velocity);
  }

  @Override
  public void stopRollers() {
    roller.setSetpoint(MetersPerSecond.of(0.0));
  }

  @Override
  public boolean hasResistance() {
    return rollerCurrent.getValue().magnitude()
        >= ProngConstants.kRollerConfiguration.currentLimit - 1;
  }
}
