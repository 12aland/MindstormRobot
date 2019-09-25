package Components;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;


import java.util.ArrayList;

public class Motors {

    Directions direction;
    public void bulkMove(ArrayList<EV3LargeRegulatedMotor> motorstomove, Directions whichway){
        for(EV3LargeRegulatedMotor x :motorstomove) {
            switch (whichway) {
                case FORWARD:
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
