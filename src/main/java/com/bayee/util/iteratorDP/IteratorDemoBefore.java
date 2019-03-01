package com.bayee.util.iteratorDP;

/*
 * Created by renhongjiang on 2018/12/5.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/5 17:02
 */
class IntegerBox {
    private final List<Integer> list = new ArrayList<>();
    public void add(int i) {
        list.add(i);
    }

    public List<Integer> getData() {
        return list;
    }
}

public class IteratorDemoBefore {

    public static void main(String[] args) {
        IntegerBox box = new IntegerBox();
        for (int i = 9; i > 0; --i) {
            box.add(i);
        }
        Collection integerList = box.getData();
        for (Object o : integerList) {
            System.out.print(o + "   ");
        }
        System.out.println();
        integerList.clear();
        integerList = box.getData();
        System.out.println("size of data is : " + integerList.size());
    }
}