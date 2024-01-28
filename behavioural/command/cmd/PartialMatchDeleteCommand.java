package behavioural.command.cmd;

import behavioural.command.receiver.PartialMatchDeleter;
import behavioural.command.receiver.TagInserter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PartialMatchDeleteCommand implements Command{

    private final Pattern pattern;

    private final PartialMatchDeleter partialMatchDeleter;

    // The undo of partialMatchDelete is insert
    private final TagInserter tagInserter;
    // We need to get all the list of tags that are deleted as well
    private final List<String> deletedTags;

    public PartialMatchDeleteCommand(Pattern pattern, PartialMatchDeleter partialMatchDeleter, TagInserter tagInserter) {
        this.pattern = pattern;
        this.partialMatchDeleter = partialMatchDeleter;
        this.tagInserter = tagInserter;
        this.deletedTags= new ArrayList<>();
    }

    @Override
    public void execute() {
        this.deletedTags.addAll(this.partialMatchDeleter.delete(this.pattern));
    }

    @Override
    public void undo() {
        for(String deletedTagToInsert:deletedTags){
             this.tagInserter.insert(deletedTagToInsert);
        }
    }
}
