package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/18.
 */

import java.util.Random;

import static com.bayee.util.Print.print;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/18 15:54
 */
public class Enums {

    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            print(Enums.random(Spiciness.class));
        }
        System.out.println("-----   -----");
        for (int i = 0; i < 3; i++) {
            print(Enums.random(Spiciness.values()));
        }
    }
}