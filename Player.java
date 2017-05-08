//Sam Piazza
import java.awt.*;
public class Player
{
    /** description of instance variable x (add comment for each instance variable) */
    private Color color;
    private int num;
    /**
     * Default constructor for objects of class Player
     */
    public Player(Color col,int numb)
    {
        color=col;
        num=numb;
    }
    public Color getColor()
    {
        return color;
    }
    public int getNum()
    {
        return num;
    }
    public String toString()
    {
        return "Hi I am player "+getNum()+" my color is "+getColor();
    }
}
