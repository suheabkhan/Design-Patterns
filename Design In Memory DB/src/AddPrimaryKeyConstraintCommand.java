import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddPrimaryKeyConstraintCommand implements SQLCommand{

     private final String tableName;
     private final List<String> columnNames;

    public AddPrimaryKeyConstraintCommand(String tableName, List<String> columnNames) {
        this.tableName = tableName;
        this.columnNames = columnNames;
    }

    @Override
    public void execute() {
       Table table=Database.getInstance().getTable(tableName);
       Set<Column> primarykeyColumns = new HashSet<>();
       for(String col:columnNames){
           primarykeyColumns.add(table.getColumn(col));
       }
       List<Constraint> constraints = table.getConstraintsByType(ConstraintType.PRIMARYKEY);
       if(!constraints.isEmpty()){
           throw new RuntimeException("primary key already exists");
       }
        //TODO iterate on rows and verify uniqueness
        table.addConstraint(new PrimaryKeyConstraint(table,primarykeyColumns));
        System.out.println("Primary key constraint is added");
    }
}
