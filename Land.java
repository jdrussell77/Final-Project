//Sam Piazza

import java.awt.*;

public class Land extends Shape
{
    private int w;     // width of box
    private int h;     // height of box
    private Color color;   // color of land

    //-----------------------------------------------------------------
    //  Sets up the land's primary attributes.
    //-----------------------------------------------------------------
    public Land (int posX, int posY, int width, int height, Color shade)
    {
        super(posX,posY);
        w= width;
        h= height;
        color = shade;
    }

    public void move(int x, int y)
    {
        super.xPos=x;
        super.yPos=y;
    }
    //-----------------------------------------------------------------
    //  Draws this figure relative to baseX, baseY, and height.
    //-----------------------------------------------------------------
    public void draw (Graphics page)
    {
        page.setColor (color);//Color of box
        page.fillRect (xPos, yPos, w, h);// Rectangle shape
    }
}