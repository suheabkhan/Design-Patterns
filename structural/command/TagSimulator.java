package structural.command;

import structural.command.APIs.DeleteTagsAPI;
import structural.command.APIs.InsertTagsAPI;
import structural.command.APIs.UndoTagsAPI;
import structural.command.APIs.UpdateTagsAPI;
import structural.command.data.MatchType;

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
