package com.aw.avi.javautils.practice.insteadOfSwitch;

/**
 * Created by avinash.verma on 1/16/2018.
 */

public class SwitchBird {

    public double getSpeed(int type) {
        switch (type) {

            case 1:
                return 10;

            case 2:

                return 20;
            case 3:

                return 5;

        }
        throw new RuntimeException("Should be not reachable");
    }

}
