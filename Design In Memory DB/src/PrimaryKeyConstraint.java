import java.util.Set;

public class PrimaryKeyConstraint implements Constraint{

    private final Table table;
    private final Set<Column> primaryKeys;

    public PrimaryKeyConstraint(Table table, Set<Column> primaryKeys) {
        this.table = table;
        this.primaryKeys = primaryKeys;
    }

    @Override
    public void applyOnInsertRow(Row rowToBeInserted) {
        // Atleast one column should be different in the primary key combinations in  all rows
          for(Row row:table.getRows()){
              boolean allMatch = true;
              for(Column col:primaryKeys){
                  if(!row.getColumn(col).equals(rowToBeInserted.getColumn(col))){
                      allMatch=false;
                  }
              }
              if(allMatch){
                  throw new RuntimeException("PrimaryKey is violated");
              }
          }
    }

    @Override
    public void applyOnUpdateRow(Row rowToBeUpdated) {

    }

    @Override
    public void applyOnDeleteRow(Row rowToBeDeleted) {

    }

    @Override
    public ConstraintType getConstraintType() {
        return ConstraintType.PRIMARYKEY;
    }
    // for primary key, no need of foreignKeyConstraint
    @Override
    public boolean isRelated(Table relatedTable) {
        return false;
    }
}
