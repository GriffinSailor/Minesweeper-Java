public class Board extends Square
{
    // How many rows/columns the board has
    int boardSize;
    // How many reandomly placed bombs are on the board
    int bombCount;
    // How many squares have been revealed to the user (used in determine a Win for the player)
    int revealedSquares;
    // The board itself
    Square [][] board;

    // Primary Constructor
    public Board (int boardSize, int bombCount, int blockedRow, int blockedCol)
    {
        this.boardSize = boardSize;
        this.bombCount = bombCount;
        revealedSquares = 0;
    }
    
    // Default Constructor - again, it gets rid of an error when the class is extended in another
    public Board ()
    {
        
    }
}
