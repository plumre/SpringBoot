package com.bayee;

/*
 * Created by renhongjiang on 2018/10/19.
 */

import com.bayee.chapter19.OSExecute;

import static com.bayee.util.Print.println;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/19 16:58
 */

enum LikeClasses {

    /**
     *
     */
    WINKEN {
        @Override
        void behavior() {
            println("Behavior 1");
        }
    },
    BLINKEN {
        @Override
        void behavior() {
            println("Behavior 2");
        }
    },
    NOD {
        @Override
        void behavior() {
            println("Behavior 3");
        }
    };

    abstract void behavior();
}

public class NotClasses {
    // void f1(LikeClasses.WINKEN instance) {} // Nope
    public static void main(String[] args) {
        OSExecute.command("javap -c LikeClasses");
    }

}