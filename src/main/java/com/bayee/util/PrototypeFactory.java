package com.bayee.util;

/*
 * Created by renhongjiang on 2018/11/30.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/11/30 17:37
 */

interface Person {
    Person clone();
}

class Tom implements Person {
    private final String NAME = "Tom";

    @Override
    public Person clone() {
        return new Tom();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Dick implements Person {
    private final String NAME = "Dick";

    @Override
    public Person clone() {
        return new Dick();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Harry implements Person {
    private final String NAME = "Harry";

    @Override
    public Person clone() {
        return new Harry();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Factory {
    private static final Map<String, Person> PROTOTYPES = new HashMap<>();

    static {
        PROTOTYPES.put("tom", new Tom());
        PROTOTYPES.put("dick", new Dick());
        PROTOTYPES.put("harry", new Harry());
    }

    public static Person getPrototype(String type) {
        try {
            return PROTOTYPES.get(type).clone();
        } catch (NullPointerException ex) {
            System.out.println("Prototype with name: " + type + ", doesn't exist");
            return null;
        }
    }
}

public class PrototypeFactory {
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String type : args) {
                Person prototype = Factory.getPrototype(type);
                if (prototype != null) {
                    System.out.println(prototype);
                }
            }
        } else {
            System.out.println("Run again with arguments of command string");
        }
    }
}