package com.bayee.util;

/*
 * Created by renhongjiang on 2018/11/29.
 */

import java.io.PipedInputStream;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/11/29 17:30
 */

class Pizza {
    private String dough;
    private String sauce;
    private String topping;

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}


abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizzaProduct() {
        pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}

class SpicyPizzaBuilder extends PizzaBuilder {

    @Override
    public void buildDough() {
        pizza.setDough("spiDough");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("spiSauce");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("spiTopping");
    }
}

class HawaiianPizzaBuilder extends PizzaBuilder {

    @Override
    public void buildDough() {
        pizza.setDough("hawaiiDough");
    }

    @Override
    public void buildSauce() {
pizza.setSauce("hawaiiSauce");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("hawaiiTopping");
    }
}


class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}

public class  PizzaBuilderDemo {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder sBuilder = new SpicyPizzaBuilder();
        PizzaBuilder hBuilder = new HawaiianPizzaBuilder();

        waiter.setPizzaBuilder(sBuilder);
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
        System.out.println(pizza);
    }
}

///**
// * product
// */
//class Pizza {
//    private String dough;
//    private String sauce;
//    private String topping;
//
//    public void setDough(String dough) {
//        this.dough = dough;
//    }
//
//    public void setSauce(String sauce) {
//        this.sauce = sauce;
//    }
//
//    public void setTopping(String topping) {
//        this.topping = topping;
//    }
//
//    public String getDough() {
//        return dough;
//    }
//
//    public String getSauce() {
//        return sauce;
//    }
//
//    public String getTopping() {
//        return topping;
//    }
//
//    @Override
//    public String toString() {
//        return "Pizza{" +
//                "dough='" + dough + '\'' +
//                ", sauce='" + sauce + '\'' +
//                ", topping='" + topping + '\'' +
//                '}';
//    }
//}
//
//abstract class PizzaBuilder {
//    protected Pizza pizza;
//
//    public Pizza getPizza() {
//        return pizza;
//    }
//
//    public void createNewPizzaProduct() {
//        pizza = new Pizza();
//    }
//
//    public abstract void buildDough();
//    public abstract void buildSauce();
//    public abstract void buildTopping();
//}
//
///**
// * "ConcreteBuilder"
// */
//class HawaiianPizzaBuilder extends PizzaBuilder {
//
//    @Override
//    public void buildDough() {
//        pizza.setDough("cross");
//    }
//
//    @Override
//    public void buildSauce() {
//        pizza.setSauce("mild");
//    }
//
//    @Override
//    public void buildTopping() {
//        pizza.setTopping("ham+pineapple");
//    }
//}
//
//
///**
// * "ConcreteBuilder"
// */
//class SpicyPizzaBuilder extends PizzaBuilder {
//    @Override
//    public void buildDough() {
//        pizza.setDough("pan baked");
//    }
//
//    @Override
//    public void buildSauce() {
//        pizza.setSauce("hot");
//    }
//
//    @Override
//    public void buildTopping() {
//        pizza.setTopping("pepperoni+salami");
//    }
//}
//
///**
// *  "Director"
// */
//class Waiter {
//    private PizzaBuilder pizzaBuilder;
//
//    public void setPizzaBuilder(PizzaBuilder pb) {
//        pizzaBuilder = pb;
//    }
//
//    public Pizza getPizza() {
//        return pizzaBuilder.getPizza();
//    }
//
//    public void constructPizza() {
//        pizzaBuilder.createNewPizzaProduct();
//        pizzaBuilder.buildDough();
//        pizzaBuilder.buildSauce();
//        pizzaBuilder.buildTopping();
//    }
//}
//
//
//
//public class PizzaBuilderDemo {
//
//    public static void main(String[] args) {
//        Waiter waiter = new Waiter();
//        PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
//        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();
//
//        waiter.setPizzaBuilder(spicyPizzaBuilder);
//        waiter.constructPizza();
//        Pizza pizza = waiter.getPizza();
//
//        System.out.println("your dish is available: " + pizza);
//    }
//}
