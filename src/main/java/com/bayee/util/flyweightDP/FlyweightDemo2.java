package com.bayee.util.flyweightDP;

/*
 * Created by renhongjiang on 2018/12/4.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/4 18:52
 */
class Gazillion2 {
    private int row;

    public Gazillion2(int row) {
        this.row = row;
    }

    void report(int col) {
        System.out.print("  " + row + col);
    }
}

class Factory {
    private Gazillion2[] pool;

    public Factory(int maxRows) {
        this.pool = new Gazillion2[maxRows];
    }

    public Gazillion2 getFlyweight(int row) {
        if (pool[row] == null) {
            pool[row] = new Gazillion2(row);
        }
        return pool[row];
    }
}

public class FlyweightDemo2 {

    public static final int ROWS = 6, COLS =10;

    public static void main(String[] args) {
        Factory factory = new Factory(ROWS);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                factory.getFlyweight(i).report(j);
            }
            System.out.println();
        }
    }
}