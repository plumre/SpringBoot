package com.bayee.chapter20;

/*
 * Created by renhongjiang on 2018/10/26.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/26 16:02
 */
public class Sun {

    public Sun() {
    }



    class Food{
        public Food() {
            super();
        }
    }

    //Lev 2
    class Fruit extends Food{
        public Fruit() {
            super();
        }
    }
    class Meat extends Food{
        public Meat() {
            super();
        }
    }

    //Lev 3
    class Apple extends Fruit{
        public Apple() {
            super();
        }
    }
    class Banana extends Fruit{
        public Banana() {
            super();
        }
    }
    class Pork extends Meat{
        public Pork() {
            super();
        }
    }
    class Beef extends Meat{
        public Beef() {
            super();
        }
    }

    //Lev 4
    class RedApple extends Apple{
        public RedApple() {
            super();
        }
    }
    class GreenApple extends Apple{
        public GreenApple() {
            super();
        }
    }

}