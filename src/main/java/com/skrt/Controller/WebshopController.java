package com.skrt.Controller;

import com.skrt.Model.*;
import com.skrt.Model.Builder.PantsBuilder;
import com.skrt.Model.Builder.SkirtBuilder;
import com.skrt.Model.Builder.TShirtBuilder;
import com.skrt.Model.Command.*;
import com.skrt.Model.Enum.*;
import com.skrt.View.Receipt;

import java.util.Scanner;

public class WebshopController {

    private OrderService orderService = OrderService.getInstance();
    private CEO ceo = new CEO();
    private Customer customer;
    private Scanner scanner = new Scanner(System.in);

    public WebshopController(){
        orderService.addObserver(ceo);
    }

    public void registerCustomer(String name, String email, String address) {
        customer = new Customer(name, email, address);
    }

    public void completeOrder() {
        if(Cart.isEmpty()){
            System.out.println("Cart is empty, add clothing before checking out");
            return;
        }
        System.out.println();
        Order order = new Order(Cart.getItems(), customer);
        orderService.completeOrder(order);
        new Receipt().printReceipt(order);
        Cart.clear();
    }

    public void createPants(Size size, Material material, Color color, Fit fit, Lenght lenght){
        PantsBuilder builder = new PantsBuilder();
        builder.setSize(size);
        builder.setMaterial(material);
        builder.setColor(color);
        Pants pants = builder.build();

        PipelineCommand pipeline = new PipelineCommand();
        pipeline.addCommand(new SetFitCommand(pants, fit));
        pipeline.addCommand(new SetLenghtCommand(pants, lenght));

        pipeline.execute(pants);

        orderService.notifyObservers("New Pants created: " + pants.getName());
        Cart.addItem(pants);

        System.out.print("\nPress any button to go back to menu where you can checkout or create another piece of clothing: ");
        String goToMenu = scanner.nextLine();
    }

    public void createTShirt(Size size, Material material, Color color, Sleeve sleeve, Neck neck){
        TShirtBuilder builder = new TShirtBuilder();
        builder.setSize(size);
        builder.setMaterial(material);
        builder.setColor(color);
        TShirt tshirt = builder.build();

        PipelineCommand pipeline = new PipelineCommand();
        pipeline.addCommand(new SetSleeveCommand(tshirt,sleeve));
        pipeline.addCommand(new SetNeckCommand(tshirt,neck));

        pipeline.execute(tshirt);

        orderService.notifyObservers("New T-Shirt created: " + tshirt.getName());
        Cart.addItem(tshirt);

        System.out.print("\nPress any button to go back to menu where you can checkout or create another piece of clothing: ");
        String goToMenu = scanner.nextLine();
    }

    public void createSkirt(Size size, Material material, Color color, Waistline waistline, Pattern pattern){
        SkirtBuilder builder = new SkirtBuilder();
        builder.setSize(size);
        builder.setMaterial(material);
        builder.setColor(color);
        Skirt skirt = builder.build();

        PipelineCommand pipeline = new PipelineCommand();
        pipeline.addCommand(new SetWaistlineCommand(skirt,waistline));
        pipeline.addCommand(new SetPatternCommand(skirt,pattern));

        pipeline.execute(skirt);

        orderService.notifyObservers("New Skirt created: " + skirt.getName());
        Cart.addItem(skirt);

        System.out.print("\nPress any button to go back to menu where you can checkout or create another piece of clothing: ");
        String goToMenu = scanner.nextLine();

    }


    public Customer getCustomer() {
        return customer;
    }

}
