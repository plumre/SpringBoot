package com.bayee.util.facadeDP;

/*
 * Created by renhongjiang on 2018/12/4.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/4 18:00
 */
class PointCartesian {
    private double x, y;

    public PointCartesian(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString() {
        return "PointCartesian{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

// 2. Subsystem
class PointPolar {
    private double radius, angle;

    public PointPolar(double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public void rotate(int angle) {
        this.angle += angle % 360;
    }

    @Override
    public String toString() {
        return "[" + radius + "@" + angle + "]";
    }
}


// 3. Desired interface : move(), rotate()
class Point {
    // Design a wrapper class
    private PointCartesian pointCartesian;

    public Point(double x, double y) {
        this.pointCartesian = new PointCartesian(x, y);
    }

    @Override
    public String toString() {
        return pointCartesian.toString();
    }

    // Wrapper Maps
    public void move(int x, int y) {
        pointCartesian.move(x, y);
    }

    public void rotate(int angle, Point point) {
        double x = pointCartesian.getX() - point.pointCartesian.getX();
        double y = pointCartesian.getY() - point.pointCartesian.getY();
        PointPolar pointPolar = new PointPolar(Math.sqrt(x * x + y * y), Math.atan2(y, x) * 180 / Math.PI);
        pointPolar.rotate(angle);
        System.out.println("   PointPolar is " + pointPolar);
        String str = pointPolar.toString();
        int i = str.indexOf('@');
        double r = Double.parseDouble(str.substring(1, i));
        double a = Double.parseDouble(str.substring(i + 1, str.length() - 1));
        pointCartesian = new PointCartesian(r * Math.cos(a * Math.PI / 180) + point.pointCartesian.getX(),
                r * Math.sin(a * Math.PI / 180) + point.pointCartesian.getY());
    }
}

class Line {
    private Point ori, end;

    public Line(Point ori, Point end) {
        this.ori = ori;
        this.end = end;
    }

    public void move(int x, int y) {
        ori.move(x, y);
        end.move(x, y);
    }

    public void rotate(int angle) {
        end.rotate(angle, ori);
    }

    @Override
    public String toString() {
        return "Line{" +
                "origin=" + ori +
                ", end=" + end +
                '}';
    }
}


public class FacadeDemo {
    public static void main(String[] args) {
        // 3. Client uses the Facade
        Line lineA = new Line(new Point(2, 4), new Point(5, 7));
        lineA.move(-2, -4);
        System.out.println("after move:  " + lineA);
        lineA.rotate(45);
        System.out.println("after rotate: " + lineA);
        Line lineB = new Line(new Point(2, 1), new Point(2.866, 1.5));
        lineB.rotate(30);
        System.out.println("30 degrees to 60 degrees: " + lineB);
    }
}
