//Sam Piazza, Sasha Fenton
import java.awt.*;  
import java.applet.*;  
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class DisplayImage extends Applet implements ActionListener{  
    //graphisc
    private Image bgimage, leftllama, rightalpaca, asteroid1, asteroid2, gameboardborder, header,
    currentplayergraphic, player1icon, player2icon, restartbutton, menubutton, appletborder, winner, tie;
    
    //players
    private Player p1 = new Player(Color.red);
    private Player p2 = new Player(Color.yellow);
    
    //game
    private Game game=new Game(p1, p2);
    
    //gameboard
    private Grid grid=new Grid(300, (700/3),300,350,Color.white);
    
    private Button col1,col2,col3,col4,col5,col6,col7;
    
    public void init() {  
        //sets applet size
        setSize (900, 600);

        //assigns images that will be used to variables
        //appletborder = getImage(getDocumentBase(), "appletborder.png");
        col1=new Button("Col 1");
        col2=new Button("Col 2");
        col3=new Button("Col 3");
        col4=new Button("Col 4");
        col5=new Button("Col 5");
        col6=new Button("Col 6");
        col7=new Button("Col 7");
        
        add(col1);add(col2);add(col3);add(col4);add(col5);add(col6);add(col7);
        col1.setBounds(303,((700/3)-30),40,20);
        col2.setBounds(347,((700/3)-30),40,20);
        col3.setBounds(391,((700/3)-30),40,20);
        col4.setBounds(435,((700/3)-30),40,20);
        col5.setBounds(479,((700/3)-30),40,20);
        col6.setBounds(523,((700/3)-30),40,20);
        col7.setBounds(566,((700/3)-30),40,20);
        setLayout(null);
        
        col1.addActionListener(this);
        col2.addActionListener(this);
        col3.addActionListener(this);
        col4.addActionListener(this);
        col5.addActionListener(this);
        col6.addActionListener(this);
        col7.addActionListener(this);
        
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
        tie=getImage(getDocumentBase(),"tie.png");
        winner=getImage(getDocumentBase(),"winner.png");
        
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
        if (game.isGameOver()==false)
        {
            if (game.whosUp().getColor()==p1.getColor())
                g.drawImage( player1icon, (1000/3), ((400/3)+25), this);
            else 
                g.drawImage( player2icon, (1000/3), ((400/3)+25), this);
            game.DrawBoard(g);
        }
        else
        {
            if(game.isFull()==false)
            {
                game.next();
                g.drawImage(winner,(1000/3)-40, (-20),this);
                if(game.whosUp().getColor()==p1.getColor())
                    g.drawImage(player1icon,(1000/3)+125, ((400/3)+25),this);
                else
                    g.drawImage(player2icon,(1000/3)+125, ((400/3)+25),this);
            }
            else
                g.drawImage(tie,(1000/3), ((400/3)+25),this);
            game.DrawBoard(g);
        }
    }  
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==col1)
            game.move(0);
        if(e.getSource()==col2)
            game.move(1);
        if(e.getSource()==col3)
            game.move(2);
        if(e.getSource()==col4)
            game.move(3);
        if(e.getSource()==col5)
            game.move(4);
        if(e.getSource()==col6)
            game.move(5);
        if(e.getSource()==col7)
            game.move(6);
        game.next();
        repaint();
    }
}