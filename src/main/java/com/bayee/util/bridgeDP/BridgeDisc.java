package com.bayee.util.bridgeDP;

/*
 * Created by renhongjiang on 2018/12/3.
 */

import java.util.Random;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/3 14:23
 */
class Node {
    public int value;
    public Node prev, next;

    public Node(int value) {
        this.value = value;
    }
}

class StackArray {
    private int[] items;
    private int size = -1;

    public StackArray() {
        this.items = new int[12];
    }

    public StackArray(int cells) {
        this.items = new int[cells];
    }

    public void push(int i) {
        if (!isFull()) {
            items[++size] = i;
        }
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public boolean isFull() {
        return size == items.length - 1;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return items[size];
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return items[size--];
    }
}

class StackList {
    private Node last;

    public void push(int i) {
        if (last == null) {
            last = new Node(i);
        } else {
            last.next = new Node(i);
            last.next.prev = last;
            last = last.next;
        }
    }

    public boolean isEmpty() {
        return last == null;
    }

    public boolean isFull() {
        return false;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return last.value;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int ret = last.value;
        last = last.prev;
        return ret;
    }
}

class StackFIFO extends StackArray {
    private StackArray stackArray = new StackArray();

    @Override
    public int pop() {
        while (!isEmpty()) {
            stackArray.push(super.pop());
        }
        int ret = stackArray.pop();
        while (!stackArray.isEmpty()) {
            push(stackArray.pop());
        }
        return ret;
    }
}

class StackHanoi extends StackArray {
    private int totalRejected = 0;

    public int reportRejected() {
        return totalRejected;
    }

    @Override
    public void push(int i) {
        if (!isEmpty() && i > top()) {
            totalRejected++;
        } else {
            super.push(i);
        }
    }
}

public class BridgeDisc {

    public static void main(String[] args) {
        StackArray[] stacks = {new StackArray(), new StackFIFO(), new StackHanoi()};
        StackList stackList = new StackList();
        for (int i = 1; i < 15; i++) {
            stacks[0].push(i);
            stackList.push(i);
            stacks[1].push(i);
        }
        Random random = new Random();
        for (int i = 1; i < 15; i++) {
            stacks[2].push(random.nextInt(20));
        }

        // stacks[0] ---
        while (!stacks[0].isEmpty()) {
            System.out.print(" " + stacks[0].pop());
        }
        System.out.println();

        while (!stackList.isEmpty()) {
            System.out.print(" " + stackList.pop());
        }
        System.out.println();

        // stacks[1] ---
        while (!stacks[1].isEmpty()) {
            System.out.print(" " + stacks[1].pop());
        }
        System.out.println();

        // stacks[2] ---
        while (!stacks[2].isEmpty()) {
            System.out.print(" " + stacks[2].pop());
        }
        System.out.println();

        // stackList ---

        System.out.println("total rejected is " + ((StackHanoi)stacks[2]).reportRejected());
    }

}