package com.bayee.util.serial;

/*
 * Created by renhongjiang on 2019/2/28.
 */

import java.io.Serializable;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/28 17:56
 */
public class Alien implements Serializable {


    private static final long serialVersionUID = -741528553692977872L;
    private static Alien alien;
    private String name;
    private int age;


    @Override
    public String toString() {
        return "Alien{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*private Alien() {
    }

    public synchronized static Alien getInstance() {
        if (alien == null) {
            return new Alien();
        }
        return alien;
    }

    private Object readResolve() {
        return getInstance();
    }*/
}