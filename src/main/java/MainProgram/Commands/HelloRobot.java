package MainProgram.Commands;

import Robots.Robot;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class HelloRobot {
    private Robot rbt;

    public void init(){
        rbt = new Robot();
    }

    public void mainScript(){
        System.out.println(rbt.whoami());
        EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
    }
}
