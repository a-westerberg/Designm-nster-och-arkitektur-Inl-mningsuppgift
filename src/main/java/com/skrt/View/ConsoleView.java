package com.skrt.View;

import com.skrt.Controller.WebshopController;
import com.skrt.Model.*;
import com.skrt.Model.Enum.*;

import java.util.Scanner;

public class ConsoleView {

    private Scanner scanner = new Scanner(System.in);
    private WebshopController controller = new WebshopController();

    private OrderService orderService = OrderService.getInstance();
    private CEO ceo = new CEO();
    private Customer customer;




    public ConsoleView() {
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
            System.out.println("4. Checkout");
            System.out.println("5. Exit.");
            System.out.print("Enter your choice: ");

            String menuOption = scanner.nextLine();
            switch (menuOption) {
                case "1" -> createPants();
                case "2" -> createTShirt();
                case "3" -> createSkirt();
                case "4" -> controller.completeOrder();
                case "5" -> running = false;
                default -> System.out.println("Invalid option, please try again");
            }
        }
        System.out.println("\nExiting...");
    }

    // Old
    private void completeOrder(){
        Receipt receipt = new Receipt();
        if(Cart.isEmpty()){
            clearConsole();
            System.out.println("Cart is empty, add clothing before checking out");
            return;
        }
        clearConsole();
        Order order = new Order(Cart.getItems(), customer);

        orderService.completeOrder(order);
        receipt.printReceipt(order);

        Cart.clear();
    }

    /** Old private void registerCustomer(){
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
    }**/
    private void registerCustomer(){
        System.out.println("\nWelcome to WIGELL WEBSHOP\nTo start shopping you need to register yourself.");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        controller.registerCustomer(name, email, address);

        System.out.println("\nRegistration successful!\nWelcome " + controller.getCustomer().getName());
        System.out.println();
        System.out.println("Here at Wigells you can create and design your own cloths");
        System.out.print("Press any button to continue");
        scanner.nextLine();
        clearConsole();
    }

   /** Old private void createPants(){
        clearConsole();
        orderService.notifyObservers("Production of new pants has begun");
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

        orderService.notifyObservers("New pants created: " + pants.getName());

        Cart.addItem(pants);
    }**/
   private void createPants(){
       orderService.notifyObservers("Production of new pants has begun");
       System.out.println("\nCreating pants: ");
       Size size = selectSize();
       Material material = selectMaterial();
       Color color = selectColor();
       Fit fit = selectFit();
       Lenght lenght = selectLenght();

       controller.createPants(size, material, color, fit, lenght);
   }

    /** Old private void createTShirt(){
        clearConsole();
        orderService.notifyObservers("Production of new T-Shirt has begun");
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

        orderService.notifyObservers("New pants created: " + tShirt.getName());

        Cart.addItem(tShirt);
    }**/
    private void createTShirt(){

        orderService.notifyObservers("Production of new T-Shirt has begun");
        System.out.println("\nCreating T-Shirt:");
        Size size = selectSize();
        Material material = selectMaterial();
        Color color = selectColor();
        Sleeve sleeve = selectSleeve();
        Neck neck = selectNeck();

        controller.createTShirt(size,material,color,sleeve,neck);

    }

    /** Old private void createSkirt(){
        clearConsole();
        orderService.notifyObservers("Production of new Skirt has begun");
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

        orderService.notifyObservers("New Skirt created: " + skirt.getName());

        Cart.addItem(skirt);
    }*/
    private void createSkirt(){

        orderService.notifyObservers("Production of new Skirt has begun");
        System.out.println("\nCreating skirt:");
        Size size = selectSize();
        Material material = selectMaterial();
        Color color = selectColor();
        Waistline waistline = selectWaistline();
        Pattern pattern = selectPattern();

        controller.createSkirt(size,material,color,waistline,pattern);
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
        while(true){
            for (int i = 0; i < values.length; i++) {
                System.out.println((i + 1) + ". " + values[i]);
            }
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();
            System.out.println();

            try{
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= values.length) {
                    return values[choice - 1];
                } else {
                    System.out.println("Invalid choice, please enter a number between 1 and " + (values.length));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
    }

}
