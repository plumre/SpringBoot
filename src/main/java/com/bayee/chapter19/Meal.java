package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/18.
 */

import static com.bayee.util.Print.print;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/18 17:13
 */
public class Meal {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            print("---- 菜单"+ (i+1) +" ----");
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                print(food);
            }
            print("----  祝您用餐愉快！  ----");
        }
    }
}