//Sam Piazza
//Final Project
//Connect 4
import java.awt.*;
public class Game
{
    private Player p1;
    private Player p2;
    private boolean a=true;
    private boolean b=true;
    /**
     * Default constructor for objects of class Game
     */
    public Game(Player a, Player b)
    {
        p1=a;
        p2=b;
    }
    
    /*
     * Checks the state of the game (if someone has won and who)
     * should be run after each round
     */
    public boolean check()
    {
    }
    public void next()
    {
        if (a)
        {
            b=true;
            a=false;
        }
        else
        {
            a=true;
            b=false;
        }
    }
    public String whosNext()
    {
        if(a)
            return "Player 1";
        else
            return "Player 2";
    }
}
