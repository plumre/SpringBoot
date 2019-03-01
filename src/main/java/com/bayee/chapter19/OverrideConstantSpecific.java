package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/19.
 */

import static com.bayee.util.Print.print;
import static com.bayee.util.Print.println;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/19 18:13
 */
public enum OverrideConstantSpecific {

    /**
     * 螺丝，螺帽
     */
    NUT, BOLT,
    WASHER {
        @Override
        void f() {
            println("override method");
        }
    };
    void f() {
        println("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific specific : values()) {
            print(specific + ": ");
            specific.f();
        }
    }
}