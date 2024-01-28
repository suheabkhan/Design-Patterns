import java.util.List;

public class InsertRowCommand implements SQLCommand{

    private final String tableName;
    private final List<KeyValuePair> columnNametoValue;

    public InsertRowCommand(String tableName, List<KeyValuePair> columnNametoValue) {
        this.tableName = tableName;
        this.columnNametoValue = columnNametoValue;
    }

    @Override
    public void execute() {
     Table table = Database.getInstance().getTable(tableName);
     Row row = new Row(table.getColumns());
     for(KeyValuePair rowValues:columnNametoValue){
         row.put(table.getColumn(rowValues.getKey()),rowValues.getValue());
     }
     table.addRow(row);
     System.out.println("Row inserted successfully");
    }
}
