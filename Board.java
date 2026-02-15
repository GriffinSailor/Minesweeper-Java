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
                // TODO: set Revealed to False after testing
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
                && (touchingCords[0] == null || !bombLocation.equals(touchingCords[0]))
                && (touchingCords[1] == null || !bombLocation.equals(touchingCords[1]))
                && (touchingCords[2] == null || !bombLocation.equals(touchingCords[2])) 
                && (touchingCords[3] == null || !bombLocation.equals(touchingCords[3]))
                && (touchingCords[4] == null || !bombLocation.equals(touchingCords[4]))
                && (touchingCords[5] == null || !bombLocation.equals(touchingCords[5]))
                && (touchingCords[6] == null || !bombLocation.equals(touchingCords[6])) 
                && (touchingCords[7] == null || !bombLocation.equals(touchingCords[7])))
            {
                board[bombLocation.row][bombLocation.col].value = 9;
                bombsPlaced++;

                // Increment the values of Sqaures touching the bomb
                Coordinate[] touchingBomb = bombLocation.touchingCoordinates(boardSize);
                for (int i = 0; i < touchingBomb.length; i++)
                {
                    if (touchingBomb[i] != null && board[touchingBomb[i].row][touchingBomb[i].col].value != 9)
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
        System.out.println();
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
                    System.out.print(" " + this.board[row][col].value + " ");
                else
                    System.out.print(" x ");
            }
            System.out.println();
        }
        // Print the bottom line for the board and the numbers on the x axis
        System.out.print("   ");
        for (int i = 0; i < (3 * this.boardSize); i++)
        {
            System.out.print("-");
        }
        System.out.print("\n   ");
        for (int i = 0; i < this.boardSize; i++)
        {
            if (i + 1 >= 10)
                System.out.print((i + 1) + " ");
            else
                System.out.print(" " + (i + 1) + " ");
        }
    }

    // Print a blank board when collecting the users first move. 
    // This is a separate function since the first move will not be able to 
    // reference an actual Board object since one wont be generated at that point
    public static void printBlankBoard (int boardSize)
    {
        System.out.println();
        for (int row = 0; row < boardSize; row++)
        {
            // Print the row numbers
            if ((boardSize - row) >= 10)
                System.out.print(((boardSize) - row) + "|");
            else
                System.out.print(((boardSize) - row) + " |");

            // Print the actual square values for the current row
            for (int col = 0;  col < boardSize; col++)
            {
                System.out.print(" x ");
            }
            System.out.println();
        }
        // Print the bottom line for the board and the numbers on the x axis
        System.out.print("   ");
        for (int i = 0; i < (3 * boardSize); i++)
        {
            System.out.print("-");
        }
        System.out.print("\n   ");
        for (int i = 0; i < boardSize; i++)
        {
            if (i + 1 >= 10)
                System.out.print((i + 1) + " ");
            else
                System.out.print(" " + (i + 1) + " ");
        }
        System.out.println();
    }
}
