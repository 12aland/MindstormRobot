package Robots;

import ev3dev.actuators.lego.motors.*;
import ev3dev.sensors.BaseSensor;
import ev3dev.sensors.ev3.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;

public class Robot {

    private inputThings[] portlist;
    private BaseRegulatedMotor[] listofmotors = new BaseRegulatedMotor[4];
    private BaseSensor[] listofsensors = new BaseSensor[4];

    public Robot(){
    }

    public Robot(inputThings[] portlist){
        this.portlist = portlist;
    }

    public void editPorts(){
        Port[] listofports = new Port[]{MotorPort.A, MotorPort.B, MotorPort.C, MotorPort.D, SensorPort.S1, SensorPort.S2, SensorPort.S3, SensorPort.S4};
        for(int i=0;i<portlist.length;i++){
            inputThings x= portlist[i];
            switch (x){
                case LARGEBOI:
                    listofmotors[i] = new EV3LargeRegulatedMotor(listofports[i]);
                    break;
                case SMALLBOI:
                    listofmotors[i] = new EV3MediumRegulatedMotor(listofports[i]);
                    break;
                case ORANGEBOI:
                    listofmotors[i] = new NXTRegulatedMotor(listofports[i]);
                    break;
                case COLORBOI:
                    listofsensors[i-4] = new EV3ColorSensor(listofports[i]);
                    break;
                case GYROBOI:
                    listofsensors[i-4] = new EV3GyroSensor(listofports[i]);
                    break;
                case IRBOI:
                    listofsensors[i-4] = new EV3IRSensor(listofports[i]);
                    break;
                case TOUCHBOI:
                    listofsensors[i-4] = new EV3TouchSensor(listofports[i]);
                    break;
                case USBOI:
                    listofsensors[i-4] = new EV3UltrasonicSensor(listofports[i]);
                    break;
                case BLANK:
                    if(i <= 3){
                        listofmotors[i] = null;
                    }
                    else if (i<=7){
                        listofsensors[i-4] = null;
                    }
                    break;
                default:
                    break;
            }
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
