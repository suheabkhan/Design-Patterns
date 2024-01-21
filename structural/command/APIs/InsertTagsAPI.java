package structural.command.APIs;

import structural.command.TagManager;
import structural.command.cmd.Command;
import structural.command.cmd.InsertTagCommand;
import structural.command.receiver.TagInserter;

public class InsertTagsAPI {

    public void insertTags(String tag){
        Command insetCommand = new InsertTagCommand(tag,new TagInserter());
        new TagManager(insetCommand).changeTags();
    }
}
