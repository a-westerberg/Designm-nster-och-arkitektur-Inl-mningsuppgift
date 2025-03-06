package com.skrt;

import com.skrt.Model.*;
import com.skrt.Model.Builder.BuildException;
import com.skrt.Model.Builder.PantsBuilder;
import com.skrt.Model.Builder.SkirtBuilder;
import com.skrt.Model.Builder.TShirtBuilder;
import com.skrt.Model.Command.CommandProcessor;
import com.skrt.Model.Command.SetNeckCommand;
import com.skrt.Model.Command.SetSleeveCommand;
import com.skrt.Model.Enum.*;

public class App {
    public static void main( String[] args ) {
        /** Testar nedanför kommer ta bort vid senare stadie. **/
        try{
            TShirt tshirt = new TShirtBuilder()
                    .setSize(Size.Medium)
                    .setMaterial(Material.Linnen)
                    .setColor(Color.Black)
                    .build();

            /*Skirt skirt = new SkirtBuilder()
                    .setSize(Size.Small)
                    .setMaterial(Material.Silk)
                    .setColor(Color.Blue)
                    .build();

            Pants jeans = new PantsBuilder()
                    .setSize(Size.Large)
                    .setMaterial(Material.Jeans)
                    .setColor(Color.Blue)
                    .build();
            Pants pants = new PantsBuilder()
                    .setSize(Size.Small)
                    .setMaterial(Material.Linnen)
                    .setColor(Color.White)
                    .build();

            Skirt almaSkirt = new SkirtBuilder()
                    .setSize(Size.Medium)
                    .setMaterial(Material.Linnen)
                    .setColor(Color.Black)
                    .build();*/

            CommandProcessor processor = new CommandProcessor();

            processor.addCommand(new SetSleeveCommand(Sleeve.Short));
            processor.addCommand(new SetNeckCommand(Neck.V_neck));

            processor.executeCommands(tshirt);


            CEO ceo = new CEO();
            OrderService orderService = new OrderService();
            orderService.addObserver(ceo);
            Order order = new Order();

            System.out.println("Place order:");
            orderService.placeOrder(order);
            line();
            System.out.println("Complete order:");
            orderService.completeOrder(order);
            line();

            System.out.println("Med builder och Command");
            System.out.println("T-shirt: " + tshirt);
            System.out.println();
            line();

            /*System.out.println(skirt);
            System.out.println(skirt.getName());
            line();
            System.out.println(jeans);
            System.out.println(jeans.getName());
            line();
            System.out.println(pants);
            System.out.println(pants.getName());
            line();
            System.out.println();
            line();

            System.out.println("Almas kjol:");
            System.out.println(almaSkirt);
            System.out.println(almaSkirt.getName());*/


        } catch (BuildException e){
            System.out.println("Fel vid byggande av plagg - " + e.getMessage());



        }
    }
    public static void line(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
