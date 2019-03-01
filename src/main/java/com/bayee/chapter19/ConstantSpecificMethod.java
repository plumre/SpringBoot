package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/19.
 */

import java.text.DateFormat;
import java.util.Date;

import static com.bayee.util.Print.println;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/19 16:28
 */
public enum ConstantSpecificMethod {

    /**
     * 日期
     */
    DATE_TIME {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },

    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod method : values()) {
            println(method.getInfo());
        }
    }

}