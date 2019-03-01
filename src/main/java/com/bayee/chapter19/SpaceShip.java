package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/17.
 */

import static com.bayee.util.Print.print;

/**
 * TODO  太空飞船枚举
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/17 17:07
 */
public enum SpaceShip {
    /**
     * sct
     */
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip ship : values()) {
            print(ship);
        }
    }
}