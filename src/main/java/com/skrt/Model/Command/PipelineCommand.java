package com.skrt.Model.Command;

import com.skrt.Model.Clothing;

import java.util.ArrayList;
import java.util.List;

public class PipelineCommand {
    private List<Command> pipeline = new ArrayList<>();

    public void addCommand(Command command){
        pipeline.add(command);
    }

    public void execute(Clothing clothing){
        for (Command command : pipeline) {
            command.execute(clothing);
        }
        pipeline.clear();
    }

}
