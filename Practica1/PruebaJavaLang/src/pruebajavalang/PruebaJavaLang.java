/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajavalang;

/**
 *
 * @author antonio
 */
public class PruebaJavaLang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double d = 3.7;
        double i = 37;
        
        System.out.println(Math.abs(d)); // Calcular valor absoluto
        System.out.println(Math.sqrt(i)); //Calcular raiz cuadrada
        
        int a = 5;
        String b ;
        b = Integer.toString(a);
        b = String.valueOf(a); //Es lo mismo
        
        int c;
        c = Integer.parseInt(b);// String a int
        
        float e = Float.MAX_VALUE; //Valor máximo para un float.
        
        
        String f = "Hola";
        System.out.println(f.charAt(1));
        
        String g = "hola";
        int test = g.compareTo(f);
        boolean test2 = g.equals(f);
        
        g = g.concat("adios"); //Concatenar
        
        System.out.println(g);
        
        
        
        
        
        
        
        
    }
    
}
