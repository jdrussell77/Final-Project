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
    public boolean isFull()
    {
        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[r].length;c++)
            {
                if(board[r][c].getColor()==null)
                    return false;
            }
        }
        return true;
    }
    /*
     * Checks the state of the game (if someone has won and who)
     * should be run after each round
     */
    public boolean isGameOver()
    {
        //Checking if board is full
        if(this.isFull())
            return true;
            
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
    public Player whosNext()
    {
        if(a)
            return p1;
        else
            return p2;
    }
    public void move(int col/*some mouse listener event to get which column in array*/)
    {
        if(this.isColumnFull(col)==false)// move is valid if the top column isn't full
        {
            int openRow=this.findOpenRow(col);//Finds the lowest point in column
            board[openRow][col]=new Circle(10,10,10,this.whosNext().getColor());
        }
    }
    public int findOpenRow(int col)
    {
        int r=0;
        if(board[r][col].getColor()!=null)
            return -1;
        for( ;board[r][col].getColor()==null;r++)
        {
        }
        return r-1;
    }
    public boolean isColumnFull(int col)
    {
        if(board[0][col].getColor()==null)
            return false;
        return true;
    }
    public Circle[][] getBoard()
    {
        return board;
    }
}