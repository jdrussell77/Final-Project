import java.awt.*;
public class Testing
{
    public static void main(String args [])
    {
        Player p1=new Player(Color.RED);
        Player p2=new Player(Color.yellow);
        Game gam=new Game(p1, p2);
        System.out.println(gam.findOpenRow(0));
        gam.move(0);
        gam.next();
        System.out.println(gam.findOpenRow(0));
        gam.move(0);
        System.out.println(gam.findOpenRow(0));
        
        System.out.println(gam.isGameOver());
        //System.out.println(gam.getBoard()[5][0]);
        //System.out.println(gam.getBoard()[4][0]);
    }
}
