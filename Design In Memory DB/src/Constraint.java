


public interface Constraint {

    void applyOnInsertRow(Row rowToBeInserted);
    void applyOnUpdateRow(Row rowToBeUpdated);
    void applyOnDeleteRow(Row rowToBeDeleted);
    ConstraintType getConstraintType();
    boolean isRelated(Table relatedTable);
}
