package structural.command.cmd;

import structural.command.receiver.TagInserter;

public class InsertTagCommand implements Command{

    private final String name;
    private final TagInserter tagInserter;

    public InsertTagCommand(String name, TagInserter tagInserter) {
        this.name = name;
        this.tagInserter = tagInserter;
    }

    @Override
    public void execute() {
       this.tagInserter.insert(name);
    }
}
