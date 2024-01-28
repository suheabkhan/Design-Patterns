import java.util.ArrayList;
import java.util.List;

public class AddForeignKeyConstraintCommand implements SQLCommand{
    private final String parentTable;
    private final String childTable;
    private final List<ColumnNameMapping> columnNameMappingList;

    public AddForeignKeyConstraintCommand(String parentTable, String childTable, List<ColumnNameMapping> columnNameMappingList) {
        this.parentTable = parentTable;
        this.childTable = childTable;
        this.columnNameMappingList = columnNameMappingList;
    }

    @Override
    public void execute() {
       Database db = Database.getInstance();
       Table parent = db.getTable(parentTable);
       Table child = db.getTable(childTable);
       List<ColumnMapping> childColumnMapping = new ArrayList<>();
       List<ColumnMapping> parentColumnMapping = new ArrayList<>();
       for(ColumnNameMapping columnNameMapping:columnNameMappingList){
           ColumnMapping columnMappingForChild = new ColumnMapping(
                   child.getColumn(columnNameMapping.getChildColumn()),
                   parent.getColumn(columnNameMapping.getParentColumn())
           );
           childColumnMapping.add(columnMappingForChild);
           ColumnMapping columnMappingForParent = new ColumnMapping(
                   parent.getColumn(columnNameMapping.getParentColumn()),
                   child.getColumn(columnNameMapping.getChildColumn())
           );
           parentColumnMapping.add(columnMappingForParent);
       }
       // on parent table, need to add the constraints of child table
       parent.addConstraint(new ChildForeignKeyConstraint(child,parentColumnMapping));
       //on child table, need to add the constraints of parent table
       child.addConstraint(new ParentForeignKeyConstraint(parent,childColumnMapping));
    }
}
