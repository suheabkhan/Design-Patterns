
public class DropTableCommand implements SQLCommand{

    private final String tableName;

    public DropTableCommand(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void execute() {
        Database db = Database.getInstance();
        Table tableToBeDeleted = db.getTable(tableName);
        //Need to handle the foreign key constraints before deleting the table
        //If there is an child constraint, while deleting the parent table, then throw an exception
        // students table deletion checks
        if(!tableToBeDeleted.getConstraintsByType(ConstraintType.CHILDFOREIGNKEY).isEmpty()){
            throw new RuntimeException("Table cannot be deleted due to the foreign key constraints");
        }
        //Another scenario, if a marks table is being deleted, then its foreign key constraint on parentTable(students) should be deleted
        for(Table table:db.getTables()){
            table.removeConstraints(ConstraintType.CHILDFOREIGNKEY,tableToBeDeleted);
        }
        db.removeTable(tableName,tableToBeDeleted);
        System.out.println(tableName+ "is dropped");
    }
}
