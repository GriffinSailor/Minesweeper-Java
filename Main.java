public class Main extends Board
{
    public static void main (String[] Args)
    {
        // Testing
        System.out.println("Hello World!");
        Coordinate newCord = new Coordinate(0, 0);

        Board testBoard = new Board(10, 5, newCord);
        testBoard.printBoard();
    }
}