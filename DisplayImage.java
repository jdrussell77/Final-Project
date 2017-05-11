 

import java.awt.*;  
import java.applet.*;  
  

public class DisplayImage extends Applet {  
  Image bgimage, leftllama, rightalpaca, asteroid1, asteroid2, gameboardborder, header,
            currentplayergraphic, player1icon, player2icon, restartbutton, menubutton;
  Player p1 = new Player();
  Player p2 = new Player();
  
  Game game= new Game(p1, p2);
  
  public void init() {  
    p1.setColor(Color.red);
    p2.setColor(Color.yellow);
    //sets applet size
    setSize (900, 600);
      
    //images that will be used
    bgimage = getImage(getDocumentBase(),"spacebackground.png"); 
    leftllama = getImage(getDocumentBase(), "leftllama.png");
    rightalpaca = getImage(getDocumentBase(), "rightalpaca.png");
    asteroid1 = getImage(getDocumentBase(), "asteroid1.png");
    asteroid2 = getImage(getDocumentBase(), "asteroid2.png");
    gameboardborder = getImage(getDocumentBase(), "border.png");
    header = getImage(getDocumentBase(), "header.png");
    currentplayergraphic = getImage(getDocumentBase(), "currentplayer.png");
    player1icon = getImage(getDocumentBase(), "player1icon.png");
    player2icon = getImage(getDocumentBase(), "player2icon.png");
    restartbutton = getImage(getDocumentBase(), "restartbutton.png");
    menubutton = getImage(getDocumentBase(), "menubutton.png");
    
    
    
    
  }  
    
  public void paint(Graphics g) {  
    //draws the graphics
    g.drawImage(bgimage, 0,0, this);
    g.drawImage(asteroid1, x, y, this);
    g.drawImage(asteroid2, x, y, this);
    g.drawImage(leftllama, x, y, this);
    g.drawImage(rightalpaca, x, y, this);
    
    if (game.whosUp().getColor()==p1.getColor())
        g.drawImage( player1icon, x, y, this);
    else 
         g.drawImage( player2icon, x, y, this);
         
    
   
    
    
    
    
  }  
      
  }  