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
 * @date 2018/10/18 17:01
 */
public enum Course {

    /**
     * 开胃菜
     */
    APPETIZER(Appetizer.class),

    /**
     * 主菜
     */
    MAINCOURSE(MainCourse.class),

    /**
     * 甜点
     */
    DESSERT(Dessert.class),

    /**
     * 咖啡
     */
    COFFEE(Coffee.class);

    private Food[] values;

    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }

}