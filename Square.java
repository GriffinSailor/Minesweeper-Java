public class Square 
{
    // A squares value will be 1-8 depending on how many bombs are touching it
    // The value will be 9 to represent a Bom
    int value;
    // Whether or not a square is revealed will determine if the value will be shown to the user on the board
    Boolean revealed;

    // Primary constructor
    public Square(int value, Boolean revealed)
    {
        this.value = value;
        this.revealed = revealed;
    }

    // Default constructor - not sure why its required by I get an error in the Board class without this present
    public Square ()
    {
        this.value = 0;
        this.revealed = false;
    }
}
