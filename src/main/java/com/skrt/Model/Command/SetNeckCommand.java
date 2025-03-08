package com.skrt.Model.Command;

import com.skrt.Model.Clothing;
import com.skrt.Model.Enum.Neck;
import com.skrt.Model.TShirt;

public class SetNeckCommand implements Command {
    private TShirt tShirt;
    private final Neck neck;

    public SetNeckCommand(TShirt tShirt,Neck neck) {
        this.tShirt = tShirt;
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
