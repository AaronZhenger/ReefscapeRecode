package team5427.frc.robot.subsystems.ProngEffector.io;

import com.ctre.phoenix6.StatusSignal;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import team5427.lib.motors.MagicSteelTalonFX;
import team5427.lib.motors.SteelTalonFX;

public class ProngIOTalon implements ProngIO {
  private MagicSteelTalonFX wrist;
  private SteelTalonFX roller;

  private StatusSignal<Angle> wristPosition;
  private StatusSignal<AngularAcceleration> wristAcceleration;

  private StatusSignal<Current> wristCurrent;
  private StatusSignal<Voltage> wristVoltage;

  private StatusSignal<Angle> rollerPosition;
  private StatusSignal<AngularVelocity> rollerVelocity;
  private StatusSignal<AngularAcceleration> rollerAcceleration;

  private StatusSignal<Current> rollerCurrent;
  private StatusSignal<Voltage> rollerVoltage;

  private StatusSignal<Temperature> rollerTemperature;

  public ProngIOTalon() {}

  @Override
  public void updateInputs(ProngIOInputs inputs) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateInputs'");
  }

  @Override
  public void setWristSetpoint(Rotation2d setpoint) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setWristSetpoint'");
  }

  @Override
  public void setRollerSpeeds(LinearVelocity velocity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setRollerSpeeds'");
  }

  @Override
  public void stopRollers() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'stopRollers'");
  }

  @Override
  public boolean hasResistance() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'hasResistance'");
  }
}
