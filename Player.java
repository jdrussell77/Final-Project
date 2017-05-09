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
    public Player()
    {
        color=null;
        num=0;
    }
    public void setColor(Color col)
    {
        color=col;
    }
    public void setNum(int p)
    {
        num=p;
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
