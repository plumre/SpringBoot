package com.bayee.util.commandDP;

/*
 * Created by renhongjiang on 2018/12/5.
 */

import com.bayee.chapter19.Input;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/5 16:12
 */
class SimpleCommand {
    private int state;

    public SimpleCommand(int state) {
        this.state = state;
    }

    public void add(Integer value) {
        state += value;
    }

    public void addTwoOperands(Integer firstV, Integer secondV) {
        state = state + firstV + secondV;
    }

    public int getState() {
        return state;
    }
}

class ReflectCommand {
    // the encapsulated object
    private Object receiver;
    // the pre-registered request
    private Method action;
    // the pre-registered request
    private Object[] args;

    public ReflectCommand(Object receiver, String methodName, Object[] args) {
        this.receiver = receiver;
        this.args = args;
        Class clazz = receiver.getClass();
        Class[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        try {
            action = clazz.getMethod(methodName, argTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public Object execute() {
        try {
            action.invoke(receiver, args);
            return receiver.getClass().getMethod("getState").invoke(receiver);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class CommandDemo {
    public static void main(String[] args) {
        SimpleCommand[] simpleCommands = {new SimpleCommand(1), new SimpleCommand(2)};
        System.out.print("Normal call results: ");
        simpleCommands[0].add(3);
        System.out.print(simpleCommands[0].getState() + " ");
        simpleCommands[1].addTwoOperands(4, 5);
        System.out.print(simpleCommands[1].getState());

        ReflectCommand[] reflectCommands = {
                new ReflectCommand(simpleCommands[0], "add", new Integer[] {3}),
                new ReflectCommand(simpleCommands[1], "addTwoOperands", new Integer[] {4, 5})
        };
        System.out.print("\nReflection results:  ");
        for (ReflectCommand command : reflectCommands) {
            System.out.print(command.execute() + " ");
        }
        System.out.println();
    }
}