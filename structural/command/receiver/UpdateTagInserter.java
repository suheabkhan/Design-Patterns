package structural.command.receiver;

import structural.command.data.Store;

import java.util.ArrayList;
import java.util.List;

public class UpdateTagInserter {

    public void update(String oldTag,String newtag){
        //we dont want to mutate the data
        List<String> tags = new ArrayList<>();
        Store.getTags().forEach((tag)->{
            tags.add(tag);
        });
        for(String tag:tags){
            if(tag.equals(oldTag)){
              Store.delete(oldTag);
              Store.insert(newtag);
            }
        }
    }
}
