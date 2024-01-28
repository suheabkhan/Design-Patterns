package behavioural.command.APIs;

import behavioural.command.TagManager;

public class UndoTagsAPI {
    private final TagManager tagManager;

    public UndoTagsAPI(TagManager tagManager) {
        this.tagManager = tagManager;
    }

    public void undoLastOperation(){
        this.tagManager.undoTags();
    }
}
