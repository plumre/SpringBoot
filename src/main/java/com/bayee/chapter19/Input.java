package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/22.
 */

import java.util.Random;

import static com.bayee.util.Print.println;
import static com.bayee.util.Print.print;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/22 16:19
 */
public enum Input {

    NICKLE(5),
    DIME(10),
    QUARTER(25),
    DOLLAR(100),
    TOOTHPASTE(200),
    CHIPS(75),
    SODA(100),
    SOAP(50),
    ABORT_TRANSACTION {
        @Override
        int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        @Override
        int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    int value;

    Input(int value) {
        this.value = value;
    }

    Input() {
    }

    int amount() {
        return value;
    }

    static Random random = new Random(47);

    public static Input randomSelection() {
        return values()[random.nextInt(values().length -1 )];
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Input in = Input.randomSelection();
            print(in);
            try {
                println(": " + in.amount());
            } catch (Exception e) {
                println(": " + e);
            }
        }
    }
}