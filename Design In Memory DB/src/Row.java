import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Row {
    private final Map<Column,String> data;

    public Row(Set<Column> columns){
        this.data = new HashMap<>();
        for(Column col:columns){
            this.data.put(col,null);
        }
    }

    public void put(Column col, String val){
        if(!this.data.containsKey(col)){
            throw new RuntimeException("Column Doesnot Exist");
        }
        this.data.put(col,val);
    }

    public String getColumn(Column col){
        if(!this.data.containsKey(col)){
            throw new RuntimeException("Column Does not Exist");
        }
        return this.data.get(col);
    }

    public void printRow(){
        for(Map.Entry<Column,String> entry:data.entrySet()){
            System.out.println(entry.getKey().getName()+"::"+entry.getValue());
            System.out.println();
        }
    }


}
