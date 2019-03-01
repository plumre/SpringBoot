package com.bayee.chapter18;

/*
 * Created by renhongjiang on 2018/10/17.
 */

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import static com.bayee.util.Print.print;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/17 14:32
 */
public class PreferenceDemo {

    public static void main(String[] args) throws BackingStoreException {
        Preferences prefs = Preferences.userNodeForPackage(PreferenceDemo.class);
        prefs.put("Location", "0z");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);

        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys()) {
            print(key + ": " + prefs.get(key, null));
        }
        print("How many companions does Dorothy have? " + prefs.getInt("Companions", 0));
    }



}