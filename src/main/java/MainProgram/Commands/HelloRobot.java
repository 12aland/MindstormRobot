package MainProgram.Commands;

import Robots.Robot;

public class HelloRobot {
    private Robot rbt;

    public void init(){
        rbt = new Robot();
    }

    public void mainScript(){
        System.out.println(rbt.whoami());
    }
}
