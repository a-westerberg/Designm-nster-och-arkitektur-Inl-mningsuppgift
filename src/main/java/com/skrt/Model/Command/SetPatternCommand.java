package com.skrt.Model.Command;

import com.skrt.Model.Clothing;
import com.skrt.Model.Enum.Pattern;
import com.skrt.Model.Skirt;

public class SetPatternCommand implements Command {
    private final Pattern pattern;
    private Skirt skirt;


    public SetPatternCommand(Skirt skirt, Pattern pattern) {
        this.skirt = skirt;
        this.pattern = pattern;
    }

    @Override
    public void execute(Clothing clothing) {
        if(clothing instanceof Skirt skirt){
            skirt.setPattern(pattern);
        } else {
            throw new IllegalArgumentException("PatternCommand can only use on Skirt");
        }
    }
}
