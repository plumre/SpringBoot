package com.bayee.chapter20;

/*
 * Created by renhongjiang on 2018/10/26.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/26 15:54
 */
public class Plate<T> {

    private T item;

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }




}