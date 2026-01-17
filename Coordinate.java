/* Object Description
This will essentially be a tuple from Python - a more effient way
to keep the coordinates of a space of the board in a single referencable object.
*/

public class Coordinate 
{
    int row;
    int col;

    public Coordinate (int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    // Creates an array of coordinates that touch the existing coordinate
    public Coordinate[] touchingCoordinates(int boardSize)
    {
        int validCoordinates = 0;
        Coordinate[] touchingCords = new Coordinate[8];
        if (this.row + 1 < boardSize && this.col - 1 >= 0)
        {
            validCoordinates++;
            touchingCords[0] = new Coordinate(this.row + 1, this.col - 1);
        }
        if (this.row + 1 < boardSize)
        {
            validCoordinates++;
            touchingCords[1] = new Coordinate(this.row + 1, this.col);
        }
        if (this.row + 1 < boardSize && this.col + 1 < boardSize)
        {
            validCoordinates++;
            touchingCords[2] = new Coordinate(this.row + 1, this.col + 1);
        }
        if (this.col - 1 >= 0)
        {
            validCoordinates++;
            touchingCords[3] = new Coordinate(this.row, this.col - 1);
        }
        if (this.col + 1 < boardSize)
        {
            validCoordinates++;
            touchingCords[4] = new Coordinate(this.row, this.col + 1);
        }
        if (this.row - 1 >= 0 && this.col - 1 >= 0)
        {
            validCoordinates++;
            touchingCords[5] = new Coordinate(this.row - 1, this.col - 1);
        }
        if (this.row - 1 >= 0)
        {
            validCoordinates++;
            touchingCords[6] = new Coordinate(this.row - 1, this.col);
        }
        if (this.row - 1 >= 0 && this.col + 1 < boardSize)
        {
            validCoordinates++;
            touchingCords[7] = new Coordinate(this.row - 1, this.col + 1);
        }

        // Filter out coordinates from the array that were not set because they were not valid
        Coordinate[] noNullCords = new Coordinate[validCoordinates];
        for (int i = 0; i < touchingCords.length; i ++)
        {
            int nextValidCord = 0;
            if (touchingCords[i] != null)
            {
                noNullCords[nextValidCord] = touchingCords[i];
                nextValidCord++;
            }
        }

        return noNullCords;
    }

    // Equals method override to allow for comparisons of coordinates
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) 
            return false;
        
        if (obj.getClass() != this.getClass())
            return false;
        
        Coordinate givenCord = (Coordinate) obj;
        if (this.row != givenCord.row || this.col != givenCord.col)
            return false;

        return true;
    }
}
