package com.skrt.View;

import com.skrt.Model.Order;

import java.util.Scanner;

public class Receipt {
    private int id;
    private String name;


    public static void printReceipt(Order order){
        Scanner scanner = new Scanner(System.in);
        double totalPrice = 0.0;
        System.out.println("---------------------------");
        System.out.println("Receipt:");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Email: " + order.getCustomer().getEmail());
        System.out.println("\nItems ordered: ");

        for (var item : order.getItems()) {
            System.out.println(" - {" + item.getName() + "} - " + item.getPrice() + "kr");
            totalPrice += item.getPrice();
        }

        System.out.println(" - Total: " + totalPrice + "kr\n");
        System.out.println("Order will be shipped to: {" + order.getCustomer().getAddress() + "} as soon as we are done packaging!");
        System.out.println("Thanks for the order!");
        System.out.println("---------------------------\n");
        System.out.print("Press any button to go back to menu: ");
        String goToMenu = scanner.nextLine();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
