package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/19.
 */

import java.util.EnumSet;

import static com.bayee.chapter19.AlarmPoints.*;
import static com.bayee.util.Print.print;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/19 16:01
 */
public class EnumSets {

    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        print(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        print(points);
        print("---  ----");
        points = EnumSet.complementOf(points);
        print(points);
    }
}