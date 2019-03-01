package com.bayee.util;

/*
 * Created by renhongjiang on 2018/12/3.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/3 10:41
 */

class Line {

    public void draw(int x1, int y1, int x2, int y2) {
        System.out.println("Line from point A(" + x1 + "," + y1 + "), to point B("
                + x2 + "," + y2 + ")");
    }
}

class Rectangle {

    public void draw(int x, int y, int width, int height) {
        System.out.println("Rectangle with coordinate left-down point (" + x + "," + y + "), width: "
                + width + ", height: " + height);
    }
}

public class AdapterDemo {

    public static void main(String[] args) {
        Object[] shapes = {new Line(), new Rectangle()};
        int x1 = 10, y1 = 20, x2 = 30, y2 = 60, width = 40, height = 40;
        for (Object shape : shapes) {
            if ("Line".equals(shape.getClass().getSimpleName())) {
                ((Line)shape).draw(x1, y1, x2, y2);
            } else if ("Rectangle".equals(shape.getClass().getSimpleName())) {
                ((Rectangle)shape).draw(x2, y2, width, height);
            }
        }

    }

}