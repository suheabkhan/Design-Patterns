package structural.command.APIs;

import structural.command.TagManager;
import structural.command.cmd.Command;
import structural.command.cmd.InsertTagCommand;
import structural.command.cmd.UpdateTagCommand;
import structural.command.receiver.TagInserter;
import structural.command.receiver.UpdateTagInserter;

public class UpdateTagsAPI {

    public void insertTags(String oldTag,String newTag){
        Command updateCommand = new UpdateTagCommand(oldTag,newTag,new UpdateTagInserter());
        new TagManager(updateCommand).changeTags();
    }

}
