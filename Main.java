import java.util.Scanner;

public class Main extends Board
{
    public static void main (String[] Args)
    {
        // User input Scanner for the game
        Scanner userInput = new Scanner(System.in);

        // Variables user to structure the actual game board
        Board gameBoard;
        Coordinate firstMoveCord = new Coordinate (1, 1);
        Coordinate moveCord = new Coordinate (1, 1);
        int boardSize = 0;
        int bombCount = 0;

        // Variables to determine current stage of the game
        Boolean gameBegun = false;
        Boolean gameLost = false;
        Boolean difficultySelected = false;
        int difficulty = 0;

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
                    firstMoveCord.col = col;
                    firstMoveCord.row = row;
                    gameBegun = true;
                }
            }
            catch (Exception invalidMove) 
            {
                System.out.println("\nInvalid Move - Please follow the 'x,y' format\n");
            }
        }

        // Make the official game board and send the user into the gameplay loop
        gameBoard = new Board (boardSize, bombCount, firstMoveCord);

        while (!gameLost)
        {
            // TODO: implement the actual gameplay loop - will need a makeMove function
            gameBoard.printBoard();
            System.out.println("\nPick a square to try to reveal with the format 'x,y'");
            String move = userInput.nextLine();
            try
            {
                String [] moveSplit = move.split(",");
                int col = Integer.parseInt(moveSplit[0]);
                int row = Integer.parseInt(moveSplit[1]);
                // Translate the users given values to the proper coordinates on the board
                row = boardSize - row;
                col = col - 1;

                if (col < 0 || col >= boardSize || row < 0 || row >= boardSize)
                    System.out.println("\nInvalid Move - Keep the x and y values in the range of the board\n");
                else
                {
                    moveCord.col = col;
                    moveCord.row = row;
                    gameBoard.makeMove(moveCord);
                }
            }
            catch (Exception invalidMove) 
            {
                System.out.println("\nInvalid Move - Please follow the 'x,y' format\n");
            }
        }
    }
}