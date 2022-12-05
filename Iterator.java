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

    public void Move(char move, SnakePiece snake, GridPeice firstGrid)
    {
        if(move == 'U')             MoveUp(snake, firstGrid);
        else if(move == 'D')        MoveDown(snake, firstGrid);
        else if(move == 'R')        MoveRight(snake, firstGrid);
        else if(move == 'L')        MoveLeft(snake, firstGrid);
    }

    private void MoveUp(SnakePiece snake, GridPeice firstGrid)
    {
        SnakePiece previuPiece;

        snake.SetRow(snake.GetRow() + 1);
        GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);

        previuPiece = snake;
        snake = snake.GetNextPiece();

        while(snake != null)
        {
           snake.SetRow(previuPiece.GetRow());
           snake.SetColumn(previuPiece.GetColumn());
           GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);
           previuPiece = snake;
           snake = snake.GetNextPiece();
        }
    }

    private void MoveDown(SnakePiece snake, GridPeice firstGrid)
    {
        SnakePiece previuPiece;

        snake.SetRow(snake.GetRow() - 1);
        GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);

        previuPiece = snake;
        snake = snake.GetNextPiece();

        while(snake != null)
        {
           snake.SetRow(previuPiece.GetRow());
           snake.SetColumn(previuPiece.GetColumn());
           GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);
           previuPiece = snake;
           snake = snake.GetNextPiece();
        }
    }

    private void MoveRight(SnakePiece snake, GridPeice firstGrid)
    {
        SnakePiece previuPiece;

        snake.SetColumn(snake.GetColumn() + 1);
        GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);

        previuPiece = snake;
        snake = snake.GetNextPiece();

        while(snake != null)
        {
           snake.SetRow(previuPiece.GetRow());
           snake.SetColumn(previuPiece.GetColumn());
           GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);
           previuPiece = snake;
           snake = snake.GetNextPiece();
        }
    }

    private void MoveLeft(SnakePiece snake, GridPeice firstGrid)
    {
        SnakePiece previuPiece;

        snake.SetColumn(snake.GetColumn() - 1);
        GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);

        previuPiece = snake;
        snake = snake.GetNextPiece();

        while(snake != null)
        {
           snake.SetRow(previuPiece.GetRow());
           snake.SetColumn(previuPiece.GetColumn());
           GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);
           previuPiece = snake;
           snake = snake.GetNextPiece();
        }
    }
}
