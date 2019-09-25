package MainProgram.Commands;

import Components.Directions;
import Components.Motors;
import Robots.Robot;
import Robots.inputThings;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class HelloRobot {
    private Robot rbt;

    public void init(){
        inputThings portInput[] = new inputThings[]{inputThings.LARGEBOI,inputThings.LARGEBOI};
        rbt = new Robot(portInput);
    }

    public void mainScript(){
        System.out.println(rbt.whoami());
        EV3LargeRegulatedMotor mA = (EV3LargeRegulatedMotor) rbt.returnMotors(0);
        EV3LargeRegulatedMotor mB = (EV3LargeRegulatedMotor) rbt.returnMotors(0);
    }
}
