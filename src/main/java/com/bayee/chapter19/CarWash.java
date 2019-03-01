package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/19.
 */

import java.util.EnumSet;

import static com.bayee.util.Print.*;


/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/19 17:12
 */
public class CarWash {

    public enum Cycle {
        UNDERBODY {
            @Override
            void action() {
                println("Spraying the underbody ...");
            }
        },
        WHEELWASH {
            @Override
            void action() {
                println("Wahsing the wheels ...");
            }
        },
        PREWASH {
            @Override
            void action() {
                println("Loosening the dirt ...");
            }
        },
        BASIC {
            @Override
            void action() {
                println("The basic wash ...");
            }
        },
        HOTWAX {
            @Override
            void action() {
                println("Applying hot wax ...");
            }
        },
        RINSE {
            @Override
            void action() {
                println("Rinsing ...");
            }
        },
        BLOWDRY {
            @Override
            void action() {
                println("Blowing dry ...");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    public void washCar() {
        for (Cycle cycle : cycles) {
            cycle.action();
        }
    }

    @Override
    public String toString() {
        return "CarWash{" +
                "cycles=" + cycles +
                '}';
    }

    public static void main(String[] args) {
        CarWash wash = new CarWash();
        println(wash);
        wash.washCar();
        wash.add(Cycle.BLOWDRY);
        // duplicates ignored
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        println(wash);
        wash.washCar();
    }
}