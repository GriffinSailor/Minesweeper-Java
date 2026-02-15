import java.util.Scanner;

public class Main extends Board
{
    public static void main (String[] Args)
    {
        // Initialize variables
        Board gameBoard;
        int boardSize = 0;
        int bombCount = 0;
        Boolean gameBegun = false;
        Boolean gameLost = false;
        Boolean difficultySelected = false;
        int difficulty = 0;
        Scanner userInput = new Scanner(System.in);

        // Have user select the difficulty
        while (!difficultySelected)
        {
            System.out.println("What difficulty would you prefer?\n1. Easy\n2. Medium\n3. Hard\n");
            String rawDifficultySelect = userInput.nextLine();

            // Set the difficulty
            try 
            {
                difficulty = Integer.parseInt(rawDifficultySelect);
                if (difficulty == 1)
                {
                    boardSize = 10;
                    bombCount = 10;
                    difficultySelected = true;
                } 
                else if (difficulty == 2)
                {
                    boardSize = 15;
                    bombCount = 40;
                    difficultySelected = true;
                }
                else if (difficulty == 3)
                {
                    boardSize = 24;
                    bombCount = 99;
                    difficultySelected = true;
                }
                else
                    System.out.println("\nInvalid Selection - Please only enter a a valid difficulty choice (1-3)\n");
            } 
            catch (Exception invalidDataType) 
            {
                System.out.println("\nInvalid Selection - Please only enter a number to select a difficulty\n");
            }
        }

        // Make first move and generate the board
        while (!gameBegun)
        {
            printBlankBoard(boardSize);
            System.out.println("\nPick a square to try to reveal with the format 'x,y'");
            String firstMove = userInput.nextLine();
            try
            {
                String [] firstMoveSplit = firstMove.split(",");
                int col = Integer.parseInt(firstMoveSplit[0]);
                int row = Integer.parseInt(firstMoveSplit[1]);
                // Translate the users given values to the proper coordinates on the board
                row = boardSize - row;
                col = col - 1;

                if (col < 0 || col >= boardSize || row < 0 || row >= boardSize)
                    System.out.println("\nInvalid Move - Keep the x and y values in the range of the board\n");
                else
                {
                    Coordinate firstMoveCord = new Coordinate(row, col);
                    gameBoard = new Board (boardSize, bombCount, firstMoveCord);
                    gameBegun = true;
                }
            }
            catch (Exception invalidMove) 
            {
                System.out.println("\nInvalid Move - Please follow the 'x,y' format\n");
            }
        }


        // First Diffuclty = 10 Bombs in a Boardsize of 10
        /*
        Coordinate newCord1 = new Coordinate(9, 0);
        Board testBoard1 = new Board(10, 10, newCord1);
        testBoard1.printBoard();
        System.out.println();
        */

        // Second Difficulty = 40 Bombs in a Boardsize of 15
        /*
        Coordinate newCord2 = new Coordinate(14, 0);
        Board testBoard2 = new Board(15, 40, newCord2);
        testBoard2.printBoard();
        System.out.println();
        */

        // Third Difficulty = 99 Bombs in a Boardsize of 24
        /*
        Coordinate newCord3 = new Coordinate(23, 0);
        Board testBoard3 = new Board(24, 99, newCord3);
        testBoard3.printBoard();
        System.out.println();
        */
    }
}