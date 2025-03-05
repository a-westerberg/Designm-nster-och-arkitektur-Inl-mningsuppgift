package com.skrt.Model;

import com.skrt.Model.Enum.*;

public class Pants {
    private int id;
    private String name;
    private Size size;
    private Material material;
    private Color color;
    private Fit fit;
    private Lenght lenght;

    public Pants() {
    }

    public Pants(int id, String name,Size size, Material material, Color color, Fit fit, Lenght lenght) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.material = material;
        this.color = color;
        this.fit = fit;
        this.lenght = lenght;
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
        return "Pants{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", material=" + material +
                ", color=" + color +
                ", fit=" + fit +
                ", lenght=" + lenght +
                '}';
    }
}
