
import java.awt.*;  
import java.applet.*;  
import java.io.*;


public class DisplayImage extends Applet {  
    //graphisc
    private Image bgimage, leftllama, rightalpaca, asteroid1, asteroid2, gameboardborder, header,
    currentplayergraphic, player1icon, player2icon, restartbutton, menubutton, appletborder;
    
    //players
    private Player p1 = new Player(Color.red);
    private Player p2 = new Player(Color.yellow);
    
    //game
    private Game game=new Game(p1, p2);
    
    //gameboard
    private Grid grid=new Grid(300, (700/3),300,350,Color.white);
    private Circle [][] board=new Circle[6][7];
    
    
    
    public void init() {  
        //sets applet size
        setSize (900, 600);

        //assigns images that will be used to variables
        //appletborder = getImage(getDocumentBase(), "appletborder.png");
        bgimage = getImage(getDocumentBase(),"spacebackground.png"); 
        leftllama = getImage(getDocumentBase(), "leftllama.png");
        rightalpaca = getImage(getDocumentBase(), "rightalpaca.png");
        asteroid1 = getImage(getDocumentBase(), "asteroid1.png");
        asteroid2 = getImage(getDocumentBase(), "asteroid4.png");
        gameboardborder = getImage(getDocumentBase(), "border.png");
        header = getImage(getDocumentBase(), "header5.png");
        currentplayergraphic = getImage(getDocumentBase(), "currentplayer.png");
        player1icon = getImage(getDocumentBase(), "player1icon.png");
        player2icon = getImage(getDocumentBase(), "player2icon.png");
        //restartbutton = getImage(getDocumentBase(), "restartbutton.png");
        //menubutton = getImage(getDocumentBase(), "menubutton.png");

		//music
		AudioClip music = getAudioClip(getDocumentBase(), "space.wav");
    	music.play();

    }  
    public void paint(Graphics g) 
    {  
        //draws the graphics
        g.drawImage(bgimage, 0,0, this);
        g.fillRect(300, (700/3),300, 350);
        //g.drawImage(appletborder, 0,0, this); 
        g.drawImage(asteroid2, ((1850/3))+10, 10, this); //done
        g.drawImage(leftllama, 0, (150+(25/3)), this); //done
        g.drawImage(rightalpaca, (675), (150), this); //done
        g.drawImage(header, ((800/3)-50), (100/3), this);
		g.drawImage(asteroid1, -30, 0, this); //done
        g.drawImage(gameboardborder, 290, ((700/3)-10), this); //done

		
        //g.drawImage(restartbutton, 100, (1600/3), this);
        //g.drawImage(menubutton, 700, (1600/3), this);
        
        //draws the grid
        
        //draws the current player graphics
        grid.draw(g);
        if (game.whosUp().getColor()==p1.getColor())
            g.drawImage( player1icon, (1000/3), ((400/3)+25), this);
        else 
            g.drawImage( player2icon, (1000/3), ((400/3)+25), this);

        
            
        game.move(0);
        game.next();
        game.move(0);
        game.DrawBoard(g);
        /**
         * SASHA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * TEXT ME!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * Jake should have given you my number
         * 630-445-3474
         * but there
         * this project needs to be finessed
         */
    }  
}