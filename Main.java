public class Main extends Board
{
    public static void main (String[] Args)
    {
        // First Diffuclty = 10 Bombs in a Boardsize of 10
        Coordinate newCord1 = new Coordinate(0, 0);
        Board testBoard1 = new Board(10, 10, newCord1);
        testBoard1.printBoard();
        System.out.println();

        // Second Difficulty = 40 Bombs in a Boardsize of 15
        Coordinate newCord2 = new Coordinate(0, 0);
        Board testBoard2 = new Board(15, 40, newCord2);
        testBoard2.printBoard();
        System.out.println();

        // Third Difficulty = 99 Bombs in a Boardsize of 24
        Coordinate newCord3 = new Coordinate(0, 0);
        Board testBoard3 = new Board(24, 99, newCord3);
        testBoard3.printBoard();
        System.out.println();
    }
}