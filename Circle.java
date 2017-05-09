//Sam Piazza
//Circle
//Shape repo

import java.awt.*;
public class Circle extends Shape
{
    protected int radius;
    private Color color;
    public Circle(int x, int y, int rad,Color shade)
    {
        super(x,y);
        radius=rad;
        color=shade;
    }
    public void draw(Graphics p)
    {
        p.setColor (color);//Color of circle
        p.fillOval (xPos, yPos, radius, radius);
    }
    public Color getColor()
    {
        return color;
    }
    public void move(int x, int y)
    {
        super.xPos=x;
        super.yPos=y;
    }
    public double getRadius()
    {
        return radius;
    }
    public String toString()
    {
        return super.toString() +
        "\nRadius: "+getRadius();
    }
}//end of Circle