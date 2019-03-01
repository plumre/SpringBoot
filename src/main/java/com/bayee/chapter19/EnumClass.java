package com.bayee.chapter19;

import static com.bayee.util.Print.print;

/*
 * Created by renhongjiang on 2018/10/17.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/17 16:04
 */
public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            print(s + " ordinal: " + s.ordinal());
            print(s.compareTo(Shrubbery.CRAWLING) + " ");
            print(s.equals(Shrubbery.CRAWLING) + " ");
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass());
            print(s.name());
            print("-----------------");
        }

        // Produce an enum value from a string name
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            print(shrub);
            print("** " + shrub.name() + " **");
        }
    }
}

enum Shrubbery { GROUND, CRAWLING, HANGING }