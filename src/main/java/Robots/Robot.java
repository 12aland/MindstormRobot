package Robots;

import ev3dev.actuators.lego.motors.*;
import ev3dev.sensors.BaseSensor;
import ev3dev.sensors.ev3.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;

enum inputThings{
    LARGEBOI,SMALLBOI,ORANGEBOI,COLORBOI,GYROBOI,IRBOI,TOUCHBOI,USBOI
}

public class Robot {

    private static inputThings[] portlist;
    private static BaseRegulatedMotor[] listofmotors;
    private static BaseSensor[] listofsensors;
    public Robot(){

    }

    public Robot(inputThings[] portlist){
        this.portlist = portlist;
    }

    public static void editPorts(){
        Port[] listofoports = new Port[]{MotorPort.A,MotorPort.B,MotorPort.C,MotorPort.D, SensorPort.S1,SensorPort.S2,SensorPort.S3,SensorPort.S4};
        int i = 0;
        for(inputThings x:portlist){
            switch (x){
                case LARGEBOI:
                    listofmotors[i] = new EV3LargeRegulatedMotor(listofoports[i]);
                case SMALLBOI:
                    listofmotors[i] = new EV3MediumRegulatedMotor(listofoports[i]);
                case ORANGEBOI:
                    listofmotors[i] = new NXTRegulatedMotor(listofoports[i]);
                case COLORBOI:
                    listofsensors[i] = new EV3ColorSensor(listofoports[i]);
                case GYROBOI:
                    listofsensors[i] = new EV3GyroSensor(listofoports[i]);
                case IRBOI:
                    listofsensors[i] = new EV3IRSensor(listofoports[i]);
                case TOUCHBOI:
                    listofsensors[i] = new EV3TouchSensor(listofoports[i]);
                case USBOI:
                    listofsensors[i] = new EV3UltrasonicSensor(listofoports[i]);
                default:
                    break;
            }
            i++;
        }
    }
    public String whoami(){
        return "Default Robot";
    }
}
