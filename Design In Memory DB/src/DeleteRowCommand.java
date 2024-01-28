import java.util.List;

public class DeleteRowCommand implements SQLCommand{

    private final String tableName;
    private final List<Row> rowsToBeDeleted;

    public DeleteRowCommand(String tableName, List<Row> rowsToBeDeleted) {
        this.tableName = tableName;
        this.rowsToBeDeleted = rowsToBeDeleted;
    }

    @Override
    public void execute() {
        Table table = Database.getInstance().getTable(tableName);
        for(Row row:rowsToBeDeleted){
            table.deleteRow(row);
        }
    }
}
