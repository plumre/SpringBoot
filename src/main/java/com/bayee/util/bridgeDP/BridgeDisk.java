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
 * @date 2018/12/3 16:57
 */
class Node2 {
    public int value;
    public Node2 prev, next;

    public Node2(int i) {
        this.value = i;
    }
}

class Stack {
    private StackImpl impl;

    public Stack(String s) {
        if ("array".equals(s)) {
            impl = new StackArray2();
        } else if ("list".equals(s)) {
            impl = new StackList2();
        } else {
            System.out.println("Stack: unknown parameter");
        }
    }

    public Stack() {
        this("array");
    }

    public void push(int i) {
        impl.push(i);
    }

    public int pop() {
        return impl.pop();
    }

    public int top() {
        return impl.top();
    }

    public boolean isEmpty() {
        return impl.isEmpty();
    }

    public boolean isFull() {
        return impl.isFull();
    }
}

class StackHanoi2 extends Stack {
    private int totalRejected = 0;

    public StackHanoi2() {
        super("array");
    }

    public StackHanoi2(String s) {
        super(s);
    }

    public int reportRejected() {
        return totalRejected;
    }

    @Override
    public void push(int in) {
        if (!isEmpty() && in > top()) {
            totalRejected++;
        } else {
            super.push(in);
        }
    }
}

class StackFIFO2 extends Stack {
    private StackImpl stackImpl = new StackList2();

    public StackFIFO2() {
        super("array");
    }

    public StackFIFO2(String s) {
        super(s);
    }

    @Override
    public int pop() {
        while (!isEmpty()) {
            stackImpl.push(super.pop());
        }
        int ret = stackImpl.pop();
        while (!stackImpl.isEmpty()) {
            push(stackImpl.pop());
        }
        return ret;
    }
}

interface StackImpl {
    void push(int i);

    int pop();

    int top();

    boolean isEmpty();

    boolean isFull();
}

class StackArray2 implements StackImpl {
    private int[] items;
    private int total = -1;

    public StackArray2() {
        this.items = new int[12];
    }

    public StackArray2(int cells) {
        this.items = new int[cells];
    }

    @Override
    public void push(int i) {
        if (!isFull()) {
            items[++total] = i;
        }
    }

    @Override
    public boolean isEmpty() {
        return total == -1;
    }

    @Override
    public boolean isFull() {
        return total == items.length - 1;
    }

    @Override
    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return items[total];
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return items[total--];
    }
}

class StackList2 implements StackImpl {
    private Node last;

    @Override
    public void push(int i) {
        if (last == null) {
            last = new Node(i);
        } else {
            last.next = new Node(i);
            last.next.prev = last;
            last = last.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return last.value;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int ret = last.value;
        last = last.prev;
        return ret;
    }
}

public class BridgeDisk {
    public static void main(String[] args) {
        Stack[] stacks = {new Stack("array"), new Stack("list"),
                new StackFIFO2(), new StackHanoi2()};
        for (int i = 1; i < 15; i++) {
            for (int j = 0; j < 3; j++) {
                stacks[j].push(i);
            }
        }
        Random rn = new Random();
        for (int i = 1; i < 15; i++) {
            stacks[3].push(rn.nextInt(20));
        }
        for (int i = 0; i < stacks.length; i++) {
            while (!stacks[i].isEmpty()) {
                System.out.print(stacks[i].pop() + "  ");
            }
            System.out.println();
        }
        System.out.println("total rejected is " + ((StackHanoi2) stacks[3]).reportRejected());
    }
}