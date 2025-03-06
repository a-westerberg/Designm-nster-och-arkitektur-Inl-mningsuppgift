package com.skrt.Model.Command;

import com.skrt.Model.Clothing;
import com.skrt.Model.Enum.Lenght;
import com.skrt.Model.Pants;

public class SetLenghtCommand implements Command {
    private final Lenght lenght;

    public SetLenghtCommand(Lenght lenght) {
        this.lenght = lenght;
    }

    @Override
    public void execute(Clothing clothing) {
        if(clothing instanceof Pants pants){
            pants.setLenght(lenght);
        } else {
            throw new IllegalArgumentException("LenghtCommand can only use on Pants");
        }
    }
}
