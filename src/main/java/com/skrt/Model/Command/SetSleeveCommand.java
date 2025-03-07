package com.skrt.Model.Command;

import com.skrt.Model.Clothing;
import com.skrt.Model.Enum.Sleeve;
import com.skrt.Model.TShirt;

public class SetSleeveCommand implements Command {
    private TShirt TShirt;
    private final Sleeve sleeve;

    public SetSleeveCommand(TShirt tShirt, Sleeve sleeve) {
        this.TShirt = tShirt;
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
