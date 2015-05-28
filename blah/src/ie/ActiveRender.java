package ie;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import java.util.Random;

import javax.swing.JFrame;



/*

 * This is an example of a simple windowed render loop

 */

public class ActiveRender {



  public static void main( String[] args ) {

                

    // Create game window...

    JFrame app = new JFrame();

    app.setIgnoreRepaint( true );

    app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

                

    // Create canvas for painting...

    Canvas canvas = new Canvas();

    canvas.setIgnoreRepaint( true );

    canvas.setSize( 650, 650 );

                

    // Add canvas to game window...

    app.add( canvas );

    app.pack();

    app.setVisible( true );

                

    // Create BackBuffer...

    canvas.createBufferStrategy( 2 );

    BufferStrategy buffer = canvas.getBufferStrategy();



    // Get graphics configuration...

    GraphicsEnvironment ge = 

        GraphicsEnvironment.getLocalGraphicsEnvironment();

    GraphicsDevice gd = ge.getDefaultScreenDevice();

    GraphicsConfiguration gc = gd.getDefaultConfiguration();



    // Create off-screen drawing surface

    BufferedImage bi = gc.createCompatibleImage( 650, 650 );



    // Objects needed for rendering...

    Graphics graphics = null;

    Graphics2D g2d = null;
    
    RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

    Color background = Color.BLACK;

                

    // Variables for counting frames per seconds

    int fps = 0;

    int frames = 0;

    long totalTime = 0;
    long elapsedTime =0;

    long curTime = System.nanoTime();


    long lastTime = curTime;
    
    int speed = 50;
    int seconds = 0;
    long nano = 1000000000;
    
    double displacement = 0;
    Point2D position = new Point2D.Double(0.0,0.0);

                

    while( true ) {

      try {

        // count Frames per second...

        lastTime = curTime;

        curTime = System.nanoTime();
        elapsedTime = curTime - lastTime;

        totalTime += curTime - lastTime;

        if( totalTime > nano ) {
seconds++;
          totalTime -= nano;

          fps = frames;

          frames = 0;

        } 

        ++frames;



        // clear back buffer...

        g2d = bi.createGraphics();
        
        
	   g2d.setRenderingHints(rh);

        g2d.setColor( background );

        g2d.fillRect( 0, 0, 650, 650 );

                                

        // draw some rectangles...

        

          g2d.setColor( Color.WHITE );

          
          displacement = speed*(elapsedTime/(nano+0.0));

          System.out.println("ElaspsedTime :"+elapsedTime);
          System.out.println("Displacement :"+displacement);
          
          if(seconds >= 2){
          
          position.setLocation(position.getX()+displacement, position.getY()+displacement);
          
          }
          
          g2d.fillRect( (int)position.getX(), (int)position.getY(), 150, 150 );

        

                                

        // display frames per second...

        g2d.setFont( new Font( "Courier New", Font.PLAIN, 12 ) );

        g2d.setColor( Color.GREEN );

        g2d.drawString( String.format( "FPS: %s	Frames: %s	Sec: %s",fps, frames,seconds ), 20, 20 );

                                

        // Blit image and flip...

        graphics = buffer.getDrawGraphics();

        graphics.drawImage( bi, 0, 0, null );

        if( !buffer.contentsLost() )

          buffer.show();

                                

        // Let the OS have a little time...

       Thread.yield();

      } finally {

        // release resources

        if( graphics != null ) 

          graphics.dispose();

        if( g2d != null ) 

          g2d.dispose();

      }

    }

  }

}
