package behavioural.command.cmd;

import behavioural.command.receiver.UpdateTagInserter;

public class UpdateTagCommand implements Command{


    private final String oldTag;
    private final String newTag;

    private final UpdateTagInserter updateTagInserter;

    public UpdateTagCommand(String oldTag, String newTag, UpdateTagInserter updateTagInserter) {
        this.oldTag = oldTag;
        this.newTag = newTag;
        this.updateTagInserter = updateTagInserter;
    }

    @Override
    public void execute() {
          this.updateTagInserter.update(oldTag,newTag);
    }

    @Override
    public void undo() {
      this.updateTagInserter.update(newTag,oldTag);
    }
}
