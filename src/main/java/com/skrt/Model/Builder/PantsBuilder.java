package com.skrt.Model.Builder;

import com.skrt.Model.Enum.*;
import com.skrt.Model.Pants;

public class PantsBuilder{
    private Pants pants = new Pants();

    private static int idCounter = 1;


    public PantsBuilder() {
        pants.setId(idCounter++);
    }

    public PantsBuilder setSize(Size size) {
        if (size == null)
            throw new BuildException("Size", size);
        pants.setSize(size);
        return this;
    }

    public PantsBuilder setMaterial(Material material) {
        if (material == null)
            throw new BuildException("Material", material);
        pants.setMaterial(material);
        return this;
    }

    public PantsBuilder setColor(Color color) {
        if(color == null)
            throw new BuildException("Color", color);
        pants.setColor(color);
        return this;
    }

    public Pants build() {
        if(pants.getMaterial() == null || pants.getColor() == null)
            throw new BuildException("Build process", "Pants");

        String generatedName;

        if(pants.getMaterial().toString() == "Jeans") {
                generatedName = pants.getColor().toString() + " " +
                                pants.getMaterial().toString();
        } else {
                generatedName = pants.getColor().toString() + " " +

                                pants.getMaterial().toString() + " Pants";

        }
        pants.setName(generatedName);

        return pants;
    }
}
