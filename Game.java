//Sam Piazza
//Final Project
//Connect 4
import java.awt.*;
public class Game
{
    private Player p1;
    private Player p2;
    private final int radius=20;
    private boolean a=true;
    private boolean b=true;
    private Circle [][] board=new Circle[6][7];
    
    /**
     * Default constructor for objects of class Game
     * @param Player a, Player b. Takes two player objects
     * assigns the player objects by number
     */
    public Game(Player a, Player b)
    {
        p1=a;//Sets player 1
        p2=b;//Sets player 2

        p1.setNum(1);
        p2.setNum(2);
    }
    /**
     * @return player1 object
     */
    public Player getPlayer1()
    {
        return p1;
    }
    /**
     * @return player2 object
     */
    public Player getPlayer2()
    {
        return p2;
    }
    /**
     * Checks to see if the board is full
     * @return true if full
     * @return false if not full
     */
    public boolean isFull()
    {
        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[r].length;c++)
            {
                if(board[r][c]==null)
                    return false;
            }
        }
        return true;
    }
    /**
     * Checks to see if four pieces are in a row (same color) horizontally
     * @return true if there is four in a row
     * @return false if there isnt four in a row
     */
    public boolean HorizontalCheck()
    {
        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[r].length-3;c++)
            {
                if(board[r][c]!=null && board[r][c+1]!=null && board[r][c+2]!=null && board[r][c+3]!=null)
                {
                    if(board[r][c].getColor()==board[r][c+1].getColor() && board[r][c].getColor()==board[r][c+2].getColor() && board[r][c].getColor()==board[r][c+3].getColor())        
                        return true;
                }
            }
        }
        return false;
    }
    /**
     * Checks to see if four pieces are in a row (same color) vertically
     * @return true if there is a win
     * @return false if there isnt a win
     */
    public boolean VerticalCheck()
    {
        for(int r=0;r<board.length-3;r++)
        {
            for(int c=0;c<board[r].length;c++)
            {          
                if(board[r][c]!=null && board[r+1][c]!=null && board[r+2][c]!=null && board[r+3][c]!=null)
                {
                    if(board[r][c].getColor()==board[r+1][c].getColor() && board[r][c].getColor()==board[r+2][c].getColor() && board[r][c].getColor()==board[r+3][c].getColor())        
                        return true;
                }
            }
        }
        return false;
    }
    /**
     * Checks to see if four pieces are in a row (same color) diagonally
     * There are two types of diagonals so it checks both ways
     * @return true if there is a win
     * @return false if there isnt a win
     */
    public boolean DiagonalsCheck()
    {
        // ascendingDiagonalCheck 
        for (int r=3; r<board.length; r++){
            for (int c=0; c<board[r].length-3; c++){
                if(board[r][c]!=null && board[r-1][c+1]!=null && board[r-2][c+2]!=null && board[r-3][c+3]!=null)
                    if (this.board[r][c].getColor() == this.board[r-1][c+1].getColor() && this.board[r][c].getColor() == this.board[r-2][c+2].getColor() && this.board[r][c].getColor() == this.board[r-3][c+3].getColor())
                        return true;
            }
        }
        // descendingDiagonalCheck
        for (int r=3; r<board.length; r++){
            for (int c=3; c<board[r].length; c++){
                if(board[r][c]!=null && board[r-1][c-1]!=null && board[r-2][c-2]!=null && board[r-3][c-3]!=null)
                    if (this.board[r][c].getColor() == this.board[r-1][c-1].getColor() && this.board[r][c].getColor() == this.board[r-2][c-2].getColor() && this.board[r][c].getColor() == this.board[r-3][c-3].getColor())
                        return true;
            }
        }
        return false;
    }
    /**
     * Checks the state of the game (if someone has won and who)
     * should be run after each round
     * @return true if someone has won or if board is full
     * @return false if nobody has won or board is full
     */
    public boolean isGameOver()
    {
        //Checking if board is full
        if(this.isFull())
            return true;

        //Checking Horizontals
        if(this.HorizontalCheck())
            return true;

        //Checking Columns
        if(this.VerticalCheck())
            return true;
        
        //Checking Diagonals        
        if(this.DiagonalsCheck())
            return true;
        
        return false;
    }
    /**
     * Swaps the status of boolean variables a and b (these determine who is up. true is up next)
     * should be run after each round
     */
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
    /**
     * @return the Player object of who is up next
     */
    public Player whosUp()
    {
        if(a)
            return p1;
        else
            return p2;
    }
    /**
     * Makes a new Circle object at the bottom of the desired column
     * @param int col. The desired column the piece is to be placed
     */
    public void move(int col)
    {
        if(this.isColumnFull(col)==false)// move is valid if the top column isn't full
        {
            int openRow=this.findOpenRow(col);//Finds the lowest point in column
            board[openRow][col]=new Circle(findXcord(col),findYcord(openRow),radius,this.whosUp().getColor());
            this.next();
        }
    }
    /**
     * Finds the x coordinate of a new Circle object on the board
     * @param int col. Desired column
     * @return int cooridnate x
     */
    public int findXcord(int col)
    {
        int x=(300+((300/7))/2)+(int)(42.857*col);
        return x;
    }
    /**
     * Finds the x coordinate of a new Circle object on the board
     * @param int row
     * @return int cooridnate y
     */
    public int findYcord(int row)
    {
        int y=((700/3)+ ((350/6))/2)+(int)(58.333*row);
        return y;
    }
    /**
     * Finds the last available row in a column
     * @param int col
     * @return int row
     */
    public int findOpenRow(int col)
    {
        int r=0;
        while(board[r][col]==null)
        {
            if(r==5)
            {
                return 5;
            }
            r++;
        }
        return r-1;
    }
    /**
     * Determines if the column is full
     * @param int col
     * @return boolean state of column
     * false means column isnt full
     * true means it is full
     */
    public boolean isColumnFull(int col)
    {
        if(board[0][col]==null)
            return false;
        return true;
    }
    /**
     * Returns the game board
     * @return Circle[][] board
     */
    public Circle[][] getBoard()
    {
        return board;
    }
    /**
     * Draws the game board
     */
    public void DrawBoard(Graphics g)
    {
        //Draws the pieces
        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[r].length;c++)
            {
                if(board[r][c]!=null)
                    board[r][c].draw(g);
            }
        }
    }
}