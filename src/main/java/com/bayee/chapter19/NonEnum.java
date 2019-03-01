package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/18.
 */

import static com.bayee.util.Print.print;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/18 11:29
 */
public class NonEnum {

    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for (Integer constant : intClass.getEnumConstants()) {
                print(constant);
            }
        } catch (Exception e) {
            print(e);
        }
    }
}