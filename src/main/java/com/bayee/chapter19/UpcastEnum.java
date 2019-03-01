package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/18.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/18 11:01
 */
enum Search { HITER, YON }

public class UpcastEnum {

    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITER;
        // e.values();
        for (Enum constant : e.getClass().getEnumConstants()) {
            System.out.println(constant);
        }
    }
}