/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rotatingline;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.OverlayLayout;
import javax.swing.WindowConstants;

/**
 * Builder Class
 * @author kevin
 */
public class Start
{
  public Start()
  {
    
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) 
  {
    JFrame frm = new JFrame();
    frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Container kiste = frm.getContentPane();
    kiste.setBackground(Color.BLACK);
    kiste.setLayout(new OverlayLayout(kiste));
    
//    RotatingLine rL = new RotatingLine(50);
//    kiste.add(rL);
    
    translateLine[] lines = new translateLine[3];

      lines[0] = new translateLine(1000);
      lines[0].setOpaque(false);
      kiste.add(lines[0]);
      lines[1] = new translateLine(60000);
      lines[1].setOpaque(false);
      kiste.add(lines[1]);
      lines[2] = new translateLine(3600000);
      lines[2].setOpaque(false);
      kiste.add(lines[2]);
//    translateLine tL = new translateLine(800);
//    kiste.add(tL);
    
      for(int i=0;i<lines.length;i++)
      {
        lines[i].start();
      }

    frm.setSize(300,300);
    frm.setLocationRelativeTo(null);
    frm.setTitle("Rotating Line");
    frm.setVisible(true);
    
//    tL.start();
//    rL.start();
  }
}
