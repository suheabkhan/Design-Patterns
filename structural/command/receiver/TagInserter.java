package structural.command.receiver;

import structural.command.data.Store;

import java.util.ArrayList;
import java.util.List;

public class TagInserter {

    public void insert(String name){
        Store.insert(name);
    }
}
