import java.awt.*;

public class SecondApplet0025 extends java.applet.Applet {
    TextField tf;
    public void init() {
      System.out.println("Starting Second applet");
      add(new Label("Second Applet"));
      add(tf = new TextField( 10 ) );
      String s = getParameter("SecondAppletParm");
      tf.setText(s);
    }
}