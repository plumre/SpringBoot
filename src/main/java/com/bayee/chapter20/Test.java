package com.bayee.chapter20;

/*
 * Created by renhongjiang on 2018/10/26.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/26 16:03
 */
public class Test {


    public void testA() {

        // PECS 原则
        // 生产者：频繁往外读取内容的，适合用上界Extends。
        // 消费者：经常往里插入的，适合用下界Super。

        // 上界
        Plate<? extends Fruit> plate = new Plate<>(new Apple());
        Fruit f = plate.getItem();
        Object o = plate.getItem();

        // 下界
        Plate<? super Fruit> plate1 = new Plate<>(new Fruit());
        plate1.setItem(new Apple());
        plate1.setItem(new Fruit());
    }


    class Food {
        public Food() {
            super();
        }
    }

    //Lev 2
    class Fruit extends Food {
        public Fruit() {
            super();
        }
    }

    class Meat extends Food {
        public Meat() {
            super();
        }
    }

    //Lev 3
    class Apple extends Fruit {
        public Apple() {
            super();
        }
    }

    class Banana extends Fruit {
        public Banana() {
            super();
        }
    }

    class Pork extends Meat {
        public Pork() {
            super();
        }
    }

    class Beef extends Meat {
        public Beef() {
            super();
        }
    }

    //Lev 4
    class RedApple extends Apple {
        public RedApple() {
            super();
        }
    }

    class GreenApple extends Apple {
        public GreenApple() {
            super();
        }
    }
}