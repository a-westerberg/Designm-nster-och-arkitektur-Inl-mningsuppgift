package com.skrt.Model.Command;

import com.skrt.Model.Clothing;
import com.skrt.Model.Enum.Waistline;
import com.skrt.Model.Skirt;

public class SetWaistlineCommand implements Command {
    private final Waistline waistline;
    private Skirt skirt;

    public SetWaistlineCommand(Skirt skirt, Waistline waistline) {
        this.skirt = skirt;
        this.waistline = waistline;
    }

    @Override
    public void execute(Clothing clothing) {
        if(clothing instanceof Skirt skirt){
            skirt.setWaistline(waistline);
        } else {
            throw new IllegalArgumentException("WaistlineCommand can only use on Skirts");
        }
    }
}
