
import java.awt.*;  
import java.applet.*;  
import java.io.*;

public class PlayGame
{
    
    public static void main(String [] args)
    {
        DisplayImage displ=new DisplayImage();
        Graphics g=new Graphics();
        displ.init();
        displ.paint(g);
    }
}
