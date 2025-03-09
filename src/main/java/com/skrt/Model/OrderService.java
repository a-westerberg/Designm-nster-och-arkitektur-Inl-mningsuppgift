package com.skrt.Model;

import com.skrt.Model.Observer.Observable;
import com.skrt.Model.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements Observable {
    private static OrderService instance;
    private final List<Observer> observers = new ArrayList<>();

    /* TODO Singleton */

    private OrderService() {

    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public void placeOrder(Order order) {
        System.out.println("Order Placed: " + order + "\n");
        notifyObservers("New order from " + order.getCustomer() + ": " + order + "\n");
    }

    public void completeOrder(Order order) {
        System.out.println("Order Completed: " + order.getItems() + "\n");
        notifyObservers("New order has been completed from: " + order.getCustomer() + ": " + order + "\n");
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
