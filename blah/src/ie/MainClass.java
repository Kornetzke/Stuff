package ie;
/*
 * Output:
 *  
 */

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass extends JPanel {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
   g2.setRenderingHints(rh);
    g2.setStroke(new BasicStroke(3));
    g2.drawArc(26, 26, 119, 119, 0, 360);
  
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new MainClass());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,200);
    frame.setVisible(true);
  }
}
