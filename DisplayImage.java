 

import java.awt.*;  
import java.applet.*;  
  
  
public class DisplayImage extends Applet {  
  
  Image picture, pngpic;  
  
  public void init() {  
    picture = getImage(getDocumentBase(),"fuckme.jpg");  
    pngpic = getImage(getDocumentBase(),"thisshit.png");  
  }  
    
  public void paint(Graphics g) {  
    g.drawImage(picture, 0,0, this);
    g.drawImage(pngpic, 0, 0, this);
    
  }  
      
  }  