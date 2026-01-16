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
        Coordinate[] touchingCords = new Coordinate[8];
        if (this.row + 1 < boardSize && this.col - 1 >= 0)
            touchingCords[0] = new Coordinate(this.row + 1, this.col - 1);
        if (this.row + 1 < boardSize)
            touchingCords[1] = new Coordinate(this.row + 1, this.col);
        if (this.row + 1 < boardSize && this.col + 1 < boardSize)
            touchingCords[2] = new Coordinate(this.row + 1, this.col + 1);
        if (this.col - 1 >= 0)
            touchingCords[3] = new Coordinate(this.row, this.col - 1);
        if (this.col + 1 < boardSize)
            touchingCords[4] = new Coordinate(this.row, this.col + 1);
        if (this.row - 1 >= 0 && this.col - 1 >= 0)
            touchingCords[5] = new Coordinate(this.row - 1, this.col - 1);
        if (this.row - 1 >= 0)
            touchingCords[6] = new Coordinate(this.row - 1, this.col);
        if (this.row - 1 >= 0 && this.col + 1 < boardSize)
            touchingCords[7] = new Coordinate(this.row - 1, this.col + 1);

        return touchingCords;
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
