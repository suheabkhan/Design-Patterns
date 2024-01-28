package behavioural.command.cmd;

import behavioural.command.receiver.PerfectMatchDeleter;
import behavioural.command.receiver.TagInserter;

public class InsertTagCommand implements Command{

    private final String name;
    private final TagInserter tagInserter;

    //undo of insertion is deletion of tag
    private final PerfectMatchDeleter perfectMatchDeleter;

    public InsertTagCommand(String name, TagInserter tagInserter, PerfectMatchDeleter perfectMatchDeleter) {
        this.name = name;
        this.tagInserter = tagInserter;
        this.perfectMatchDeleter = perfectMatchDeleter;
    }

    @Override
    public void execute() {
       this.tagInserter.insert(name);
    }

    @Override
    public void undo(){
       this.perfectMatchDeleter.delete(name);
    }
}
