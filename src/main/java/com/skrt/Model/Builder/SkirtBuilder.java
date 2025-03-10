package com.skrt.Model.Builder;

import com.skrt.Model.Enum.*;
import com.skrt.Model.Skirt;

public class SkirtBuilder{
    private Skirt skirt = new Skirt();

    private static int idCounter = 1;


    public SkirtBuilder() {
        skirt.setId(idCounter++);
    }

    public SkirtBuilder setSize(Size size) {
        if(size == null)
            throw new BuildException("Size", size);
        skirt.setSize(size);
        return this;
    }

    public SkirtBuilder setMaterial(Material material) {
        if(material == null)
            throw new BuildException("Material", material);
        skirt.setMaterial(material);
        return this;
    }

    public SkirtBuilder setColor(Color color) {
        if(color == null)
            throw new BuildException("Color", color);
        skirt.setColor(color);
        return this;
    }

    public Skirt build() {
        if(skirt.getColor() == null || skirt.getMaterial() == null)
            throw new BuildException("Build process", "Skirt");

        String generatedName = skirt.getColor().toString() + " " +
                                skirt.getMaterial().toString() + " Skirt";

        skirt.setName(generatedName);

        return skirt;
    }
}
