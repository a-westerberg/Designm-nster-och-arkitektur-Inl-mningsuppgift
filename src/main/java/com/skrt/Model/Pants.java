package com.skrt.Model;

import com.skrt.Model.Enum.*;

public class Pants extends Clothing{
    private Fit fit;
    private Lenght lenght;

    public Pants() {
    }

    public Pants(int id, String name,Size size, Material material, Color color, Fit fit, Lenght lenght) {
        super(id, name, size, material, color);
        this.fit = fit;
        this.lenght = lenght;
    }

    public Fit getFit() {
        return fit;
    }

    public void setFit(Fit fit) {
        this.fit = fit;
    }

    public Lenght getLenght() {
        return lenght;
    }

    public void setLenght(Lenght lenght) {
        this.lenght = lenght;
    }

    @Override
    public String toString() {
        return super.toString() + ", fit=" + fit + ", lenght=" + lenght + "}";
    }
}
