 

import java.awt.*;  
import java.applet.*;  
  

public class DisplayImage extends Applet {  
  Image bgimage;
  
  public void init() {  
    //gets an image
    bgimage = getImage(getDocumentBase(),"spacebackground.png"); 
    
    //sets applet size
    setSize (900, 600);
    
    Button button1 = new Button("Button 1");
        button1
        add(button1);
  }  
    
  public void paint(Graphics g) {  
    //draws the background image
    g.drawImage(bgimage, 0,0, this);
    
    Button button1;
    
  }  
      
  }  