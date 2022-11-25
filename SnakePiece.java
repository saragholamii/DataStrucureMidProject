public class SnakePiece
{
    private int row;
    private int column;
    private SnakePiece nextPiece;


    public SnakePiece(int row, int column)
    {
        this.row = row;
        this.column = column;
        nextPiece = null;
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

    public void SetNextPiece(SnakePiece nextPiece)
    {
        this.nextPiece = nextPiece;
    }

    public SnakePiece GetNextPiece()
    {
        return nextPiece;
    }
    
}