import java.util.Random;

/* Object Description
A board object is primarily focused on a 2D array of Squares simply named 'board'.
Outside of that there is an int parmeter for boardSize (size 10 means a 10x10 board) as well
as an int parameter for bombCount (how many bombs will be randomly placed). 

The first move Coordinate is to allow the board to protect the players first move and 
avoid an immediate game over
*/
public class Board 
{
    int boardSize;
    int bombCount;
    int revealedSquares;
    Square[][] board;

    // Primary Constructor
    public Board (int boardSize, int bombCount, Coordinate firstMove)
    {
        this.board = new Square[boardSize][boardSize];
        this.boardSize = boardSize;
        this.bombCount = bombCount;
        revealedSquares = 0;
        Coordinate[] touchingCords = firstMove.touchingCoordinates(boardSize);

        // Initialize the board
        for (int i = 0; i < boardSize; i++)
        {
            for (int k = 0; k < boardSize; k++)
            {
                board[i][k] = new Square();
            }
        }

        // Random bomb coordinates generation while ensuring a safe first move for the user
        Random num = new Random();
        int bombsPlaced = 0;
        while (bombsPlaced < bombCount)
        {
            Coordinate bombLocation = new Coordinate(num.nextInt(boardSize), num.nextInt(boardSize));

            if (board[bombLocation.row][bombLocation.col].value != 9 && !bombLocation.equals(firstMove) 
                && !bombLocation.equals(touchingCords[0]) && !bombLocation.equals(touchingCords[1]) 
                && !bombLocation.equals(touchingCords[2]) && !bombLocation.equals(touchingCords[3]) 
                && !bombLocation.equals(touchingCords[4]) && !bombLocation.equals(touchingCords[5]) 
                && !bombLocation.equals(touchingCords[6]) && !bombLocation.equals(touchingCords[7]))
            {
                board[bombLocation.row][bombLocation.col].value = 9;
                bombsPlaced++;

                // Increment the values of Sqaures touching the bomb
                Coordinate[] touchingBomb = bombLocation.touchingCoordinates(boardSize);
                for (int i = 0; i < touchingBomb.length; i++)
                {
                    if (board[touchingBomb[i].row][touchingBomb[i].col].value != 9)
                        board[touchingBomb[i].row][touchingBomb[i].col].value++;
                }
            }
        }
    }
    
    // Default Constructor
    public Board ()
    {
        
    }

    // Display the board to the user through the terminal
    public void printBoard ()
    {
        // Print the board starting at the top row and moving down
        for (int row = 0; row < this.boardSize; row++)
        {
            // Print the row numbers
            if ((this.boardSize - row) >= 10)
                System.out.print(((this.boardSize) - row) + "|");
            else
                System.out.print(((this.boardSize) - row) + " |");

            // Print the actual square values for the current row
            for (int col = 0;  col < this.boardSize; col++)
            {
                if (this.board[row][col].revealed)
                    System.out.print(this.board[row][col].value);
                else
                    System.out.print("  x");
            }
            System.out.println();
        }
        // TODO: figure out how to multiple a print statement like in python. theres gotta be something besides a for loop
        System.out.print(".  --------------------");
    }
}
