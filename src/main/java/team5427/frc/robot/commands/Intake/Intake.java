package team5427.frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import team5427.frc.robot.RawIntakeConfiguration;
import team5427.frc.robot.subsystems.Cascade.CascadeSubsystem;
import team5427.frc.robot.subsystems.ProngEffector.ProngSubsystem;

public class Intake extends Command {
    private CascadeSubsystem cascade;
    private ProngSubsystem prong;

    private RawIntakeConfiguration config;
    
    public Intake(RawIntakeConfiguration config) {
        cascade = CascadeSubsystem.getInstance();
        prong = ProngSubsystem.getInstance();
        
        this.config = config;

        addRequirements(cascade, prong);
    }

    @Override
    public void initialize() {
        
    }
}
