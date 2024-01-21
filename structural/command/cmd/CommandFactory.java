package structural.command.cmd;

import structural.command.receiver.PartialMatchDeleter;
import structural.command.receiver.PerfectMatchDeleter;
import structural.command.receiver.TagInserter;

import java.util.regex.Pattern;

public class CommandFactory {

    private CommandFactory(){}

    public static Command getPartialMatchCommand(Pattern pattern, PartialMatchDeleter partialMatchDeleter){
        return new PartialMatchDeleteCommand(pattern,partialMatchDeleter, new TagInserter());
    }

    public static Command getPerfectMatchCommand(String name, PerfectMatchDeleter perfectMatchDeleter){
        return new PerfectMatchDeleteCommand(name,perfectMatchDeleter, new TagInserter());
    }
}
