package com.bayee.util.chainDP;

/*
 * Created by renhongjiang on 2018/12/5.
 */

import com.sun.corba.se.impl.orbutil.ORBUtility;

import javax.print.attribute.HashDocAttributeSet;
import java.util.Random;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/5 15:32
 */
class Handler2 {
    private static final Random RANDOM = new Random();
    private static int nextID = 1;
    private int id = nextID++;
    private Handler2 nextInChain;

    public void add(Handler2 next) {
        if (nextInChain == null) {
            nextInChain = next;
        } else {
            nextInChain.add(next);
        }
    }

    public void wrapAround(Handler2 root) {
        if (nextInChain == null) {
            nextInChain = root;
        } else {
            nextInChain.wrapAround(root);
        }
    }

    public void execute(int num) {
        if (RANDOM.nextInt(4) != 0) {
            System.out.println("   " + id + "-busy   ");
            nextInChain.execute(num);
        } else {
            System.out.println(id + "-handled-" + num);
        }
    }

}



public class ChainDemo {

    public static void main(String[] args) {
        Handler2 rootChain = new Handler2();
        rootChain.add(new Handler2());
        rootChain.add(new Handler2());
        rootChain.add(new Handler2());
        rootChain.wrapAround(rootChain);
        for (int i = 1; i < 6; i++) {
            System.out.println("Operation #" + i + ":");
            rootChain.execute(i);
            System.out.println();
        }
    }
}