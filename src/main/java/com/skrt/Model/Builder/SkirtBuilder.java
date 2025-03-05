package com.skrt.Model.Builder;

import com.skrt.Model.Enum.Pattern;
import com.skrt.Model.Enum.Waistline;
import com.skrt.Model.Skirt;

public class SkirtBuilder extends ClotheBuilder<Skirt>{
    private Waistline waistline;
    private Pattern pattern;

    public SkirtBuilder setWaistline(Waistline waistline) {
        this.waistline = waistline;
        return this;
    }

    public SkirtBuilder setPattern(Pattern pattern) {
        this.pattern = pattern;
        return this;
    }


    @Override
    public Skirt build() {
        return new Skirt(id, name, size, material, color, waistline, pattern);
    }
}
