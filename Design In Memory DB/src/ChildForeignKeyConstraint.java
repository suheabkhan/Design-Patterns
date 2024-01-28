import java.util.List;

public class ChildForeignKeyConstraint implements Constraint{


    /**
     1. let's say there is a relation between student table (parent) and marks table(child)
     2. Whenever a new student is inserted, there is no problem, but whenever a marks row inserted, without existence of \
     a student, marks row cannot be inserted. (This is a parentForeignKeyConstraint)
     3. Similarly, when a marks row is deleted, there is no problem, but whenever a student is deleted, we need to makesure
     all the related mark rows are also deleted. (This is a childForeignKeyConstraint)
     **/
    private final Table childTable;
    private final List<ColumnMapping> columnMappingList;

    public ChildForeignKeyConstraint(Table parentTable, List<ColumnMapping> columnMappingList) {
        this.childTable = parentTable;
        this.columnMappingList = columnMappingList;
    }


    @Override
    public void applyOnInsertRow(Row rowToBeInserted) {
        //No action
    }

    @Override
    public void applyOnUpdateRow(Row rowToBeUpdated) {

    }

    // Delelting a row in the parent table (student table)
    //Need to make sure no mapping exists in the child table
    @Override
    public void applyOnDeleteRow(Row rowToBeDeleted) {
        for(Row row: childTable.getRows()){
            boolean allMatch = true;
            for(ColumnMapping col:columnMappingList){
                  //childTables foreign column should not have any entry of parenttable column value
                  if(row.getColumn(col.getForeignTableCol())!=rowToBeDeleted.getColumn(col.getCurrentTableCol())){
                      allMatch=false;
                  }
            }
            if(allMatch) throw new RuntimeException("Child Foreign key violation");
        }
    }

    @Override
    public ConstraintType getConstraintType() {
        return ConstraintType.CHILDFOREIGNKEY;
    }

    @Override
    public boolean isRelated(Table relatedTable) {
        return relatedTable.getName().equals(childTable.getName());
    }
}
