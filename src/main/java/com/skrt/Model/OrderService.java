package com.skrt.Model;

import com.skrt.Model.Observer.Observable;
import com.skrt.Model.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements Observable {
    private final List<Observer> observers = new ArrayList<>();

    /* TODO Singleton */

    public void placeOrder(Order order) {
        System.out.println("Order Placed: " + order);
        notifyObservers("New order from " + order.getCustomer() + ": " + order);
    }

    public void completeOrder(Order order) {
        System.out.println("Order Completed: " + order);
        notifyObservers("New order has been completed from: " + order.getCustomer() + ": " + order);
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
