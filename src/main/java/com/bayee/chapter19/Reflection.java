package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/17.
 */

import static com.bayee.util.Print.print;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * TODO  19.4 values()的神秘之处
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/17 17:46
 */
enum Explore { HERE, THERE }

public class Reflection {

    public static Set<String> analyze(Class<?> enumClass) {
        print("----- Analyzing " + enumClass + " -----");
        print("Interfaces:");
        for (Type genericInterface : enumClass.getGenericInterfaces()) {
            print(genericInterface);
        }
        print("Base: " + enumClass.getSuperclass());
        print("Methods:");
        Set<String> methods = new TreeSet<String>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        print(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        print("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        print("---------  REMOVE ALL   -----------");
        print(exploreMethods);
        OSExecute.command("javap Explore");
    }
}