import java.util.List;

public class ParentForeignKeyConstraint implements Constraint{


    /**
    1. let's say there is a relation between student table (parent) and marks table(child)
    2. Whenever a new student is inserted, there is no problem, but whenever a marks row inserted, without existence of \
       a student, marks row cannot be inserted. (This is a parentForeignKeyConstraint)
    3. Similarly, when a marks row is deleted, there is no problem, but whenever a student is deleted, we need to makesure
       all the related mark rows are also deleted. (This is a childForeignKeyConstraint)
     **/
    private final Table parentTable;
    //stores the mapping between columnNames of studentTable (ROLLNUMBER) and marksTable (SID)
    private final List<ColumnMapping> columnMappingList;

    public ParentForeignKeyConstraint(Table parentTable, List<ColumnMapping> columnMappingList) {
        this.parentTable = parentTable;
        this.columnMappingList = columnMappingList;
    }

    // whenever a new row is being added in the marks table, check if the rowbeing inserted has a valid value in parentTable
    @Override
    public void applyOnInsertRow(Row rowToBeInserted) {
       for(Row row:parentTable.getRows()){
           boolean allMatch = true;
           //if atleast one match is found then return
           for(ColumnMapping columnMapping:columnMappingList){
               if(row.getColumn(columnMapping.getForeignTableCol()) != rowToBeInserted.getColumn(columnMapping.getCurrentTableCol())){
                   allMatch=false;
               }
           }
           if(allMatch) return;
       }
       throw new RuntimeException("Parent Foreign Key violated");
    }

    @Override
    public void applyOnUpdateRow(Row rowToBeUpdated) {

    }

    @Override
    public void applyOnDeleteRow(Row rowToBeDeleted) {
      //no action
    }

    @Override
    public ConstraintType getConstraintType() {
        return ConstraintType.PARENTFOREIGNKEY;
    }

    @Override
    public boolean isRelated(Table relatedTable) {
        return relatedTable.getName().equals(parentTable.getName());
    }
}
