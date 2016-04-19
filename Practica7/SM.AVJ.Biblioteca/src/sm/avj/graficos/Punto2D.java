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
public class Punto2D extends java.awt.geom.Line2D.Double
        implements miShape {

    /**
     * Contructor por defecto.
     */
    public Punto2D() {
        super();
    }

    /**
     * Crea un punto a partir del valor del primer parámetro. El SEGUNDO
     * parámetro está para mantener la misma estructura que las demás clases
     * pero NO SE USA.
     *
     * @param p1
     * @param pNull
     */
    public Punto2D(Point2D p1, Point2D pNull) {
        super(p1, p1);
    }

    @Override
    /**
     * Establece un punto. El SEGUNDO parámetro está para mantener la misma
     * estructura que las demás clases pero NO SE USA.
     *
     * @param p1
     * @param pNull
     */
    public void setPoints(Point2D p1, Point2D pNull) {
        super.setLine(p1, p1);
    }

    @Override
    public void setPoint1(Point2D p) {
        super.setLine(p, p);
    }

    @Override
    /**
     * Realiza la misma función que setPoint1(Point2D p);
     *
     * @param p
     */
    public void setPoint2(Point2D p) {
        setPoint1(p);
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
