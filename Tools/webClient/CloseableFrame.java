import java.awt.*;
import java.awt.event.*;
/** A Frame that you can actually quit. Used as
* the starting point for most Java 1.1 graphical
* applications.
*/
public class CloseableFrame extends Frame {
public CloseableFrame(String title) {
super(title);
enableEvents(AWTEvent.WINDOW_EVENT_MASK);
}
/** Since we are doing something permanent, we need
* to call super.processWindowEvent <B>first</B>.
*/
public void processWindowEvent(WindowEvent event) {
super.processWindowEvent(event); // Handle listeners
if (event.getID() == WindowEvent.WINDOW_CLOSING)
System.exit(0);
}
}