package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/17.
 */

import static com.bayee.chapter19.Spiciness.*;
import static com.bayee.util.Print.print;

/**
 * TODO  19.1.1 静态导入用于enum
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/17 16:37
 */
public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito{" +
                "degree=" + degree +
                '}';
    }

    public static void main(String[] args) {
        print(new Burrito(NOT));
        print(new Burrito(MEDIUM));
        print(new Burrito(HOT));
    }
}