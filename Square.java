/* Object Description
A Square object will contain an int parameter of 'value' (0-8 for non bombs, and 9 for bombs)
as well as a bool parameter of 'revealed' to determine whether or not the squares value will
be revealed to the user on the board
*/

public class Square 
{
    int value;
    Boolean revealed;

    // Manual constructor
    public Square(int value, Boolean revealed)
    {
        this.value = value;
        this.revealed = revealed;
    }

    // Default constructor
    public Square ()
    {
        this.value = 0;
        this.revealed = true;
    }
}
