import java.applet.Applet;
import java.applet.AppletStub;
import java.awt.*;

public class AppletLoader extends Applet
            implements Runnable, AppletStub {
  String appletToLoad;
  Thread appletThread;

  public void init() {
    appletToLoad = getParameter("DisplayImage");
    setBackground(Color.white);
  }

  public void paint(Graphics g) {
    g.drawString("Loading the Second Applet ...", 30, 30);
  }

  public void run() {
    try {
      //
      // REMOVE THIS
      //   for demo purpose only to see
      //   the "loading message!
      //
      Thread.sleep(2000);
      //
      Class appletClass = Class.forName(appletToLoad);
      Applet realApplet = (Applet)appletClass.newInstance();
      realApplet.setStub(this);
      setLayout( new GridLayout(1,0));
      add(realApplet);
      realApplet.init();
      realApplet.start();
    }
    catch (Exception e) {
      System.out.println( e );
    }
    validate();
  }

  public void start(){
    appletThread = new Thread(this);
    appletThread.start();
  }

  public void stop() {
    appletThread.stop();
    appletThread = null;
  }

  public void appletResize( int width, int height ){
    resize( width, height );
  }
}