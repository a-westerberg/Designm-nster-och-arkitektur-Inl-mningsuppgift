package com.skrt.Model;

import java.util.List;

public class Order {
    private int id;
    private static int orderCount = 1;
    private String name;
    private List<Clothing> items;
    private Customer customer;

    public Order() {
    }

    public Order(List<Clothing> items, Customer customer) {
        this.id = orderCount++;
        this.items = items;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getOrderCount() {
        return orderCount;
    }

    public static void setOrderCount(int orderCount) {
        Order.orderCount = orderCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Clothing> getItems() {
        return items;
    }

    public void setItems(List<Clothing> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", items=" + items + "}";
    }
}
