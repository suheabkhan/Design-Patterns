package behavioural.command.APIs;

import behavioural.command.TagManager;
import behavioural.command.cmd.Command;
import behavioural.command.cmd.InsertTagCommand;
import behavioural.command.receiver.PerfectMatchDeleter;
import behavioural.command.receiver.TagInserter;

public class InsertTagsAPI {

    private final TagManager tagManager;

    public InsertTagsAPI(TagManager tagManager) {
        this.tagManager = tagManager;
    }

    public void insertTags(String tag){
        Command insertCommand = new InsertTagCommand(tag,new TagInserter(), new PerfectMatchDeleter());
        this.tagManager.changeTags(insertCommand);
    }

}
