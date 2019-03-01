package com.bayee.chapter20;

/*
 * Created by renhongjiang on 2018/10/26.
 */

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.bayee.util.Print.println;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/26 11:45
 */
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method declaredMethod : cl.getDeclaredMethods()) {
            UseCase uc = declaredMethod.getAnnotation(UseCase.class);
            if (uc != null) {
                println("Found Use Case:" + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (Integer useCase : useCases) {
            println("Warning: Missing the case-" + useCase);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}