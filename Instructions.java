public class Instructions {

    private char instruction;
    private Instructions nextInstruction;

    public Instructions(char instruction)
    {
        this.instruction = instruction;
        nextInstruction = null;
    }

    public void SetNextInstruction(Instructions nextInstruction)
    {
        this.nextInstruction = nextInstruction;
    }

    public Instructions GetNextInstruction()
    {
        return nextInstruction;
    }

    public char GetInstruction()
    {
        return instruction;
    }
}
