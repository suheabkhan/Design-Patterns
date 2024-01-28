public class ColumnMapping {

    private final Column foreignTableCol;

    private final Column currentTableCol;

    public ColumnMapping(Column foreignTableCol, Column currentTableCol) {
        this.foreignTableCol = foreignTableCol;
        this.currentTableCol = currentTableCol;
    }

    public Column getForeignTableCol() {
        return foreignTableCol;
    }

    public Column getCurrentTableCol() {
        return currentTableCol;
    }


}
