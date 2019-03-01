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
 * @date 2018/12/5 10:20
 */
public class CircleData {

    private double radius;
    private Color color;
    private Point origin;

    public CircleData(double radius, Color color, Point origin) {
        this.radius = radius;
        this.color = color;
        this.origin = origin;
    }

    public double getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public Point getOrigin() {
        return origin;
    }
}