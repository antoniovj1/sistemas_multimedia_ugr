/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.graficos;

import java.awt.geom.Point2D;

/**
 *
 * @author antonio
 */
public class Punto2D extends Linea2D {

    /**
     * Contructor por defecto.
     */
    public Punto2D() {
        super();
    }

    /**
     * Crea un punto a partir del valor del parámetro.
     *
     * @param p1
     */
    public Punto2D(Point2D p1) {
        super(p1, p1);
    }

    @Override
    public void setPointIni(Point2D p) {
        super.setLine(p, p);
    }

    @Override
    /**
     * Realiza la misma función que setPoint1(Point2D p);
     *
     * @param p
     */
    public void setPointFin(Point2D p) {
        setPointIni(p);
    }

    /**
     * Este metodo permite comprobar si un punto cerca de un punto.
     *
     * @param p
     * @return true si el punto esta a una distancia menor de 5 de la figura.
     */
    private boolean isNear(Point2D p) {
        return this.getP1().distance(p) <= 5.0;
    }

    @Override
    /**
     * Este metodo permite comprobar si un punto sobre un punto o muy cerca.
     *
     * @param p
     * @return true si el punto esta a una distancia menor de 5 de la figura.
     */
    public boolean contains(Point2D p) {
        return isNear(p);
    }

    @Override
    public Point2D getPointIni() {
        return super.getP1();
    }

}
