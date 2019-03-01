package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/18.
 */

import com.bayee.util.Generator;
import static com.bayee.util.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/18 14:46
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    /**
     * sla
     */
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    Random random = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg) {
        print(rg.next() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}