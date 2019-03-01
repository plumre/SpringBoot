package com.bayee.util.privateDataDP;

/*
 * Created by renhongjiang on 2018/12/5.
 */

import java.awt.*;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/5 10:22
 */
public class Circle {

    private CircleData circleData;

    public Circle(double radius, Color color, Point origin) {
        this.circleData = new CircleData(radius, color, origin);
    }

    public double circumference() {
        return Math.PI * this.circleData.getRadius() * 2;
    }

    public double diameter() {
        return this.circleData.getRadius() * 2;
    }

    public void draw(Graphics graphics) {
        // ...
    }
}