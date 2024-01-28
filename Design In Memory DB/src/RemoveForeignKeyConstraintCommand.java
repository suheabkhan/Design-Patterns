
public class RemoveForeignKeyConstraintCommand implements SQLCommand
{
    public RemoveForeignKeyConstraintCommand(String parentTable, String childTable) {
        this.parentTable = parentTable;
        this.childTable = childTable;
    }

    private final String parentTable;
    private final String childTable;
    @Override
    public void execute() {
        Database db = Database.getInstance();
        Table parent = db.getTable(parentTable);
        Table child = db.getTable(childTable);
        // can have multiple checks
        parent.removeConstraints(ConstraintType.CHILDFOREIGNKEY,child);
        child.removeConstraints(ConstraintType.PARENTFOREIGNKEY,parent);
        System.out.println("removed foreign checks");
    }
}
