package com.skrt.Model;

import com.skrt.Model.Enum.Color;
import com.skrt.Model.Enum.Material;
import com.skrt.Model.Enum.Size;

public abstract class Clothing {
    protected int id;
    protected String name;
    protected Size size;
    protected Material material;
    protected Color color;
    protected double price;

    public Clothing() {
    }

    public Clothing(int id, String name, Size size, Material material, Color color) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.material = material;
        this.color = color;
    }

    public Clothing(int id, String name, Size size, Material material, Color color, double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.material = material;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", material=" + material +
                ", color=" + color +
                '}';
    }
}
