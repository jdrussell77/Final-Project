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
    private Circle [][] board=new Circle[6][7];
    /**
     * Default constructor for objects of class Game
     */
    public Game(Player a, Player b)
    {
        p1=a;//Sets player 1
        p2=b;//Sets player 2
        
        p1.setNum(1);
        p2.setNum(2);
    }
    public Player getPlayer1()
    {
        return p1;
    }
    public Player getPlayer2()
    {
        return p2;
    }
    /*
     * Checks the state of the game (if someone has won and who)
     * should be run after each round
     */
    public boolean check()
    {
        //Checking Horizontals
        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[r].length-3;c++)
            {
                if(board[r][c].getColor()==board[r][c+1].getColor() && board[r][c].getColor()==board[r][c+2].getColor() && board[r][c].getColor()==board[r][c+3].getColor())        
                    return true;
            }
        }
        
        //Checking Columns
        for(int r=0;r<board.length-3;r++)
        {
            for(int c=0;c<board[r].length;c++)
            {          
                if(board[r][c].getColor()==board[r+1][c].getColor() && board[r][c].getColor()==board[r+2][c].getColor() && board[r][c].getColor()==board[r+3][c].getColor())        
                    return true;
            }
        }
        
        //Checking Left to Right Diagonal
        for(int r=0;r<board.length;r++)
        {
            for(int c=board[r].length-1;c>=0;c--)
            {          
                if(board[r][c].getColor()==board[r+1][c].getColor() && board[r][c].getColor()==board[r+2][c].getColor() && board[r][c].getColor()==board[r+3][c].getColor())        
                    return true;
            }
        }
        
        //Checking Right to Left Diagonal
        for(int r=0;r<board.length;r++)
        {
            for(int c=board[r].length-1;c>=0;c--)
            {          
                if(board[r][c].getColor()==board[r+1][c].getColor() && board[r][c].getColor()==board[r+2][c].getColor() && board[r][c].getColor()==board[r+3][c].getColor())        
                    return true;
            }
        }
        return false;
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
    public void place(/*some mouse listener event to get which column in array*/)
    {
        
    }
}
