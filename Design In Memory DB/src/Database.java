import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
 //since we are going to have one DB, make this is a singleton
 // SINGLETON
    private static Database INSTANCE;
    public static Database getInstance(){
        if(INSTANCE==null){
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    //Maintain list of tables
    private final Map<String,Table> tables;
    private Database(){
        this.tables = new HashMap<String,Table>();
    }
    //CRUD OPERATIONS
    public Table getTable(String tableName){
       if(!tables.containsKey(tableName)){
            throw new RuntimeException("Invalid Table Name");
       }
       return tables.get(tableName);
    }

    public void putTable(String tableName,Table table){
        if(tables.containsKey(tableName)){
            throw new RuntimeException("Table already exists");
        }
        tables.put(tableName,table);
    }

    public void removeTable(String tableName,Table table){
        if(!tables.containsKey(tableName)){
            throw new RuntimeException("Table doesnot exists");
        }
        tables.remove(tableName);
    }

    public List<Table> getTables (){
        List<Table> tablesList = new ArrayList<>();
        for(Map.Entry<String,Table> entry:tables.entrySet()){
            tablesList.add(entry.getValue());
        }
        return tablesList;
    }

}
