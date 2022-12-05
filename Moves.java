public class Moves {

    private char move;
    private Moves nextMove;

    public Moves(char move)
    {
        this.move = move;
        nextMove = null;
    }

    public void SetNextMove(Moves nextMove)
    {
        this.nextMove = nextMove;
    }

    public Moves GetNextMove()
    {
        return nextMove;
    }

    public char GetMove()
    {
        return move;
    }
}
