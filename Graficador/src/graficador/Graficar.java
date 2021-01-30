/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficador;

import java.util.ArrayList;
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
                    String subV[] = v[i].split("*");
                    eq.constant = Integer.parseInt(subV[0]);
                }
                if (v[i].contains("**")) {
                    String subV[] = v[i].split("*");
                    eq.exp = Integer.parseInt(subV[subV.length].substring(0));
                }
                if (v[i].contains("/")) {
                    //puede ser solo un numero
                    //o un numero que multiplica
                    //o un elevado
                    
                    //Se hara de ultimo 

                }
            }
            result.add(eq);
        }

        return result;
    }

    public static ArrayList<Par> calc(ArrayList<Equation> eq, JPanel panel) {
        
        ArrayList<Par> result = new ArrayList<>();
        for (int i = 0; i < panel.getHeight()/10; i+=10) {
            
        }
        
        return null;
    }
}
