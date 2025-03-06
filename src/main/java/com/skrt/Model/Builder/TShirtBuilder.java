package com.skrt.Model.Builder;

import com.skrt.Model.Enum.*;
import com.skrt.Model.TShirt;

public class TShirtBuilder{
    private TShirt tShirt = new TShirt();

    private static int idCounter = 1;


    public TShirtBuilder() {
        tShirt.setId(idCounter++);
    }

    public TShirtBuilder setSize(Size size){
        if(size == null)
            throw new BuildException("Size", size);
        tShirt.setSize(size);
        return this;
    }

    public TShirtBuilder setMaterial(Material material){
        if(material == null)
            throw new BuildException("Material", material);
        tShirt.setMaterial(material);
        return this;
    }

    public TShirtBuilder setColor(Color color){
        if(color == null)
            throw new BuildException("Color", color);
        tShirt.setColor(color);
        return this;
    }

    // Här gjorde jag misstaget micke varnade om haha jag lät builder ta hand om steg 4 och 5. korrigerat nu så det bara är steg 1-3
/*
    public TShirtBuilder setSleeve(Sleeve sleeve) {
        if(sleeve == null)
            throw new BuildException("Sleeve", sleeve);
        tShirt.setSleeve(sleeve);
        return this;
    }

    public TShirtBuilder setNeck(Neck neck) {
        if(neck == null)
            throw new BuildException("Neck", neck);
        tShirt.setNeck(neck);
        return this;
    }*/



    public TShirt build() {
        if(tShirt.getColor() == null ||tShirt.getMaterial() == null)
            throw new BuildException("Build process", "TShirt");

        String generatedName = tShirt.getColor().toString() + " " +
                               tShirt.getMaterial().toString() + " TShirt";

        tShirt.setName(generatedName);

        return tShirt;
    }
}
