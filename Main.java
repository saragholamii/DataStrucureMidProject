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

        // //***** this part will print the moves agian:  */
        // System.out.println("******************************");
        // System.out.println("the moves are: ");
        // previousMove = firstMove;
        // System.out.println(previousMove.GetMove());
        // while(previousMove.GetNextMove() != null)
        // {
        //     previousMove = previousMove.GetNextMove();
        //     System.out.println(previousMove.GetMove());
        // }


        System.out.println("calculating the moves: ");
        //***** moving the snake: */
        Moves move = firstMove;
        for(int i = 0; i < numberOfMoves; i++)
        {
            System.out.println("the move is " + move.GetMove());
            it.Move(move.GetMove(), firstSnakePiece, firstGridPeice);
            move = move.GetNextMove();
        }



        // System.out.println("****************************************************************");
        // it.print(firstSnakePiece);
        // System.out.println("****************************************************************");
        // System.out.println("printing the none-Zero ones: ");

        // //****** just printing the not zero grids */
        // GridPeice previousGrid = firstGridPeice;
        // System.out.println("i: " + previousGrid.GetRow() + " j: " + previousGrid.GetColumn() + " number: " + previousGrid.GetNumberOf());
        // previousGrid = previousGrid.GetNextGridPiece();

        // while(previousGrid != null)
        // {
        //     if(previousGrid.GetNumberOf() != 0)                 
        //     System.out.println("i: " + previousGrid.GetRow() + " j: " + previousGrid.GetColumn() + " number: " + previousGrid.GetNumberOf());
        //     previousGrid = previousGrid.GetNextGridPiece();
        // }

        // //****** creating the sorted grid list:  */

        // //****** searching for first not zero:  */
        // GridPeice firstNotZeroGrid = firstGridPeice;
        // while(true)
        // {
        //     if(firstNotZeroGrid.GetNumberOf() != 0)   break;
        //     firstNotZeroGrid = firstNotZeroGrid.GetNextGridPiece();
        // }

        // GridPeice theHeadOfTheSrtedGridList = new GridPeice(firstNotZeroGrid.GetRow(), firstGridPeice.GetColumn());
        // GridPeice previusSortedGridList = theHeadOfTheSrtedGridList;

        // firstNotZeroGrid = firstNotZeroGrid.GetNextGridPiece();
        // while(firstNotZeroGrid != null)
        // {
        //     if(firstNotZeroGrid.GetNumberOf() != 0)
        //     {
        //         previusSortedGridList.SetNextGridPiece(firstNotZeroGrid);
        //         previusSortedGridList = previusSortedGridList.GetNextGridPiece();
        //         previusSortedGridList.SetNextGridPiece(null);
        //     }
        //     firstNotZeroGrid = firstNotZeroGrid.GetNextGridPiece();
        // }

        // //****** printing the sorted list:  */
        // GridPeice aGridToGoThrowList = theHeadOfTheSrtedGridList;
        // while(aGridToGoThrowList != null)
        // {
        //     System.out.println("the grid row: " + aGridToGoThrowList.GetRow() + " column: " + aGridToGoThrowList.GetColumn() + " the number: " + aGridToGoThrowList.GetNumberOf());
        //     aGridToGoThrowList = aGridToGoThrowList.GetNextGridPiece();
        // }

        GridPeice previousGrid = firstGridPeice;
        while (previousGrid != null) 
        {
            if(previousGrid.GetNumberOf() != 0)     break;
            previousGrid = previousGrid.GetNextGridPiece();   
        }

        GridPeice HeadOfList = new GridPeice(previousGrid.GetRow(), previousGrid.GetColumn());
        HeadOfList.SetNumberOf(previousGrid.GetNumberOf());
        GridPeice HeadCopy = HeadOfList;

        previousGrid = previousGrid.GetNextGridPiece();
        while(previousGrid != null)
        {
            if(previousGrid.GetNumberOf() != 0)
            {
                GridPeice newGrid = new GridPeice(previousGrid.GetRow(), previousGrid.GetColumn());
                newGrid.SetNumberOf(previousGrid.GetNumberOf());
                HeadCopy.SetNextGridPiece(newGrid);
                HeadCopy = HeadCopy.GetNextGridPiece();
            }

            previousGrid = previousGrid.GetNextGridPiece();
        }

        // System.out.println("********************************");
        // System.out.println("printing the sorted list");
        // //***** printing the sorted list:  */
        // HeadCopy = HeadOfList;
        // while(HeadCopy != null)
        // {
        //     System.out.println("row: " + HeadCopy.GetRow() + " column: " + HeadCopy.GetColumn() + " the number: " + HeadCopy.GetNumberOf());
        //     HeadCopy = HeadCopy.GetNextGridPiece();
        // }

        // System.out.println("the head of the list row: " + HeadOfList.GetRow() + " column: " + HeadOfList.GetColumn() + "number: " + HeadOfList.GetNumberOf());

        //***** the number of the list:  */
        HeadCopy = HeadOfList;
        int theNumberOfTheSortedList = 0;
        while (HeadCopy != null) 
        {
            theNumberOfTheSortedList ++;
            HeadCopy = HeadCopy.GetNextGridPiece();
        }

        // System.out.println("the head of the list row after taking the number: " + HeadOfList.GetRow() + " column: " + HeadOfList.GetColumn() + "number: " + HeadOfList.GetNumberOf());
        // System.out.println("******************************");
        // System.out.println("the number of the list: " + theNumberOfTheSortedList);

        //***** turn the None-ZeroLinklistGrid to an 3D array to sort it: */
        int[][] sortedGrid = new int[theNumberOfTheSortedList][3];
        int i = 0;
        HeadCopy = HeadOfList;
        while (HeadCopy != null) 
        {
            sortedGrid[i][0] = HeadCopy.GetRow();
            sortedGrid[i][1] = HeadCopy.GetColumn();
            sortedGrid[i][2] = HeadCopy.GetNumberOf();
            HeadCopy = HeadCopy.GetNextGridPiece();  
            i++;  
        }

        // System.out.println("*************************");
        // System.out.println("printing the array: ");
        // for(i = 0; i < theNumberOfTheSortedList; i++)
        //     System.out.println("the row : " + sortedGrid[i][0] + " the column: " + sortedGrid[i][1] + " the number: " + sortedGrid[i][2]);

        //***** sort it: */
        MergSort ms = new MergSort();
        ms.MergSortTheList(sortedGrid, 0, sortedGrid.length - 1);

        System.out.println("***********************************************");
        System.out.println("answer will be: ");
        for(i = 0; i < theNumberOfTheSortedList; i++)
            System.out.println("the row : " + sortedGrid[i][0] + " the column: " + sortedGrid[i][1] + " the number: " + sortedGrid[i][2]);



        

        

        


    }
}
