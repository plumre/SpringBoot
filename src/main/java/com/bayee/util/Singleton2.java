package com.bayee.util;

/*
 * Created by renhongjiang on 2018/12/3.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/3 10:18
 */
public class Singleton2 {

    private static volatile Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            // 下面的是什么意思？？
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

}