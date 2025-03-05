package com.skrt;

import com.skrt.Model.Builder.BuildException;
import com.skrt.Model.Builder.PantsBuilder;
import com.skrt.Model.Builder.SkirtBuilder;
import com.skrt.Model.Builder.TShirtBuilder;
import com.skrt.Model.Enum.*;
import com.skrt.Model.Pants;
import com.skrt.Model.Skirt;
import com.skrt.Model.TShirt;

public class App {
    public static void main( String[] args ) {
        /** Testar nedanför kommer ta bort vid senare stadie. **/
        try{
            TShirt tshirt = new TShirtBuilder()
                    .setSize(Size.Medium)
                    .setMaterial(Material.Linnen)
                    .setColor(Color.Black)
                    .setSleeve(Sleeve.Long)
                    .setNeck(Neck.V_neck)
                    .build();

            Skirt skirt = new SkirtBuilder()
                    .setSize(Size.Small)
                    .setMaterial(Material.Silk)
                    .setColor(Color.Blue)
                    .setWaistline(Waistline.High)
                    .setPattern(Pattern.Flower)
                    .build();

            Pants jeans = new PantsBuilder()
                    .setSize(Size.Large)
                    .setMaterial(Material.Jeans)
                    .setColor(Color.Blue)
                    .setFit(Fit.Loose)
                    .setLenght(Lenght.Long)
                    .build();
            Pants pants = new PantsBuilder()
                    .setSize(Size.Small)
                    .setMaterial(Material.Linnen)
                    .setColor(Color.White)
                    .setFit(Fit.Regular)
                    .setLenght(Lenght.ThreeQuaters)
                    .build();

            Skirt almaSkirt = new SkirtBuilder()
                    .setSize(Size.Medium)
                    .setMaterial(Material.Linnen)
                    .setColor(Color.Black)
                    .setWaistline(Waistline.High)
                    .setPattern(Pattern.Plain)
                    .build();


            System.out.println("Ett par plagg skapas: ");
            System.out.println(tshirt);
            System.out.println(tshirt.getName());
            line();
            System.out.println(skirt);
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
            System.out.println(almaSkirt.getName());


        } catch (BuildException e){
            System.out.println("Fel vid byggande av plagg - " + e.getMessage());



        }
    }
    public static void line(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
