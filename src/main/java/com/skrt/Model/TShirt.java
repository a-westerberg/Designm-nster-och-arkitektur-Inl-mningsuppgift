package com.skrt.Model;

import com.skrt.Model.Enum.*;

public class TShirt {
    private int id;
    private String name;
    private  Size size;
    private  Material material;
    private  Color color;
    private  Sleeve sleeve;
    private  Neck neck;

    public TShirt() {
    }

    public TShirt(int id, String name,Size size, Material material, Color color, Sleeve sleeve, Neck neck) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.material = material;
        this.color = color;
        this.sleeve = sleeve;
        this.neck = neck;
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

    @Override
    public String toString() {
        return "TShirt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", material=" + material +
                ", color=" + color +
                ", sleeve=" + sleeve +
                ", neck=" + neck +
                '}';
    }
}
