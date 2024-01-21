package structural.command.APIs;

import structural.command.TagManager;

public class UndoTagsAPI {
    private final TagManager tagManager;

    public UndoTagsAPI(TagManager tagManager) {
        this.tagManager = tagManager;
    }

    public void undoLastOperation(){
        this.tagManager.undoTags();
    }
}
