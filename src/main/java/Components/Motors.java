package Components;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.Battery;
import ev3dev.sensors.ev3.EV3IRSensor;
import ev3dev.utils.JarResource;
import ev3dev.utils.Shell;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


import java.util.ArrayList;

enum Directions
{
    FOWARD,BACKWARDS,LEFT,RIGHT,STOP
}

public class Motors {

    Directions direction;
    public void bulkMove(ArrayList<EV3LargeRegulatedMotor> motorstomove, Directions whichway){
        for(EV3LargeRegulatedMotor x :motorstomove) {
            switch (whichway) {
                case FOWARD:
                    x.forward();
                    break;
                case BACKWARDS:
                    x.backward();
                    break;
                case LEFT:
                    //TODO
                    break;
                case RIGHT:
                    //TODO
                    break;
                case STOP:
                    x.brake();
                    break;
                default:
                    System.out.println("damn");
                    break;
            }
        }
    }
}
