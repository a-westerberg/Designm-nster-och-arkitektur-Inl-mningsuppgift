package com.skrt.Model.Builder;

import com.skrt.Model.Enum.Neck;
import com.skrt.Model.Enum.Sleeve;
import com.skrt.Model.TShirt;

public class TShirtBuilder extends ClotheBuilder<TShirt> {
    private Sleeve sleeve;
    private Neck neck;

    public TShirtBuilder setSleeve(Sleeve sleeve) {
        this.sleeve = sleeve;
        return this;
    }

    public TShirtBuilder setNeck(Neck neck) {
        this.neck = neck;
        return this;
    }


    @Override
    public TShirt build() {
        return new TShirt(id, name, size, material, color, sleeve, neck);
    }
}
