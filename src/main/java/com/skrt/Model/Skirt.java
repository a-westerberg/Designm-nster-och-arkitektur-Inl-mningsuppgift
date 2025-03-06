package com.skrt.Model;

import com.skrt.Model.Enum.*;

public class Skirt extends Clothing{
    private Waistline waistline;
    private Pattern pattern;

    public Skirt() {
    }

    public Skirt(int id, String name, Size size, Material material, Color color, Waistline waistline, Pattern pattern) {
        super(id, name, size, material, color);
        this.waistline = waistline;
        this.pattern = pattern;
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
        return super.toString() + ", waistline=" + waistline + ", pattern=" + pattern + "}";
    }
}
