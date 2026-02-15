import java.util.Scanner;

public class Main extends Board
{
    public static void main (String[] Args)
    {
        // Start the game
        Boolean difficultySelected = false;
        int difficulty = 0;
        Boolean gameNotBegun = true;
        Scanner userInput = new Scanner(System.in);
        while (!difficultySelected)
        {
            System.out.println("What difficulty would you prefer?\n1. Easy\n2. Medium\n3. Hard\n");
            String rawDifficultySelect = userInput.nextLine();

            // Set the difficulty
            try 
            {
                difficulty = Integer.parseInt(rawDifficultySelect);
                if (difficulty == 1 || difficulty == 2 || difficulty == 3)
                        difficultySelected = true;
                else
                    System.out.println("Invalid Selection - Please only enter a a valid difficulty choice (1-3)");

            } 
            catch (Exception invalidDataType) 
            {
                System.out.println("Invalid Selection - Please only enter a number to select a difficulty");
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