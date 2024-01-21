package structural.command;

import structural.command.cmd.Command;

import java.util.Stack;

public class TagManager {

    Stack<Command> commandStack;

    public TagManager() {
        commandStack = new Stack<>();
    }

    public void changeTags(Command command){
        commandStack.push(command);
        command.execute();
        System.out.println("stack size is::"+commandStack.size());
    }

    public void undoTags(){
        if(commandStack.isEmpty()){
            throw new RuntimeException("No Previous commands");
        }
        Command lastCommand = commandStack.pop();
        lastCommand.undo();
    }

    //other methods which doesnot change
}
