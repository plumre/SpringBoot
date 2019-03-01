package com.bayee.util;

/*
 * Created by renhongjiang on 2018/12/3.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/3 11:43
 */
// OLD
class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

// The new
class RoundHole {

    private final int radius;

    public RoundHole(int radius) {
        this.radius = radius;
        System.out.println("RoundHole: max SquarePeg is " + radius * Math.sqrt(2));
    }

    public int getRadius() {
        return radius;
    }
}

// Design a wrapper class that can impedance match the old to the new
class SquarePegAdapter {

    // the adapter/wrapper class has a instance of the legacy class
    private final SquarePeg squarePeg;

    public SquarePegAdapter(double w) {
        this.squarePeg = new SquarePeg(w);
    }

    // identify the desired interface
    public void makeFit(RoundHole roundHole) {
        double amount = squarePeg.getWidth() - roundHole.getRadius() * Math.sqrt(2);
        System.out.println("reducing SquarePeg " + squarePeg.getWidth() + " by " + (amount < 0 ? 0 : amount) + " amount");
        if (amount > 0) {
            squarePeg.setWidth(squarePeg.getWidth() - amount);
            System.out.println(" width is now " + squarePeg.getWidth());
        }
    }
}

public class AdapterDemoSquarePeg {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(5);
        SquarePegAdapter squarePegAdapter;
        for (int i = 6; i < 10; i++) {
            squarePegAdapter = new SquarePegAdapter((double)i);
            // The client uses (is coupled to) the new interface
            squarePegAdapter.makeFit(roundHole);
        }
    }
}