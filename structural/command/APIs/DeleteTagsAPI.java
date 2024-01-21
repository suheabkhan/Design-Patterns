package structural.command.APIs;

import structural.command.TagManager;
import structural.command.cmd.Command;
import structural.command.cmd.CommandFactory;
import structural.command.data.MatchType;
import structural.command.receiver.PartialMatchDeleter;
import structural.command.receiver.PerfectMatchDeleter;

import java.util.regex.Pattern;

public class DeleteTagsAPI {

    private final TagManager tagManager;

    public DeleteTagsAPI(TagManager tagManager) {
        this.tagManager = tagManager;
    }

    public void deleteTags(String tag, MatchType matchType){
        Command command = null;
        if(matchType.equals(MatchType.PERFECT)){
            command = CommandFactory.getPerfectMatchCommand(tag, new PerfectMatchDeleter());
        }
        else if(matchType.equals(MatchType.PARTIAL)){
            command = CommandFactory.getPartialMatchCommand(Pattern.compile(tag), new PartialMatchDeleter());
        }
        else{
            throw new IllegalArgumentException("Invalid match type");
        }
        this.tagManager.changeTags(command);
    }

}
