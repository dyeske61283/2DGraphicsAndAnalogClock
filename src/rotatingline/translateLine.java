/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rotatingline;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

/**
 *
 * @author kevin
 */
public class translateLine extends JPanel implements Runnable
{
  private Line2D.Double kurve;
  private Color farbe;
  final float DICKE = 5f;
  private double winkel;
  private Thread thd;
  private long zeit;
  private AffineTransform at;
  
  public translateLine(long zeit)
  {
     this.zeit = zeit;
     kurve = new Line2D.Double();
     at = new AffineTransform();
     this.setBackground(Color.BLACK);
     farbe = Color.GREEN;
     winkel = 0;
     thd = null;
  }

  public void start()
  {
    if(thd == null)
    {
      thd = new Thread(this);
      thd.start();
    }
  }
  
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                        RenderingHints.VALUE_ANTIALIAS_ON);
    int w = this.getWidth() - 1;
    int h = this.getHeight() - 1;
    
    double x1 = w/2.0;
    double y1 = h/2.0;
    double x2 = w/2.0;
    double y2 = 0;
    
    kurve.setLine(x1, y1, x2, y2);
    
    g2.setStroke(new BasicStroke(DICKE));
    g2.setTransform(this.at);
    g2.setPaint(farbe);
    g2.draw(kurve);
  }
  
  
  @Override
  public void run()
  {
   double delta = 1;
    while(true)
    {
      if(winkel == 360) winkel = 0;
      winkel += delta;
      this.at.rotate(Math.toRadians(winkel),
                     (this.getWidth() - 1)/2.0, (this.getHeight() -1)/2.0);
      this.repaint();
      
      try
      {
        Thread.sleep(zeit);
      }
      catch(InterruptedException ex)
      {
      //  lg.severe(ex.toString());
      }
    }
  }
}
