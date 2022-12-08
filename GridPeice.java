public class GridPeice 
{
    private int row;
    private int column;
    private int numberOf;
    private GridPeice nextGridPeice;

    public GridPeice(int row, int column)
    {
        this.row = row;
        this.column = column;
        nextGridPeice = null;
        numberOf = 0;
    }

    public void SetRow(int row)
    {
        this.row = row;
    }

    public int GetRow()
    {
        return row;
    }

    public void SetColumn(int column)
    {
        this.column = column;
    }

    public int GetColumn()
    {
        return column;
    }

    public void SetNextGridPiece(GridPeice nextGridPeice)
    {
        this.nextGridPeice = nextGridPeice;
    }

    public GridPeice GetNextGridPiece()
    {
        return nextGridPeice;
    }

    public void IncreaseNumberOf()
    {
        numberOf += 1;
    }

    public int GetNumberOf()
    {
        return numberOf;
    }

    public void SetNumberOf(int numberOf)
    {
        this.numberOf = numberOf;
    }
    
}
