package com.skrt.View;

import com.skrt.Model.*;
import com.skrt.Model.Builder.PantsBuilder;
import com.skrt.Model.Builder.SkirtBuilder;
import com.skrt.Model.Builder.TShirtBuilder;
import com.skrt.Model.Command.*;
import com.skrt.Model.Enum.*;
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
        while (running) {


            System.out.print("-------------------");
            System.out.println("\n WIGELL WEBSHOP");
            System.out.println("-------------------");
            System.out.println("1. Create Pants");
            System.out.println("2. Create T-Shirt");
            System.out.println("3. Create Skirt");
            System.out.println("4. Place Order");
            System.out.println("5. Exit.");
            System.out.print("Enter your choice: ");

            int menuOption = scanner.nextInt();
            scanner.nextLine();
            switch (menuOption) {
                case 1 -> createPants();
                case 2 -> createTShirt();
                case 3 -> createSkirt();
                case 4 -> placeOrder();
                case 5 -> running = false;
                default -> System.out.println("Invalid option, please try again");
            }
        }
        System.out.println("Exiting...");
    }

    private void placeOrder(){
        if(Cart.isEmpty()){
            clearConsole();
            System.out.println("Cart is empty, add clothing before checking out");
            return;
        }
        clearConsole();
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
        System.out.println();
        System.out.println("Here at Wigells you can create and design your own cloths");
        System.out.print("Press any button to continue");
        scanner.nextLine();
        clearConsole();
    }

    private void createPants(){
        clearConsole();
        System.out.println("\nCreating pant:");
        PantsBuilder builder = new PantsBuilder();
        builder.setSize(selectSize());
        builder.setMaterial(selectMaterial());
        builder.setColor(selectColor());
        Pants pants = builder.build();

        System.out.println("Final touches to style your order:");
        Command fitCommand = new SetFitCommand(pants, selectFit());
        Command lenghtCommand = new SetLenghtCommand(pants, selectLenght());

        fitCommand.execute(pants);
        lenghtCommand.execute(pants);

        System.out.println("Created: {" + pants.getName() + "}\n");
        Cart.addItem(pants);
    }

    private void createTShirt(){
        clearConsole();
        System.out.println("\nCreating t-shirt:");
        TShirtBuilder builder = new TShirtBuilder();
        builder.setSize(selectSize());
        builder.setMaterial(selectMaterial());
        builder.setColor(selectColor());
        TShirt tShirt = builder.build();

        System.out.println("Final touches to style your order:");
        Command sleeveCommand = new SetSleeveCommand(tShirt, selectSleeve());
        Command neckCommand = new SetNeckCommand(tShirt, selectNeck());

        sleeveCommand.execute(tShirt);
        neckCommand.execute(tShirt);

        System.out.println("Created: {" + tShirt.getName() + "}\n");
        Cart.addItem(tShirt);
    }

    private void createSkirt(){
        clearConsole();
        System.out.println("\nCreating skirt:");
        SkirtBuilder builder = new SkirtBuilder();
        builder.setSize(selectSize());
        builder.setMaterial(selectMaterial());
        builder.setColor(selectColor());
        Skirt skirt = builder.build();

        System.out.println("Final touches to style your order:");
        Command waistlineCommand = new SetWaistlineCommand(skirt, selectWaistline());
        Command patternCommand = new SetPatternCommand(skirt, selectPattern());

        waistlineCommand.execute(skirt);
        patternCommand.execute(skirt);

        System.out.println("Created: {" + skirt.getName() + "}\n");
        Cart.addItem(skirt);
    }



    private void clearConsole(){
        System.out.println("\n\n\n\n\n");
    }

    private Size selectSize(){
        System.out.println("Select a Size:");
        return selectEnum(Size.values());
    }

    private Material selectMaterial(){
        System.out.println("Select a Material:");
        return selectEnum(Material.values());
    }

    private Color selectColor(){
        System.out.println("Select a Color:");
        return selectEnum(Color.values());
    }

    private Sleeve selectSleeve(){
        System.out.println("Select a Sleeve:");
        return selectEnum(Sleeve.values());
    }

    private Neck selectNeck(){
        System.out.println("Select a Neck:");
        return selectEnum(Neck.values());
    }

    private Fit selectFit(){
        System.out.println("Select a Fit:");
        return selectEnum(Fit.values());
    }

    private Lenght selectLenght(){
        System.out.println("Select a Lenght:");
        return selectEnum(Lenght.values());
    }

    private Waistline selectWaistline(){
        System.out.println("Select a Waistline:");
        return selectEnum(Waistline.values());
    }

    private Pattern selectPattern(){
        System.out.println("Select a Pattern:");
        return selectEnum(Pattern.values());
    }

    private <T extends Enum<T>> T selectEnum(T[] values){
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        if (choice < 1 || choice > values.length) {
            System.out.println("Invalid choice, please try again");
            return selectEnum(values);
        }
        return values[choice - 1];
    }

}
