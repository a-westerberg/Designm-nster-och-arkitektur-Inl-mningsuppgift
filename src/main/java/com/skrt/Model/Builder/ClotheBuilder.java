/*package com.skrt.Model.Builder;

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
        if(id < 0)
            throw new BuildException("ID", id);
        this.id = id;
        return this;
    }

    public ClotheBuilder<T> setName(String name) {
        if(name == null)
            throw new BuildException("Name", name);
        this.name = name;
        return this;
    }

    public ClotheBuilder<T> setSize(Size size) {
        if(size == null)
            throw new BuildException("Size", size);
        this.size = size;
        return this;
    }

    public ClotheBuilder<T> setMaterial(Material material) {
        if(material == null)
            throw new BuildException("Material", material);
        this.material = material;
        return this;
    }

    public ClotheBuilder<T> setColor(Color color) {
        if(color == null)
            throw new BuildException("Color", color);
        this.color = color;
        return this;
    }

    public abstract T build();


}*/
