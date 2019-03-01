package com.bayee.util.iteratorDP;

/*
 * Created by renhongjiang on 2018/12/5.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/5 17:24
 */
class IntegerBox2 {
    private List<Integer> list = new ArrayList<>();

    public class Iterator {
        private IntegerBox2 box2;
        private java.util.Iterator iterator;
        private int value;

        public Iterator(IntegerBox2 box2) {
            this.box2 = box2;
        }

        public void first() {
            iterator = box2.list.iterator();
            next();
        }

        public void next() {
            try {
                value = (Integer) iterator.next();
            } catch (NoSuchElementException e) {
                value = -1;
            }
        }

        public boolean isDone() {
            return value == -1;
        }

        public int currentValue() {
            return value;
        }
    }

    public void add(int i) {
        list.add(i);
    }

    public Iterator getIterator() {
        return new Iterator(this);
    }


}

public class IteratorDemo {
    public static void main(String[] args) {
        IntegerBox2 integerBox = new IntegerBox2();
        for (int i = 9; i > 0; --i) {
            integerBox.add(i);
        }
        // getData() has been removed.
        // Client has to use Iterator.
        IntegerBox2.Iterator firstItr = integerBox.getIterator();
        IntegerBox2.Iterator secondItr = integerBox.getIterator();
        for (firstItr.first(); !firstItr.isDone(); firstItr.next()) {
            System.out.print(firstItr.currentValue() + "  ");
        }
        System.out.println();
        // Two simultaneous iterations
        for (firstItr.first(), secondItr.first(); !firstItr.isDone(); firstItr.next(), secondItr.next()) {
            System.out.print(firstItr.currentValue() + " " + secondItr.currentValue() + "  ");
        }
    }
}