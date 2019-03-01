package com.bayee.util.mediatorDP;

/*
 * Created by renhongjiang on 2018/12/6.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/6 17:09
 */
// 1. Create an "intermediary" that decouples "senders" from "receivers"
class Mediator {
    // 4. The Mediator arbitrates
    private boolean slotFull = false;
    private int number;

    public synchronized void storeMessage(int num) {
        // no room for another message
        while (slotFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        slotFull = true;
        number = num;
        notifyAll();
    }

    public synchronized int retrieveMessages() {
        // no messages to retrieve
        while (!slotFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        slotFull = false;
        notifyAll();
        return number;
    }
}

class Producer implements Runnable {
    // 2. Producers are coupled only to the Mediator
    private Mediator mediator;
    private int id;
    private static int num = 1;

    public Producer(Mediator mediator) {
        this.mediator = mediator;
        id = num++ ;
    }

    @Override
    public void run() {
        int num;
        while (true) {
            mediator.storeMessage(num = (int) (Math.random() * 100));
            System.out.print("p" + id + " - " + num + "   ");
        }
    }
}

class Consumer implements Runnable {
    // 3. Consumers are coupled only to the Mediator
    private Mediator mediator;
    private int id;
    private static int num = 1;

    public Consumer(Mediator mediator) {
        this.mediator = mediator;
        id = num++;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print("c" + id + " - " + mediator.retrieveMessages() + "   ");
        }
    }
}

public class MediatorDemo {
    public static void main( String[] args ) {
        List<Thread> producerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press ENTER for exit");
        Mediator mb = new Mediator();
        producerList.add(new Thread(new Producer(mb)));
        producerList.add(new Thread(new Producer(mb)));
        producerList.add(new Thread(new Consumer(mb)));
        producerList.add(new Thread(new Consumer(mb)));
        producerList.add(new Thread(new Consumer(mb)));
        producerList.add(new Thread(new Consumer(mb)));

        for (Thread p : producerList) {
            p.start();
        }
        boolean stop = false;
        String exit = scanner.nextLine();
        while (!stop) {
            if (exit.equals("")) {
                stop = true;
                for (Thread p : producerList) {
                    //noinspection deprecation
                    p.stop();
                }
            }
        }
    }
}