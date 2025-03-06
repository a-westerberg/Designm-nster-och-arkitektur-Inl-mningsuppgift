package com.skrt.View;

import com.skrt.Model.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ConsoleView {
    /* TODO menysystem och interaktion */

    private Scanner scanner = new Scanner(System.in);
    private OrderService orderService = new OrderService();
    private CEO ceo = new CEO();


    public ConsoleView() {
        orderService.addObserver(ceo);
    }

    public void start(){

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

        Customer customer = new Customer(name, email);
        Order order = new Order(Cart.getItems(), customer);

        orderService.placeOrder(order);
        Cart.clear();
    }

}
