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
interface I {
    void doIt();
}

class B implements I {
    @Override
    public void doIt() {
        System.out.print('B');
    }
}

abstract class D implements I {
    private I core;

    public D(I core) {
        this.core = core;
    }

    @Override
    public void doIt() {
        core.doIt();
    }
}


class X extends D {
    public X(I core) {
        super(core);
    }

    @Override
    public void doIt() {
        super.doIt();
        doX();
    }

    private void doX() {
        System.out.print('X');
    }
}

class Y extends D {
    public Y(I core) {
        super(core);
    }

    @Override
    public void doIt() {
        super.doIt();
        doY();
    }

    private void doY() {
        System.out.print('Y');
    }
}

class Z extends D {
    public Z(I core) {
        super(core);
    }

    @Override
    public void doIt() {
        super.doIt();
        doZ();
    }

    private void doZ() {
        System.out.print('Z');
    }
}

public class DecoratorDemoAfter {
    public static void main(String[] args) {
        I[] array = {new X(new B()), new Y(new X(new B())), new Z(new Y(new X(new B())))};
        for (I a : array) {
            a.doIt();
            System.out.print("   ");
        }
    }
}