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
 * @date 2018/12/5 10:16
 */
public class BeforeCircle {

    private double radius;
    private Color color;
    private Point origin;

    public BeforeCircle(double radius, Color color, Point origin) {
        this.radius = radius;
        this.color = color;
        this.origin = origin;
    }

    public double circumference() {
        return Math.PI * this.radius * 2;
    }

    public double diameter() {
        return this.radius * 2;
    }

    public void draw(Graphics graphics) {
        // ...
    }
}