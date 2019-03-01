package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/19.
 */

import java.util.EnumMap;
import java.util.Map;

import static com.bayee.chapter19.AlarmPoints.*;
import static com.bayee.util.Print.*;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/19 16:13
 */

interface Command {
    void action();
}

public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> map = new EnumMap<>(AlarmPoints.class);
        map.put(KITCHEN, new Command() {
            @Override
            public void action() {
                println("Kitchen fire!!!");
            }
        });
        map.put(BATHROOM, new Command() {
            @Override
            public void action() {
                println("Bathroom fire!!!");
            }
        });
        for (Map.Entry<AlarmPoints, Command> entry : map.entrySet()) {
            print(entry.getKey() + ": ");
            entry.getValue().action();
        }
        try {
            map.get(UTILITY).action();
        } catch (Exception e) {
            println(e);
        }
    }
}