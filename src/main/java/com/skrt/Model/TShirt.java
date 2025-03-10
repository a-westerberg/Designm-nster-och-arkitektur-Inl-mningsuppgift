package com.skrt.Model;

import com.skrt.Model.Enum.*;

public class TShirt extends Clothing{
    private  Sleeve sleeve;
    private  Neck neck;
    private  final double price = 100.0;

    public TShirt() {
    }

    public TShirt(int id, String name,Size size, Material material, Color color, Sleeve sleeve, Neck neck) {
       super(id, name, size, material, color);
        this.sleeve = sleeve;
        this.neck = neck;
    }

    public Sleeve getSleeve() {
        return sleeve;
    }

    public void setSleeve(Sleeve sleeve) {
        this.sleeve = sleeve;
    }

    public Neck getNeck() {
        return neck;
    }

    public void setNeck(Neck neck) {
        this.neck = neck;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return super.toString() + ", sleeve=" + sleeve + ", neck=" + neck + "}";
    }
}
