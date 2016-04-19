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
public class Linea2D extends java.awt.geom.Line2D.Double
        implements miShape {

    /**
     * Contructor por defecto.
     */
    public Linea2D() {
        super();
    }

    /**
     * Crea una línea a partir de dos puntos.
     *
     * @param p1
     * @param p2
     */
    public Linea2D(Point2D p1, Point2D p2) {
        super(p1, p2);
    }

    @Override
    public void setPoints(Point2D p1, Point2D p2) {
        super.setLine(p2, p1);
    }

    @Override
    public void setPoint1(Point2D p) {
        super.setLine(p, super.getP2());
    }

    @Override
    public void setPoint2(Point2D p) {
        super.setLine(super.getP1(), p);
    }

    /**
     * Este metodo permite comprobar si un punto cerca de una línea.
     *
     * @param p
     * @return true si el punto esta a una distancia menor de 3 de la figura.
     */
    private boolean isNear(Point2D p) {
        return this.ptLineDist(p) <= 3.0;
    }

    @Override
    /**
     * Este metodo permite comprobar si un punto sobre una línea o muy cerca.
     *
     * @param p
     * @return true si el punto esta a una distancia menor de 3 de la figura.
     */
    public boolean contains(Point2D p) {
        return isNear(p);
    }

    @Override
    public void setLocation(Point2D pos) {
        double dx = pos.getX() - this.getX1();
        double dy = pos.getY() - this.getY1();
        Point2D newp2 = new Point2D.Double(this.getX2() + dx, this.getY2() + dy);
        this.setLine(pos, newp2);
    }

    @Override
    public Point2D getPoint1() {
        return super.getP1();
    }
}
