package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/18.
 */

/**
 * TODO  19.7 使用接口组织枚举
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/18 16:45
 */
public interface Food {

    enum Appetizer implements Food {
        /**
         * 沙拉， 汤， 春卷
         */
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food {
        /**
         * 意大利千层面， 墨西哥鸡肉卷， 泰式炒河粉， 小扁豆， 埃及豆泥沾酱， 印度咖喱肉
         */
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
    }

    enum Dessert implements Food {
        /**
         * 提拉米苏，意式冰淇淋，黑森林蛋糕，水果，法式焦糖布丁
         */
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
    }

    enum Coffee implements Food {
        /**
         * 黑咖啡，低卡咖啡，浓咖啡，拿铁，卡布奇诺，茶，药草茶
         */
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}