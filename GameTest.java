import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.sound.sampled.*;
import java.io.*;
import sun.audio.*;

/**
 * Main class for the game
 */
public class GameTest extends JFrame
{
    boolean isRunning = true;
    int fps = 30;
    int windowWidth = 800;
    int windowHeight = 600;

    BufferedImage backBuffer;
    Insets insets;
    InputHandler input;

    int x = 5;
    int y = 10;

    int x2 = 40;
    int y2 = 10;

    public static void main(String[] args)
    {
        GameTest game = new GameTest();
        game.run();
        System.exit(0);
    }

    /**
     * This method starts the game and runs it in a loop
     */
    public void run()
    {
        initialize();
        playSound();

        while(isRunning)
        {
            long time = System.currentTimeMillis();

            update();
            draw();

            //  delay for each frame  -   time it took for one frame
            time = (1000 / fps) - (System.currentTimeMillis() - time);

            if (time > 0)
            {
                try
                {
                    Thread.sleep(time);
                }
                catch(Exception e){}
            }
        }

        setVisible(false);
    }

    /**
     * This method will set up everything need for the game to run
     */
    void initialize()
    {
        setTitle("Test");
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        insets = getInsets();
        setSize(insets.left + windowWidth + insets.right,
            insets.top + windowHeight + insets.bottom);

        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
        input = new InputHandler(this);
    }

    /**
     * This method will check for input, move things
     * around and check for win conditions, etc
     */
    void update()
    {
        if (input.isKeyDown(KeyEvent.VK_RIGHT))
        {
            x += 5;
        }
        if (input.isKeyDown(KeyEvent.VK_LEFT))
        {
            x -= 5;
        }
        if (input.isKeyDown(KeyEvent.VK_UP))
        {
            y -= 5;
        }
        if (input.isKeyDown(KeyEvent.VK_DOWN))
        {
            y += 5;
        }
        if (input.isKeyDown(KeyEvent.VK_D))
        {
            x2 += 5;
        }
        if (input.isKeyDown(KeyEvent.VK_A))
        {
            x2 -= 5;
        }
        if (input.isKeyDown(KeyEvent.VK_W))
        {
            y2 -= 5;
        }
        if (input.isKeyDown(KeyEvent.VK_S))
        {
            y2 += 5;
        }

    }

    private void playSound() 
    {
        try
        {
            InputStream inputStream = getClass().getResourceAsStream("space.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        }
        catch (Exception e)
        {
            
        }
    }

    /**
     * This method will draw everything
     */
    void draw()
    {
        Graphics g = getGraphics();

        Graphics bbg = backBuffer.getGraphics();

        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, windowWidth, windowHeight);

        bbg.setColor(Color.BLACK);
        bbg.drawOval(x, y, 20, 20);

        bbg.setColor(Color.RED);
        bbg.drawOval(x2, y2, 20, 20);

        g.drawImage(backBuffer, insets.left, insets.top, this);
    }
}