//Sam Piazza

import java.awt.*;

public class Grid
{
    private int w;     // width of grid
    private int h;     // height of grid
    private int x;
    private int y;
    private Color color;   // color of land
    
    //-----------------------------------------------------------------
    //  Sets up the land's primary attributes.
    //-----------------------------------------------------------------
    public Grid (int posX, int posY, int width, int height, Color shade)
    {
        x=posX;
        y=posY;
        w= width;
        h= height;
        color = shade;
    }
    
    //-----------------------------------------------------------------
    //  Draws this figure relative to baseX, baseY, and height.
    //-----------------------------------------------------------------
    public void draw (Graphics page)
    {
        page.setColor (color);//Color of box
        
        //Border of grid
        Land b1=new Land(x,y,5,h,color);
        Land b2=new Land(x,y+h,w,5,color);
        Land b3=new Land(x,y,w,5,color);
        Land b4=new Land(x+w,y,5,h,color);
        
        //Row lines
        Land r1=new Land(x,y+(h/6),w,5,color);
        Land r2=new Land(x,y+(h/6)*2,w,5,color);
        Land r3=new Land(x,y+(h/6)*3,w,5,color);
        Land r4=new Land(x,y+(h/6)*4,w,5,color);
        Land r5=new Land(x,y+(h/6)*5,w,5,color);
        
        //Column lines
        Land c1=new Land(x+(w/7),y,5,h,color);
        Land c2=new Land(x+(w/7)*2,y,5,h,color);
        Land c3=new Land(x+(w/7)*3,y,5,h,color);
        Land c4=new Land(x+(w/7)*4,y,5,h,color);
        Land c5=new Land(x+(w/7)*5,y,5,h,color);
        Land c6=new Land(x+(w/7)*6,y,5,h,color);
        
        //Drawing everything
        b1.draw(page);
        b2.draw(page);
        b3.draw(page);
        b4.draw(page);
        r1.draw(page);
        r2.draw(page);
        r3.draw(page);
        r4.draw(page);
        r5.draw(page);
        c1.draw(page);
        c2.draw(page);
        c3.draw(page);
        c4.draw(page);
        c5.draw(page);
        c6.draw(page);
    }
}