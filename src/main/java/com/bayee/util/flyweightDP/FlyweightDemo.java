package com.bayee.util.flyweightDP;

/*
 * Created by renhongjiang on 2018/12/4.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/4 18:30
 */
class Gazillion {
    private static int num = 0;
    private int row, col;

    public Gazillion(int maxPerRow) {
        this.row = num / maxPerRow;
        this.col = num % maxPerRow;
        num++;
    }

    void report() {
        System.out.print("  " + row + col);
    }
}



public class FlyweightDemo {

    public static final int ROWS = 6, COLS = 10;

    public static void main(String[] args) {
        Gazillion[][] matrix = new Gazillion[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                matrix[i][j] = new Gazillion(COLS);
            }
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                matrix[i][j].report();
            }
            System.out.println();
        }
    }

}