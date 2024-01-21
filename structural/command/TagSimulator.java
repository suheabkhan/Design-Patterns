package structural.command;

import structural.command.APIs.DeleteTagsAPI;
import structural.command.APIs.InsertTagsAPI;
import structural.command.APIs.UpdateTagsAPI;
import structural.command.data.MatchType;

public class TagSimulator {

    public static void main(String[] args) {
        new InsertTagsAPI().insertTags("subbu");
        new UpdateTagsAPI().insertTags("subbu","muddu");
        new InsertTagsAPI().insertTags("mujju");
        new DeleteTagsAPI().deleteTags("mu",MatchType.PERFECT);
        new DeleteTagsAPI().deleteTags("mu.*", MatchType.PARTIAL);
    }
}
