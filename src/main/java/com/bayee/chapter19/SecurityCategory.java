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
 * @date 2018/10/18 17:24
 */
enum SecurityCategory {
    /**
     * 存放
     */
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);
    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        this.values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security { SHORT, LONG, MARGIN }
        enum Bond implements Security { MUNICIPAL, JUNK }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            print(category + ": " + category.randomSelection());
        }
    }
}