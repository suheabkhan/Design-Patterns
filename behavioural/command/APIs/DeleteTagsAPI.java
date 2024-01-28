package behavioural.command.APIs;

import behavioural.command.TagManager;
import behavioural.command.cmd.Command;
import behavioural.command.cmd.CommandFactory;
import behavioural.command.data.MatchType;
import behavioural.command.receiver.PartialMatchDeleter;
import behavioural.command.receiver.PerfectMatchDeleter;

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
