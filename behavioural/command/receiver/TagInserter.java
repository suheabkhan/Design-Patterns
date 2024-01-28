package behavioural.command.receiver;

import behavioural.command.data.Store;

public class TagInserter {

    public void insert(String name){
        Store.insert(name);
    }
}
