package com.bayee.util.mementoDP;

/*
 * Created by renhongjiang on 2018/12/7.
 */

import java.util.ArrayList;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/12/7 15:23
 */
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;
    /*
    lots of memory consumptive private data that is not necessary
    to define the state and should thus not be saved. Hence the small memento object
     */

    public void setState(String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public Memento save() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }

    public void restore(Memento memento) {
        state = memento.getState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }
}

class Caretaker {
    private ArrayList<Memento> mementos = new ArrayList<>();
    public void addMemento(Memento memento) {
        mementos.add(memento);
    }
    public Memento getMemento() {
        return mementos.get(1);
    }
}

public class MementoDemo {
    public static void main(String[] args) {
        Caretaker caretaker  = new Caretaker();
        Originator originator = new Originator();
        originator.setState("s01");
        originator.setState("s02");
        caretaker.addMemento(originator.save());
        originator.setState("s03");
        caretaker.addMemento(originator.save());
        originator.setState("s04");
        originator.restore(caretaker.getMemento());
    }
}