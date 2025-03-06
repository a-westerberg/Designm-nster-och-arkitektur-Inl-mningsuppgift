package com.skrt.Model.Command;

import com.skrt.Model.Clothing;
import com.skrt.Model.Enum.Sleeve;
import com.skrt.Model.TShirt;

public class SetSleeveCommand implements Command {
    private final Sleeve sleeve;

    public SetSleeveCommand(Sleeve sleeve) {
        this.sleeve = sleeve;
    }

    @Override
    public void execute(Clothing clothing) {
        if (clothing instanceof TShirt tShirt){
            tShirt.setSleeve(sleeve);
        }else {
            throw new IllegalArgumentException("SleeveCommand can only use on TShirt");
        }
    }
}
