package structural.command.APIs;

import structural.command.TagManager;
import structural.command.cmd.Command;
import structural.command.cmd.UpdateTagCommand;
import structural.command.receiver.UpdateTagInserter;

public class UpdateTagsAPI {

    private final TagManager tagManager;

    public UpdateTagsAPI(TagManager tagManager) {
        this.tagManager = tagManager;
    }

    public void insertTags(String oldTag,String newTag){
        Command updateCommand = new UpdateTagCommand(oldTag,newTag,new UpdateTagInserter());
        this.tagManager.changeTags(updateCommand);
    }


}
