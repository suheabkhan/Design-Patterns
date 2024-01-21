package structural.command.cmd;

import structural.command.receiver.PerfectMatchDeleter;
import structural.command.receiver.TagInserter;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleteCommand implements Command{

    private final String name;

    private final PerfectMatchDeleter perfectMatchDeleter;

    // The undo of perfectMatchDelete is insert
    private final TagInserter tagInserter;
    // We need to get all the list of tags that are deleted as well
    private final List<String> deletedTags;

    public PerfectMatchDeleteCommand(String name, PerfectMatchDeleter perfectMatchDeleter, TagInserter tagInserter) {
        this.name = name;
        this.perfectMatchDeleter = perfectMatchDeleter;
        this.tagInserter = tagInserter;
        this.deletedTags = new ArrayList<>();
    }

    @Override
    public void execute() {
        this.deletedTags.addAll(this.perfectMatchDeleter.delete(this.name));
    }

    @Override
    public void undo() {
        for(String deletedTagToInsert:deletedTags){
            this.tagInserter.insert(deletedTagToInsert);
        }
    }
}
