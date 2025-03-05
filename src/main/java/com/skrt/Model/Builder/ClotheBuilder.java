package com.skrt.Model.Builder;

import com.skrt.Model.Enum.Color;
import com.skrt.Model.Enum.Material;
import com.skrt.Model.Enum.Size;

public abstract class ClotheBuilder <T> {
    protected int id;
    protected String name;
    protected Size size;
    protected Material material;
    protected Color color;

    public ClotheBuilder<T> setId(int id) {
        this.id = id;
        return this;
    }

    public ClotheBuilder<T> setName(String name) {
        this.name = name;
        return this;
    }

    public ClotheBuilder<T> setSize(Size size) {
        this.size = size;
        return this;
    }

    public ClotheBuilder<T> setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public ClotheBuilder<T> setColor(Color color) {
        this.color = color;
        return this;
    }

    public abstract T build();


}
