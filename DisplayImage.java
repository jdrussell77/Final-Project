
import java.awt.*;  
import java.applet.*;  

public class DisplayImage extends Applet {  
    private Image bgimage, leftllama, rightalpaca, asteroid1, asteroid2, gameboardborder, header,
    currentplayergraphic, player1icon, player2icon, restartbutton, menubutton, appletborder;
    private Player p1 = new Player(Color.red);
    private Player p2 = new Player(Color.yellow);
    private Game game=new Game(p1, p2);
    private Grid grid=new Grid(350,200,200,350,Color.white);
    private Circle [][] board=new Circle[6][7];
    public void init() {  
        //sets applet size
        setSize (900, 600);

        //images that will be used
        appletborder = getImage(getDocumentBase(), "appletborder.png");
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
        g.drawImage(appletborder, 0,0, this);
        g.drawImage(asteroid1, (25/3), (25/3), this);
        g.drawImage(asteroid2, (1850/3), (25/3), this);
        g.drawImage(leftllama, (25/3), (150), this);
        g.drawImage(rightalpaca, (2000/3), (150), this);
        g.drawImage(header, (800/3), (100/3), this);
        g.drawImage(gameboardborder, 275, 175, this);
        g.drawImage(currentplayergraphic, (1000/3), (400/3), this);
        g.drawImage(restartbutton, 100, (1600/3), this);
        g.drawImage(menubutton, 700, (1600/3), this);
        grid.draw(g);
        if (game.whosUp().getColor()==p1.getColor())
            g.drawImage( player1icon, 0, 0, this);
        else 
            g.drawImage( player2icon, 0, 0, this);
        
        game.move(0);
        game.next();
        game.move(0);
        game.DrawBoard(g);
        
    }  
}