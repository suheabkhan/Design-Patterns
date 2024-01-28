

public class RemovePrimaryKeyConstraintCommand implements SQLCommand{
    private final String tableName;

    public RemovePrimaryKeyConstraintCommand(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void execute() {
     Table table = Database.getInstance().getTable(tableName);
     table.removePrimaryKeyConstraint(ConstraintType.PRIMARYKEY);
    }
}
