package structural.command.APIs;

import structural.command.TagManager;
import structural.command.cmd.Command;
import structural.command.cmd.InsertTagCommand;
import structural.command.receiver.PerfectMatchDeleter;
import structural.command.receiver.TagInserter;

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
