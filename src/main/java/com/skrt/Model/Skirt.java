package com.skrt.Model;

import com.skrt.Model.Enum.*;

public class Skirt {
    private int id;
    private String name;
    private Size size;
    private Material material;
    private Color color;
    private Waistline waistline;
    private Pattern pattern;

    public Skirt() {
    }

    public Skirt(int id, String name, Size size, Material material, Color color, Waistline waistline, Pattern pattern) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.material = material;
        this.color = color;
        this.waistline = waistline;
        this.pattern = pattern;
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

    public Waistline getWaistline() {
        return waistline;
    }

    public void setWaistline(Waistline waistline) {
        this.waistline = waistline;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Skirt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", material=" + material +
                ", color=" + color +
                ", waistline=" + waistline +
                ", pattern=" + pattern +
                '}';
    }
}
