package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/17.
 */

import static com.bayee.util.Print.print;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/17 16:51
 */
public enum OzWitch {
    // Instances must be defined first, before methods
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            print(witch + ": " + witch.getDescription());
        }
    }
}