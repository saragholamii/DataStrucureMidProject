import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Iterator it = new Iterator();
        
        int numberOfSnakePeices;
        int numberOfMoves;

        SnakePiece firstSnakePiece;
        SnakePiece previousSnakePiece;
        GridPeice firstGridPeice;
        GridPeice previousGridPeice;

        //***** creating the world with link list: */
        firstGridPeice = new GridPeice(0, 0);
        previousGridPeice = firstGridPeice;

        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 10; j++)
            {
                if(j == 0 && i == 0)   continue;
                GridPeice newPiece = new GridPeice(i, j);
                previousGridPeice.SetNextGridPiece(newPiece);
                previousGridPeice = newPiece;
            }

        
        System.out.println("enter the number of snake pieces: ");
        numberOfSnakePeices = sc.nextInt();

        //***** reading the first snake piece: */
        int row = sc.nextInt();
        int column = sc.nextInt();
        firstSnakePiece = new SnakePiece(row, column);
        previousSnakePiece = firstSnakePiece;
        it.GridPieceIncrease(row, column, firstGridPeice);  //***** this section will find the Grid piece with the same column and row, then increase the amount of host number */


        //***** reading other parts of the snake: */
        for(int i = 1; i < numberOfSnakePeices; i++)
        {
            System.out.println("enter the next row and column: ");
            row = sc.nextInt();
            column = sc.nextInt();

            SnakePiece newPiece = new SnakePiece(row, column);
            previousSnakePiece.SetNextPiece(newPiece);
            previousSnakePiece = newPiece;
            it.GridPieceIncrease(row, column, firstGridPeice);  //***** this section will find the Grid piece with the same column and row, then increase the amount of host number */
        }

        //***** reading moves: */
        Moves firstMove;
        Moves previousMove;

        System.out.println("enter the number of the moves: ");
        numberOfMoves = sc.nextInt();
        System.out.println("enter the move: ");
        firstMove = new Moves(sc.next().charAt(0));
        previousMove = firstMove;


        for(int i = 1; i < numberOfMoves; i++)
        {
            System.out.println("enter the next move: ");
            char newMove = sc.next().charAt(0);

            Moves newMoves = new Moves(newMove);
            previousMove.SetNextMove(newMoves);
            previousMove = newMoves;
        }

        //***** this part will print the moves agian:  */
        System.out.println("******************************");
        System.out.println("the moves are: ");
        previousMove = firstMove;
        System.out.println(previousMove.GetMove());
        while(previousMove.GetNextMove() != null)
        {
            previousMove = previousMove.GetNextMove();
            System.out.println(previousMove.GetMove());
        }


        System.out.println("calculating the moves: ");
        //***** moving the snake: */
        Moves move = firstMove;
        for(int i = 0; i < numberOfMoves; i++)
        {
            System.out.println("the move is " + move.GetMove());
            it.Move(move.GetMove(), firstSnakePiece, firstGridPeice);
            move = move.GetNextMove();
        }

        System.out.println("****************************************************************");

        it.print(firstSnakePiece);

        System.out.println("****************************************************************");

        GridPeice previousGrid = firstGridPeice;
        System.out.println("i: " + previousGrid.GetRow() + " j: " + previousGrid.GetColumn() + " number: " + previousGrid.GetNumberOf());

        while(previousGrid.GetNextGridPiece() != null)
        {
            previousGrid = previousGrid.GetNextGridPiece();
            if(previousGrid.GetNumberOf() != 0)
            System.out.println("i: " + previousGrid.GetRow() + " j: " + previousGrid.GetColumn() + " number: " + previousGrid.GetNumberOf());
        }
    }
}
