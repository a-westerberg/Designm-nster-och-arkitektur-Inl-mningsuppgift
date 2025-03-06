package com.skrt.Model.Command;

import com.skrt.Model.Clothing;
import com.skrt.Model.Enum.Neck;
import com.skrt.Model.TShirt;

public class SetNeckCommand implements Command {
    private final Neck neck;

    public SetNeckCommand(Neck neck) {
        this.neck = neck;
    }

    @Override
    public void execute(Clothing clothing) {
        if(clothing instanceof TShirt tShirt){
            tShirt.setNeck(neck);
        }else {
            throw new IllegalArgumentException("NeckCommand can only use on TShirt");
        }
    }
}
