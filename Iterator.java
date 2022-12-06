public class Iterator {
    
    public void GridPieceIncrease(int row, int column, GridPeice firstGridPeice)
    {
        System.out.println("in mehtod grid piece increase: ");
        System.out.println("the row is: " + row + " the column is: " + column);
        GridPeice iterator = firstGridPeice;
        while(true)
        {
            if(iterator.GetColumn() == column && iterator.GetRow() == row)
            {
                System.out.println("in the if statement: ");
                System.out.println("the row of grid is: " + iterator.GetRow() + " and the column of the grid piece is: " + iterator.GetColumn());
                iterator.IncreaseNumberOf();
                break;
            }
            iterator = iterator.GetNextGridPiece();
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
        System.out.println("****************************");
        System.out.println("in the move Up mehtod: ");

        int forNextRow = snake.GetRow();
        int forNextColumn = snake.GetColumn();

        snake.SetRow(snake.GetRow() - 1);
        GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);
        snake = snake.GetNextPiece();

        while(snake != null)
        {
            int nowRowForNext = snake.GetRow();
            int nowColumnForNext = snake.GetColumn();

            snake.SetRow(forNextRow);
            snake.SetColumn(forNextColumn);

            GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);

            forNextRow = nowRowForNext;
            forNextColumn = nowColumnForNext;

            snake = snake.GetNextPiece();
        }

    }

    private void MoveDown(SnakePiece snake, GridPeice firstGrid)
    {
        System.out.println("****************************");
        System.out.println("in the move down mehtod: ");

        int forNextRow = snake.GetRow();
        int forNextColumn = snake.GetColumn();

        snake.SetRow(snake.GetRow() + 1);
        GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);
        snake = snake.GetNextPiece();

        while(snake != null)
        {
            int nowRowForNext = snake.GetRow();
            int nowColumnForNext = snake.GetColumn();

            snake.SetRow(forNextRow);
            snake.SetColumn(forNextColumn);

            GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);

            forNextRow = nowRowForNext;
            forNextColumn = nowColumnForNext;

            snake = snake.GetNextPiece();
        }

    }

    private void MoveRight(SnakePiece snake, GridPeice firstGrid)
    {
        System.out.println("****************************");
        System.out.println("in the move right mehtod: ");

        int forNextRow = snake.GetRow();
        int forNextColumn = snake.GetColumn();

        snake.SetColumn(snake.GetColumn() + 1);
        GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid); //***** increasing the number of the grid */
        snake = snake.GetNextPiece();

        while(snake != null)
        {
            int nowRowForNext = snake.GetRow();
            int nowColumnForNext = snake.GetColumn();

            snake.SetRow(forNextRow);
            snake.SetColumn(forNextColumn);

            GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);

            forNextRow = nowRowForNext;
            forNextColumn = nowColumnForNext;

            snake = snake.GetNextPiece();
        }

    }

    private void MoveLeft(SnakePiece snake, GridPeice firstGrid)
    {
        System.out.println("****************************");
        System.out.println("in the move left mehtod: ");

        int forNextRow = snake.GetRow();
        int forNextColumn = snake.GetColumn();

        snake.SetColumn(snake.GetColumn() - 1);
        GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);
        snake = snake.GetNextPiece();

        while(snake != null)
        {
            int nowRowForNext = snake.GetRow();
            int nowColumnForNext = snake.GetColumn();

            snake.SetRow(forNextRow);
            snake.SetColumn(forNextColumn);

            GridPieceIncrease(snake.GetRow(), snake.GetColumn(), firstGrid);

            forNextRow = nowRowForNext;
            forNextColumn = nowColumnForNext;

            snake = snake.GetNextPiece();
        }

    }

    public void print(SnakePiece snake)
    {
        while(snake != null)
        {
            System.out.println(snake.GetRow() + " " + snake.GetColumn());
            snake = snake.GetNextPiece();
        }

        System.out.println("************************************************");
    }
}
