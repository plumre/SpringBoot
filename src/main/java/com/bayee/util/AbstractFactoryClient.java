package com.bayee.util;

/*
 * Created by renhongjiang on 2018/11/29.
 */

import javax.swing.*;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/11/29 14:49
 */
abstract class CPU {}

class EmberCPU extends CPU {}

class EnginolaCPU extends CPU {}

abstract class MMU {}

class EmberMMU extends MMU {}

class EnginolaMMU extends MMU {}

/**
 * class EmberFactory
 */
class EmberToolkit extends AbstractFactory {

    @Override
    public CPU createCPU() {
        return new EmberCPU();
    }

    @Override
    public MMU createMMU() {
        return new EmberMMU();
    }
}

/**
 * class EnginolaFactory
 */
class EnginolaToolkit extends AbstractFactory {

    @Override
    public CPU createCPU() {
        return new EnginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EnginolaMMU();
    }
}

enum Architecture {
    /**
     * Enginola cpu
     */
    ENGINOLA,
    /**
     * Ember cpu
     */
    EMBER
}

abstract class AbstractFactory {
    private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

    static AbstractFactory getFactory(Architecture architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
                break;
            case EMBER:
                factory = EMBER_TOOLKIT;
                break;
            default:
                break;
        }
        return factory;
    }

    public abstract CPU createCPU();

    public abstract MMU createMMU();
}

public class AbstractFactoryClient {

    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
        CPU emberCPU = factory.createCPU();
        System.out.println(emberCPU);
    }
}