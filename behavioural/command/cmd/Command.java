package behavioural.command.cmd;


/**
 *  Whenever there is a requirement where there are multiple operations are performed, then can choose command pattern
 *  For example, insertion of a tag, deletion of a tag, updation of a tag, getAllTags .. Here each operation is nothing
 *  but a command that gets executed.
 *  Similarly, to perform the calculator operations, we can use command patterns
 *  -> For this example, create a tag manager which supports insertion of a tag/comment,
 *   -> Update the comment/tag
 *   -> Delete the comment/tag
 * -> Delete the comment with regex
 * -> get all tags
 **/

/**
* Command Pattern basically, has an interface called command, which has execute() method, that doesnot take any args nor returns any
 * THis command will be inherited by all the different classes, so that can vary and scale independently.
 * Even if a new opertion to be added, then just add one more implementation of command class
 *
 * public class TagManager{
 *
 *     void insertTag(String tag){}
 *
 *     void deleteTag(String tag){}
 *
 *     void updateTag(String oldTag,String newTag){}
 * }
 * The problem with the above design is, if a new operation is to be supported, then this class needs to be modified.
 * Therefore, viloates open for extension and closed for modification principle, that's why command pattern is the best
 *
 *
 *
 *   Flow
 *   MAIN (SIMULATOR CLASS) -> API's (which will get the command to delete, uses factory) -> Invoker (Polymorphic type,which will call execute())->
 *   Concrete Command -> Receiver
* **/
public interface Command {
    // The execute method inside each command, should be very minimal, and should not perform bulky operation.
    // Create a receiver class, which performs all the underlying logic and this execute method just calls that
    void execute();

    void undo();
}
