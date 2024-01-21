package structural.command.receiver;

import structural.command.data.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PartialMatchDeleter {

    public List<String> delete(Pattern pattern){
        //we dont want to mutate the data
        List<String> tags = new ArrayList<>();
        Store.getTags().forEach((tag)->{
            tags.add(tag);
        });
        List<String> deletedTags = new ArrayList<>();
        for(String tag:tags){
            if(pattern.matcher(tag).matches()){
                deletedTags.add(tag);
                Store.delete(tag);
            }
        }
        return deletedTags;
    }
}
