/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficador;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author camil
 */
public class Graficar {

    public static ArrayList<Equation> ParseEquation(String Equation) {
        ArrayList<Equation> result = new ArrayList<>();
        String v[] = Equation.split(" ");
        boolean negativo = false;

        for (int i = 0; i < v.length; i++) {
            Equation eq = new Equation();
            try {
                int c = Integer.parseInt(v[i]);
                if (!negativo) {
                    eq.constant = c;
                    eq.exp = 0;
                } else {
                    eq.constant = -c;
                    eq.exp = 0;
                }
            } catch (NumberFormatException e) {

                if (v[i].equals("-")) {
                    negativo = true;
                }
                if ((!v[i].contains("**")) && (v[i].contains("*"))) {
                    String subV[] = v[i].split("\\*");
                    eq.constant = Integer.parseInt(subV[0]);
                    eq.exp = 1;
                }
                if (v[i].contains("**")) {
                    String subV[] = v[i].split("\\*");
                    eq.exp = Integer.parseInt(subV[subV.length - 1].substring(0));
                    eq.constant = 1;
                    //System.out.println("exp 0 es: "+eq.exp);
                }
                if (v[i].contains("/")) {
                    //puede ser solo un numero
                    //o un numero que multiplica
                    //o un elevado

                    //Se hara de ultimo 
                }
                if (v[i].equals("x")) {
                    eq.constant = 1;
                    eq.exp = 1;
                }
            }
            result.add(eq);
        }

        return result;
    }

    public static ArrayList<Par> calc(ArrayList<Equation> eq) {
        ArrayList<Par> result = new ArrayList<>();
        double y;

        for (int j = -Cartesian.presicion * 2; j < Cartesian.presicion * 2; j += 1) {
            y = 0;
            for (Equation e : eq) {
                System.out.println("exp es: " + e.exp);
                y = y + e.constant * Math.pow(j, e.exp);
            }

            Par p = new Par(j, y);
            System.out.println("par es: " + j + "," + y);
            result.add(p);
        }
        return result;
    }

    public static void Draw(ArrayList<Par> pares, JPanel panel) {
        Graphics g = panel.getGraphics();
        Random r = new Random();
        int color = r.nextInt(5 - 0) + 0;
        switch (color) {
            case 0:
                g.setColor(Color.RED);
                break;

            case 1:
                g.setColor(Color.BLUE);
                break;

            case 2:
                g.setColor(Color.BLACK);
                break;

            case 3:
                g.setColor(Color.orange);
                break;

            case 4:
                g.setColor(Color.GREEN);
                break;

            case 5:
                g.setColor(Color.YELLOW);
                break;
        }

        for (Par p : pares) {
            g.fillOval((int) Cartesian.getx((int) p.x), (int) Cartesian.gety((int) p.y), 2, 2);
            //System.out.println("x es: "+(int)Cartesian.getx((int)p.x)+" y es: "+(int) Cartesian.gety((int)p.y));
        }
    }
}
