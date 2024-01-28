package behavioural.command;

import behavioural.command.APIs.DeleteTagsAPI;
import behavioural.command.APIs.InsertTagsAPI;
import behavioural.command.APIs.UndoTagsAPI;
import behavioural.command.APIs.UpdateTagsAPI;
import behavioural.command.data.MatchType;

public class TagSimulator {

    public static void main(String[] args) {
        TagManager tagManager = new TagManager();
        new InsertTagsAPI(tagManager).insertTags("subbu");
        new UpdateTagsAPI(tagManager).insertTags("subbu","muddu");
        new InsertTagsAPI(tagManager).insertTags("mujju");
        new DeleteTagsAPI(tagManager).deleteTags("muddu",MatchType.PERFECT);
        new DeleteTagsAPI(tagManager).deleteTags("mu.*", MatchType.PARTIAL);
        new UndoTagsAPI(tagManager).undoLastOperation();
        new UndoTagsAPI(tagManager).undoLastOperation();
        new UndoTagsAPI(tagManager).undoLastOperation();
        new UndoTagsAPI(tagManager).undoLastOperation();
    }
}
