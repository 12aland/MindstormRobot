package Robots;

import ev3dev.actuators.lego.motors.*;
import ev3dev.sensors.BaseSensor;
import ev3dev.sensors.ev3.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;

import Robots.inputThings;

public class Robot {

    private static inputThings[] portlist;
    private static BaseRegulatedMotor[] listofmotors;
    private static BaseSensor[] listofsensors;
    private static Port[] listofports;

    public Robot(){
    }

    public Robot(inputThings[] portlist){
        this.portlist = portlist;
    }

    public static void editPorts(){
        listofports = new Port[]{MotorPort.A,MotorPort.B,MotorPort.C,MotorPort.D, SensorPort.S1,SensorPort.S2,SensorPort.S3,SensorPort.S4};
        int i = 0;
        for(inputThings x:portlist){
            switch (x){
                case LARGEBOI:
                    listofmotors[i] = new EV3LargeRegulatedMotor(listofports[i]);
                case SMALLBOI:
                    listofmotors[i] = new EV3MediumRegulatedMotor(listofports[i]);
                case ORANGEBOI:
                    listofmotors[i] = new NXTRegulatedMotor(listofports[i]);
                case COLORBOI:
                    listofsensors[i] = new EV3ColorSensor(listofports[i]);
                case GYROBOI:
                    listofsensors[i] = new EV3GyroSensor(listofports[i]);
                case IRBOI:
                    listofsensors[i] = new EV3IRSensor(listofports[i]);
                case TOUCHBOI:
                    listofsensors[i] = new EV3TouchSensor(listofports[i]);
                case USBOI:
                    listofsensors[i] = new EV3UltrasonicSensor(listofports[i]);
                default:
                    break;
            }
            i++;
        }
    }
    public String whoami(){
        return "Default Robot";
    }
    public BaseRegulatedMotor[] returnMotors(){
        return listofmotors;
    }
    public BaseRegulatedMotor returnMotors(int i){
        return listofmotors[i];
    }
}
