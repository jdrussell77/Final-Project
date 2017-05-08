import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class AnAppletWithButtons extends Applet implements ActionListener {
    public void init() {
        button1 = new Button("Button 1");
        add(button1);
        button1.addActionListener(this);

        button2 = new Button("Button 2");
        add(button2);
        button2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) 
            System.out.println("Button 1 was pressed");
        else
            System.out.println("Button 2 was pressed");
        }

    Button button1, button2;
}

/**
This Applet's Behavior

The Class Header
    -In addition to extending Applet, the AnAppletWithButtons class declares that it intends to be an ActionListener, i.e., to listen to button clicks.
        -It does this through the implements keyword
        -Making this declaration obligates the AnAppletWithButtons class to provide the appropriate even-handling method
            -The method for an ActionListener is addActionPerformed (see below)
The init Method
    -Two buttons (named button1 and button2) are created in init
    -The buttons are placed on the applet (using the add method)
        -In the absence of anything else, adding interface elemnts to the applets places them one after the other from left-to-right.
        -When the right edge of the applet's real estate is reached, the placement continues below, again starting at the left edge.
        -The placement of the elements thus flows from right-to-left, top-to-bottom.
    -The applet notifies each button that it wishes to be a listener to the button, i.e., that it wishes to be notified when the button is clicked
        -The applet sends a reference to itself (this) to the button's addActionListener method
        -The applet is said to register itself as a listener with the button.
    
The actionPerformed Method
    -This is the event-handling method for button clicks
    -Having registered the applet as a listener with each button, this method is invoked whenever either of the two buttons is clicked.
    -An ActionEvent object is passed a a parameter to this method
        -The ActionEvent parameter contains information pertaining to the specific event that occurred.
        -In particular, the method, getSource can be invoked to determine which button generated the event (i.e., which button was clicked).
            -getSource returns a reference to the interface component that generated the event
            -Knowing which component (button) generated the event allows the listener to determine what should be done
        -Using the getSource method to distinguish betwen the two buttons, the actionPerformed method simply prints a message stating which button was clicked.

        
http://www.sci.brooklyn.cuny.edu/~weiss/cisc3120/Readings/JavaApplets/05-AnAppletWithButtons/        
*/