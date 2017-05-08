import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;

public abstract class Shape
{
    protected int xPos, yPos; //protected means only a child can access

    public Shape (int x, int y)
    {
        xPos=x;
        yPos=y;       
    }

    // you must write these methods here
    public int getXpos()
    {
        return xPos;
    }
    public int getYpos()
    {
        return yPos;
    }
    
    public abstract void move(int xLoc, int yLoc);

    public abstract void draw (Graphics p);

    //toString should display xpos, ypos
    public String toString()
    {
        String tem="x-position: "+xPos
        +"\ny-position: "+yPos;
        return tem;
    }
}//end of Shape