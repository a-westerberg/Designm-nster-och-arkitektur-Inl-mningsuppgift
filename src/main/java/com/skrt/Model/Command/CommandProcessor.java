package com.skrt.Model.Command;

import com.skrt.Model.Clothing;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessor {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands(Clothing clothing) {
        for (Command command : commands) {
            command.execute(clothing);
        }
    }
}
