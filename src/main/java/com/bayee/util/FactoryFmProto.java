package com.bayee.util;

/*
 * Created by renhongjiang on 2018/11/29.
 */

import com.github.jaiimageio.plugins.tiff.EXIFGPSTagSet;
import com.google.zxing.client.result.ExpandedProductResultParser;

import java.util.Scanner;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/11/29 15:48
 */
class Expression implements Cloneable {
    public String str;

    public Expression(String str) {
        this.str = str;
    }

    @Override
    public Expression clone() {
        Expression clone = null;
        try {
            clone = (Expression) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return str;
    }
}

abstract class AbstractFactory2 {
    public Expression prototype;

    public Expression makePhase() {
        return prototype.clone();
    }

    public abstract Expression makeCompromise();

    public abstract Expression makeGrade();
}

class PCFactory extends AbstractFactory2 {

    public PCFactory() {
        prototype = new PCPhase();
    }

    @Override
    public Expression makeCompromise() {
        return new Expression("\"do it your way, any way, or no way\"");
    }

    @Override
    public Expression makeGrade() {
        return new Expression("\"you pass, self-essteem intact\"");
    }
}

class PCPhase extends Expression {
    private static int next = 0;
    private static final String[] list = {"\"animal companion\"", "\"vertically challenged\"",
            "\"factually inaccurate\"", "\"chronologically gifted\""};

    public PCPhase() {
        super(list[next]);
        next = (next + 1) % list.length;
    }

    @Override
    public Expression clone() {
        return new PCPhase();
    }
}

class NotPCPhase extends Expression {
    private static int next = 0;
    private static final String[] list = {"\"pet\"", "\"short\"", "\"lie\"", "\"old\""};

    public NotPCPhase() {
        super(list[next]);
        next = (next + 1) % list.length;
    }

    @Override
    public Expression clone() {
        return new NotPCPhase();
    }
}

class NotPCFactory extends AbstractFactory2 {

    public NotPCFactory() {
        prototype = new NotPCPhase();
    }

    @Override
    public Expression makeCompromise() {
        return new Expression("\"my way, or the high way\"");
    }

    @Override
    public Expression makeGrade() {
        return new Expression("\"take test, deal with the results\"");
    }
}


public class FactoryFmProto {
    public static void main(String[] args) {
        AbstractFactory2 factory2;
        if (args.length > 0) {
            factory2 = new PCFactory();
        } else {
            factory2 = new NotPCFactory();
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(factory2.makePhase() + " ");
        }
        System.out.println();
        System.out.println(factory2.makeCompromise());
        System.out.println(factory2.makeGrade());
    }
}