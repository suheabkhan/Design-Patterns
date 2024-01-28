import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Table {
    private final String name;
    private final Set<Column> columns;
    private final List<Row> rows;
    private final List<Constraint> constraints;

    public String getName() {
        return name;
    }

    public Set<Column> getColumns() {
        return columns;
    }

    public List<Row> getRows() {
        return rows;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public Table(String name, Set<Column> columns) {
        this.name = name;
        this.columns=columns;
        this.rows=new ArrayList<>();
        this.constraints = new ArrayList<>();
    }

    public void addColumn(String name,String colDescription){

    }

    public void deleteColumn(String colName){

    }

    public void addRow(Row row){
        //Before insertion of each row, check the constraints
        for(Constraint constraint:constraints){
            constraint.applyOnInsertRow(row);
        }
        this.rows.add(row);
    }

    public void deleteRow(Row row){
        if(!this.rows.contains(row)){
            throw new RuntimeException("Row doesnot exist");
        }
        for(Constraint constraint:constraints){
            constraint.applyOnDeleteRow(row);
        }
        this.rows.remove(row);
    }

    public void addConstraint(Constraint constraint){
        this.constraints.add(constraint);
    }

    public List<Constraint> getConstraintsByType(ConstraintType constraintType){
        List<Constraint> constraintsOfGivenType = new ArrayList<>();
        for(Constraint constraint:constraints){
            if(constraint.getConstraintType().equals(constraintType)){
                constraintsOfGivenType.add(constraint);
            }
        }
        return constraintsOfGivenType;
    }

    public void removeConstraints(ConstraintType constraintType,Table relatedTable){
     List<Constraint> removables = new ArrayList<>();
     for(Constraint constraint:constraints){
         if(constraint.getConstraintType().equals(constraintType) && constraint.isRelated(relatedTable)){
            removables.add(constraint);
         }
     }
     for(Constraint constraint:removables){
         constraints.remove(constraint);
     }
    }

    public Column getColumn(String colName){
        Column column = null;
        for(Column col:columns){
            if(col.getName().equals(colName)){
                column=col;
                break;
            }
        }
        if(column==null){
            throw new RuntimeException("Column Not Found");
        }
        return column;
    }

    public void removePrimaryKeyConstraint(ConstraintType constraintType){
        List<Constraint> removables = new ArrayList<>();
        for(Constraint constraint:constraints){
            if(constraint.getConstraintType().equals(constraintType)){
                removables.add(constraint);
            }
        }
        if(removables.isEmpty()) throw new RuntimeException("No Primary Key constraint found on the table");
        for(Constraint constraint:removables){
            constraints.remove(constraint);
        }
    }
}
