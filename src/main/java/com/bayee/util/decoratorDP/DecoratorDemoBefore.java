package com.bayee.util.decoratorDP;

/*
 * Created by renhongjiang on 2018/12/4.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/4 17:30
 */
class A {
    public void doIt() {
        System.out.print('A');
    }
}

class AwithX extends A {
    @Override
    public void doIt() {
        super.doIt();
        doX();
    }

    private void doX() {
        System.out.print('X');
    }
}

class AwithY extends A {
    @Override
    public void doIt() {
        super.doIt();
        doY();
    }

    public void doY() {
        System.out.print('Y');
    }
}

class AwithZ extends A {
    @Override
    public void doIt() {
        super.doIt();
        doZ();
    }

    public void doZ() {
        System.out.print('Z');
    }
}

class AwithXY extends AwithX {
    private AwithY awithY = new AwithY();

    @Override
    public void doIt() {
        super.doIt();
        awithY.doY();
    }
}

class AwithXYZ extends AwithX {
    private AwithY awithY = new AwithY();
    private AwithZ awithZ = new AwithZ();

    @Override
    public void doIt() {
        super.doIt();
        awithY.doY();
        awithZ.doZ();
    }
}

public class DecoratorDemoBefore {
    public static void main(String[] args) {
        A[] array = {new AwithX(), new AwithXY(), new AwithXYZ()};
        for (A a : array) {
            a.doIt();
            System.out.print("   ");
        }
    }
}