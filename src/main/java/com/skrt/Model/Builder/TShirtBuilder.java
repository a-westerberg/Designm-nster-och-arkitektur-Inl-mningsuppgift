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

    public TShirt build() {
        if(tShirt.getColor() == null ||tShirt.getMaterial() == null)
            throw new BuildException("Build process", "TShirt");

        String generatedName = tShirt.getColor().toString() + " " +
                               tShirt.getMaterial().toString() + " TShirt";

        tShirt.setName(generatedName);

        return tShirt;
    }
}
