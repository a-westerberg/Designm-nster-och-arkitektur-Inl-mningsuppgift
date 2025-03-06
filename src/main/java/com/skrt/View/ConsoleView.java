package com.skrt.View;

import com.skrt.Model.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ConsoleView {
    /* TODO menysystem och interaktion */

    private Scanner scanner = new Scanner(System.in);
    private OrderService orderService = new OrderService();
    private CEO ceo = new CEO();
    private Customer customer;


    public ConsoleView() {
        orderService.addObserver(ceo);
    }

    public void startMenu(){
        registerCustomer();

        boolean running = true;
        while (running) {           // Behöver åtgärdas, atm så går loopen tillbaka till start Så man måste klicka to continue igen, ta bort eller fixa
            System.out.print("-------------------");
            System.out.println("\n WIGELL WEBSHOP");
            System.out.println("-------------------");
            System.out.println("Here at Wigells you can create and design your own cloths");
            System.out.print("Press any button to continue");
            scanner.nextLine();
            clearConsole();

            System.out.print("-------------------");
            System.out.println("\n WIGELL WEBSHOP");
            System.out.println("-------------------");
            System.out.println("1. Create T-Shirt");
            System.out.println("2. Create Pants");
            System.out.println("3. Create Skirt");
            System.out.println("4. Exit.");
            System.out.print("Enter your choice: ");

            int menuOption = scanner.nextInt();
            scanner.nextLine();
            switch (menuOption) {
                case 1 -> System.out.println();
                case 2 -> System.out.println();
                case 3 -> System.out.println();
                case 4 -> running = false;
                default -> System.out.println("Invalid option, please try again");
            }
        }
        System.out.println("Exiting...");

    }


    private void placeOrder(){
        if(Cart.isEmpty()){
            System.out.println("Cart is empty, add clothing before checking out");
            return;
        }
        System.out.print("\n Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();


        Order order = new Order(Cart.getItems(), customer);

        orderService.placeOrder(order);
        Cart.clear();
    }

    private void registerCustomer(){
        System.out.println("\nWelcome to WIGELL WEBSHOP\nTo start shopping you need to register yourself.");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        customer = new Customer(name, email, address);
        System.out.println("\nRegistration successful!\nWelcome " + customer.getName());
    }



    private void clearConsole(){
        System.out.println("\n\n\n\n\n");
    }
}
