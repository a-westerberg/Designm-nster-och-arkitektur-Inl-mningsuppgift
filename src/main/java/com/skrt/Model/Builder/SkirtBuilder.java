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

    public SkirtBuilder setWaistline(Waistline waistline) {
        if(waistline == null)
            throw new BuildException("Waistline", waistline);
        skirt.setWaistline(waistline);
        return this;
    }

    public SkirtBuilder setPattern(Pattern pattern) {
        if(pattern == null)
            throw new BuildException("Pattern", pattern);
        skirt.setPattern(pattern);
        return this;
    }



    public Skirt build() {
        if(skirt.getColor() == null || skirt.getPattern() == null)
            throw new BuildException("Build process", "Skirt");

        String generatedName = skirt.getColor().toString() + " " +
                                skirt.getPattern().toString() + " Skirt";

        skirt.setName(generatedName);

        return skirt;
    }
}
