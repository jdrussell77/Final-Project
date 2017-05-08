import java.awt.*;  
import java.applet.*;  
  
  
public class DisplayImage extends Applet {  
  
  Image picture;  
  
  public void init() {  
    picture = getImage(getDocumentBase(),"fuckme.jpg");  
  }  
    
  public void paint(Graphics g) {  
    g.drawImage(picture, 0,0, this);
    
  }  
      
  }  