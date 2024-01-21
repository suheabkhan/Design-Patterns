package structural.command.receiver;

import structural.command.data.Store;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleter {

    public void delete(String name){
        //we dont want to mutate the data
        List<String> tags = new ArrayList<>();
        Store.getTags().forEach((tag)->{
           tags.add(tag);
        });
        for(String tag:tags){
            if(name.equals(tag)){
                Store.delete(tag);
            }
        }
    }
}
