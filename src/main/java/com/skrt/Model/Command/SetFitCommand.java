package com.skrt.Model.Command;

import com.skrt.Model.Clothing;
import com.skrt.Model.Enum.Fit;
import com.skrt.Model.Pants;

public class SetFitCommand implements Command {
    private Pants pants;
    private final Fit fit;

    public SetFitCommand(Pants pants, Fit fit) {
        this.pants = pants;
        this.fit = fit;
    }

    @Override
    public void execute(Clothing clothing) {
        if(clothing instanceof Pants pants){
            pants.setFit(fit);
        } else {
            throw new IllegalArgumentException("FitCommand can only use on Pants");
        }
    }
}
