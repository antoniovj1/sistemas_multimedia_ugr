/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionaula;

/**
 *
 * @author antonio
 */
public class Delegado extends Alumno {
    public static int puntos_delegados;
    public int clase;
    
    public Delegado (int clas, String nom){
        super(nom);
        clase = clas;        
    }
    
    public void sumarPuntos(){
        puntos_delegados+=10;
    }
}
