package MainProgram.Commands;

import Components.Directions;
import Components.Motors;
import Robots.Robot;
import Robots.inputThings;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.Battery;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class HelloRobot {
    private Robot rbt;

    public void init(){
        inputThings[] portInput = new inputThings[]{inputThings.LARGEBOI,inputThings.LARGEBOI};
        rbt = new Robot(portInput);
        rbt.editPorts();
        System.out.println("Init is complete");
    }

    public void mainScript(){
        System.out.println(rbt.whoami());
        System.out.println(rbt.returnMotors(1));
        EV3LargeRegulatedMotor mA = (EV3LargeRegulatedMotor) rbt.returnMotors(0);
        EV3LargeRegulatedMotor mB = (EV3LargeRegulatedMotor) rbt.returnMotors(1);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("Emergency Stop");
                mA.stop();
                mB.stop();
            }
        }));

        System.out.println("Defining the Stop mode");
        mA.brake();
        mB.brake();

        System.out.println("Defining motor speed");
        final int motorSpeed = 200;
        mA.setSpeed(motorSpeed);
        mB.setSpeed(motorSpeed);

        System.out.println("Go Forward with the motors");
        mA.forward();
        mB.forward();

        Delay.msDelay(2000);

        System.out.println("Stop motors");
        mA.stop();
        mB.stop();

        System.out.println("Go Backward with the motors");
        mA.backward();
        mB.backward();

        Delay.msDelay(2000);

        System.out.println("Stop motors");
        mA.stop();
        mB.stop();

        System.out.println("Checking Battery");
        System.out.println("Votage: " + Battery.getInstance().getVoltage());

        System.exit(0);
    }
}
