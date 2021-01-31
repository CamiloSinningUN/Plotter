/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficador;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Cartesian {
    
    public static class plane{
        public float cc;
        public float cd;

        public plane(float cc, float cd) {
            this.cc = cc;
            this.cd = cd;
        }
        
    } 
   
   public static ArrayList<plane> corx = new ArrayList<>();
   public static ArrayList<plane> cory = new ArrayList<>();
   
   public static double getx(double cc){
       for (plane o : corx) {
           if(o.cc == cc)
               return o.cd;
           
       }
       return 1000;
           
   }
    public static double gety(double cc){
       for (plane o : cory) {
           if(o.cc == cc)
               return o.cd;         
       }
       return 1000;
           
   }
   public static int presicion = 5;
   
   public static void Begin(Graphics g, JPanel panel){
        g.setColor(Color.BLACK);
        int mx = panel.getWidth()/2;
        int my = panel.getHeight()/2;
        int fx = panel.getWidth();
        int fy = panel.getHeight();
        g.drawLine(mx, 0, mx, fy);
        g.drawLine(0,my,fx,my);
        int cc = -panel.getWidth()/(presicion*2) ;
        for (int i = 0; i < panel.getWidth(); i+=presicion) {          
           g.drawLine(i,my-2,i,my+2);          
           plane p = new plane(cc,i);
           cc++;
           corx.add(p);
        }
        cc = -panel.getHeight()/(presicion*2) -1;
        for (int i = panel.getHeight(); i > 0 ; i-=presicion) {
           g.drawLine(mx-2,i,mx+2,i);
           plane p = new plane(cc,i);
           cc++;
           cory.add(p);
           
        }  
   }
   
      
}
