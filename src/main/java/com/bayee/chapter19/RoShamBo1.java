package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/22.
 */

import java.util.Random;

import static com.bayee.util.Print.println;


/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/22 17:10
 */
enum Outcome {
    /**
     * 胜出
     */
    WIN,
    /**
     * 失败
     */
    LOSE,
    /**
     * 平手
     */
    DRAW
}

interface Item {
    Outcome compete(Item item);

    Outcome eval(Paper paper);

    Outcome eval(Scissors scissors);

    Outcome eval(Rock rock);
}

class Paper implements Item {
    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Rock rock) {
        return Outcome.LOSE;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}

class Scissors implements Item {
    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Rock rock) {
        return Outcome.WIN;
    }

    @Override
    public String toString() {
        return "Scissors";
    }
}

class Rock implements Item {
    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Rock rock) {
        return Outcome.DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}

public class RoShamBo1 {
    private static final int SIZE = 20;
    private static Random random = new Random(47);

    public static Item newItem() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item item1, Item item2) {
        println(item1 + " vs " + item2 + " : " + item1.compete(item2));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }


}