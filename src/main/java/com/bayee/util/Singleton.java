package com.bayee.util;

/*
 * Created by renhongjiang on 2018/12/3.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/3 10:05
 */
public class Singleton {

    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }


}