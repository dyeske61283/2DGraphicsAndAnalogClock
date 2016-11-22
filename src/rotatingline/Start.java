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
    
    translateLine tL = new translateLine(800);
    kiste.add(tL);
    
    frm.setSize(300,300);
    frm.setLocationRelativeTo(null);
    frm.setTitle("Rotating Line");
    frm.setVisible(true);
    
    tL.start();
//    rL.start();
  }
}
