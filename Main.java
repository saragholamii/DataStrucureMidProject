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
                if(j == 0)   continue;
                GridPeice newPiece = new GridPeice(i, j);
                previousGridPeice.SetNextGridPiece(newPiece);
                previousGridPeice = newPiece;
            }

        
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
            row = sc.nextInt();
            column = sc.nextInt();

            SnakePiece newPiece = new SnakePiece(row, column);
            previousSnakePiece.SetNextPiece(newPiece);
            previousSnakePiece = newPiece;
            it.GridPieceIncrease(row, column, firstGridPeice);
        }

        //***** reading instructions: */
        numberOfMoves = sc.nextInt();
        
    }
}
