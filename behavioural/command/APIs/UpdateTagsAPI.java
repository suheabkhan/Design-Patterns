package behavioural.command.APIs;

import behavioural.command.TagManager;
import behavioural.command.cmd.Command;
import behavioural.command.cmd.UpdateTagCommand;
import behavioural.command.receiver.UpdateTagInserter;

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
