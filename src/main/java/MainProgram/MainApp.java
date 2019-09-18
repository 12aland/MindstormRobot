package MainProgram;

import MainProgram.Commands.HelloRobot;

public class MainApp {
    public static void main(String[] args) {
        HelloRobot pgrm = new HelloRobot();
        pgrm.init();
        pgrm.mainScript();
    }
}
