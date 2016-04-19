/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.graficos;

import java.awt.Dimension;
import java.awt.geom.Point2D;

/**
 *
 * @author antonio
 */
public class Rectangulo2D extends java.awt.geom.Rectangle2D.Double
        implements miShape {

    private Point2D p1;
    private Point2D p2;

    /**
     * Constructor por defecto.
     */
    public Rectangulo2D() {
        super();
        this.p1 = new Point2D.Double(0, 0);
        this.p2 = new Point2D.Double(0, 0);
    }

    /**
     * Crea un rectangulo a partir de dos puntos.
     *
     * @param p1
     * @param p2
     */
    public Rectangulo2D(Point2D p1, Point2D p2) {
        super();
        this.setFrameFromDiagonal(p1, p2);
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void setPoints(Point2D p1, Point2D p2) {
        this.setFrameFromDiagonal(p1, p2);
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void setPoint1(Point2D p) {
        this.setFrameFromDiagonal(p, p2);
    }

    @Override
    public void setPoint2(Point2D p) {
        this.setFrameFromDiagonal(p1, p);
    }

    @Override
    public void setLocation(Point2D pos) {
        this.setFrame(pos, new Dimension((int) this.width, (int) this.height));

    }

    @Override
    public Point2D getPoint1() {
        return new Point2D.Double(this.getBounds2D().getX(), this.getBounds2D().getY());
    }

}
