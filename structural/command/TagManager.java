package structural.command;

import structural.command.cmd.Command;

public class TagManager {

    private final Command command;

    public TagManager(Command command) {
        this.command = command;
    }

    public void changeTags(){
        this.command.execute();
    }

    //other methods which doesnot change
}
