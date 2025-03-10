package com.skrt.Controller;

import com.skrt.Model.*;
import com.skrt.Model.Builder.PantsBuilder;
import com.skrt.Model.Builder.SkirtBuilder;
import com.skrt.Model.Builder.TShirtBuilder;
import com.skrt.Model.Command.*;
import com.skrt.Model.Enum.*;
import com.skrt.View.Receipt;

public class WebshopController {

    private OrderService orderService = OrderService.getInstance();
    private CEO ceo = new CEO();
    private Customer customer;

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

        Command fitCommand = new SetFitCommand(pants, fit);
        Command lenghtCommand = new SetLenghtCommand(pants, lenght);

        fitCommand.execute(pants);
        lenghtCommand.execute(pants);

        orderService.notifyObservers("New Pants created: " + pants.getName());

        Cart.addItem(pants);
    }

    public void createTShirt(Size size, Material material, Color color, Sleeve sleeve, Neck neck){
        TShirtBuilder builder = new TShirtBuilder();
        builder.setSize(size);
        builder.setMaterial(material);
        builder.setColor(color);
        TShirt tshirt = builder.build();

        Command sleeveCommand = new SetSleeveCommand(tshirt, sleeve);
        Command neckCommand = new SetNeckCommand(tshirt, neck);

        sleeveCommand.execute(tshirt);
        neckCommand.execute(tshirt);

        orderService.notifyObservers("New T-Shirt created: " + tshirt.getName());
        Cart.addItem(tshirt);
    }

    public void createSkirt(Size size, Material material, Color color, Waistline waistline, Pattern pattern){
        SkirtBuilder builder = new SkirtBuilder();
        builder.setSize(size);
        builder.setMaterial(material);
        builder.setColor(color);
        Skirt skirt = builder.build();

        Command waistlineCommand = new SetWaistlineCommand(skirt, waistline);
        Command patternCommand = new SetPatternCommand(skirt, pattern);

        waistlineCommand.execute(skirt);
        patternCommand.execute(skirt);

        orderService.notifyObservers("New Skirt created: " + skirt.getName());
        Cart.addItem(skirt);
    }


    public Customer getCustomer() {
        return customer;
    }

}
