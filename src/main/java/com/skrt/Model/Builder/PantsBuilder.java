package com.skrt.Model.Builder;

import com.skrt.Model.Enum.Fit;
import com.skrt.Model.Enum.Lenght;
import com.skrt.Model.Pants;

public class PantsBuilder extends ClotheBuilder<Pants>{
    private Fit fit;
    private Lenght lenght;

    public PantsBuilder setFit(Fit fit) {
        this.fit = fit;
        return this;
    }

    public PantsBuilder setLenght(Lenght lenght) {
        this.lenght = lenght;
        return this;
    }


    @Override
    public Pants build() {
        return new Pants(id, name, size, material, color, fit, lenght);
    }
}
