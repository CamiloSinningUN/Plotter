/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficador;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author camil
 */
public class Cartesian {
    
   public static void Begin(Graphics g, JPanel panel){
        g.setColor(Color.BLACK);
        int mx = panel.getWidth()/2;
        int my = panel.getHeight()/2;
        int fx = panel.getWidth();
        int fy = panel.getHeight();
        g.drawLine(mx, 0, mx, fy);
        g.drawLine(0,my,fx,my);
        for (int i = 0; i < panel.getWidth(); i+=10) {          
           g.drawLine(i,my-2,i,my+2);
        }
        for (int i = 0; i < panel.getHeight(); i+=10) {
           g.drawLine(mx-2,i,mx+2,i);
        }        
   }
      
}
