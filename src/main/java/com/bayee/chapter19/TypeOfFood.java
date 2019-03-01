package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/18.
 */

import com.bayee.chapter19.Food.*;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/18 16:54
 */
public class TypeOfFood {

    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.CAPPUCCINO;
        System.out.println(food);
    }

}