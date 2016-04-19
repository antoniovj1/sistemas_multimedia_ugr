/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.ui;

/**
 *
 * @author antonio
 */
public enum Forma {
    PUNTO("sm.avj.graficos.Punto2D"),
    LINEA("sm.avj.graficos.Linea2D"),
    RECTANGULO("sm.avj.graficos.Rectangulo2D"),
    ELIPSE("sm.avj.graficos.Elipse2D");

    private final String nombreClase;

    private Forma(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getNombreClase() {
        return nombreClase;
    }

}
