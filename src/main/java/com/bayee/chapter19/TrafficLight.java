package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/17.
 */

import static com.bayee.util.Print.print;

/**
 * TODO  19.3 switch交通信号灯控制
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/17 17:24
 */

enum Signal {
    GREEN, YELLOW, RED
}

public class TrafficLight {

    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }



    @Override
    public String toString() {
        return "TrafficLight{" +
                "color=" + color +
                '}';
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        for (int i = 0; i < 3; i++) {
            print(light);
            light.change();
        }
    }

    /*
    如果case语句有返回类型，则必须有default语句
    public String change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                return "绿灯";
            case GREEN:
                color = Signal.YELLOW;
                return "黄灯";
            case YELLOW:
                color = Signal.RED;
                return "红灯";
            default:
                return "没电了..";
        }
    }*/
}