package com.bayee.chapter20;

/*
 * Created by renhongjiang on 2018/10/26.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/26 13:41
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {

    int id();

    String description() default "no description";
}