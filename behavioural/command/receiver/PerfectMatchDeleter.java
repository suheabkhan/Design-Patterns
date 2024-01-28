package behavioural.command.receiver;

import behavioural.command.data.Store;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleter {

    public List<String> delete(String name){
        //we dont want to mutate the data
        List<String> tags = new ArrayList<>();
        Store.getTags().forEach((tag)->{
           tags.add(tag);
        });
        List<String> deletedTags = new ArrayList<>();
        for(String tag:tags){
            if(name.equals(tag)){
                deletedTags.add(tag);
                Store.delete(tag);
            }
        }
        return deletedTags;
    }
}
