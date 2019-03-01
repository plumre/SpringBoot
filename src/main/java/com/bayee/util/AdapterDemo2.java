package com.bayee.util;

/*
 * Created by renhongjiang on 2018/12/3.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/3 11:18
 */

interface Shape {
    void draw(int x, int y, int z, int j);
}

class Line2 {
    public void draw(int x1, int y1, int x2, int y2) {
        System.out.println("Line from point A(" + x1 + "," + y1 + "), to point B("
                + x2 + "," + y2 + ")");
    }
}

class Rectangle2 {
    public void draw(int x, int y, int width, int height) {
        System.out.println("Rectangle with coordinate left-down point (" + x + "," + y + "), width: "
                + width + ", height: " + height);
    }
}

class LineAdapter implements Shape {

    private Line2 adaptee;

    public LineAdapter(Line2 line2) {
        this.adaptee = line2;
    }

    @Override
    public void draw(int x, int y, int z, int j) {
        adaptee.draw(x, y, z, j);
    }
}

class RectangleAdapter implements Shape {

    private Rectangle2 adaptee;

    public RectangleAdapter(Rectangle2 rectangle2) {
        this.adaptee = rectangle2;
    }

    @Override
    public void draw(int x, int y, int z, int j) {
        adaptee.draw(Math.min(x, z), Math.min(y, j), Math.abs(x - z), Math.abs(y - j));
    }
}

public class AdapterDemo2 {
    public static void main(String[] args) {
        Shape[] shapes = {new LineAdapter(new Line2()), new RectangleAdapter(new Rectangle2())};
        int x1 = 10, y1 = 20, x2 = 30, y2 = 60;
        for (Shape shape : shapes) {
            shape.draw(x1, y1 ,x2, y2);
        }
    }
}