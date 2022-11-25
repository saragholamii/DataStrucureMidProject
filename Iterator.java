public class Iterator {
    
    public void GridPieceIncrease(int row, int column, GridPeice firstGridPeice)
    {
        GridPeice iterator = firstGridPeice;
        while(true)
        {
            if(iterator.GetColumn() == column && iterator.GetRow() == row)
            {
                iterator.IncreaseNumberOf();
                break;
            }
            iterator = firstGridPeice.GetNextGridPiece();
        }
    }
}
