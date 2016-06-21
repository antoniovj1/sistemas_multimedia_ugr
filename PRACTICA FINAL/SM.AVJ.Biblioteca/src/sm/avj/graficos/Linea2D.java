package sm.avj.graficos;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author antonio
 */
public class Linea2D extends MiShape {

    /**
     * Contructor por defecto.
     */
    public Linea2D() {
        geometria = new Line2D.Double();
    }

    /**
     * Crea una línea a partir de dos puntos.
     *
     * @param p1
     */
    public Linea2D(Point2D p1) {
        geometria = new Line2D.Double(p1, p1);
    }

    /**
     * Crea una línea a partir de dos puntos.
     *
     * @param p1
     * @param p2
     */
    public Linea2D(Point2D p1, Point2D p2) {
        geometria = new Line2D.Double(p1, p2);
    }

    /**
     * Este metodo establece los dos puntos que forman un MiShape.
     *
     * @param p1
     * @param p2
     */
    public void setPoints(Point2D p1, Point2D p2) {
        ((Line2D) geometria).setLine(p2, p1);
    }

    /**
     * Este metodo permite comprobar si un punto cerca de una línea.
     *
     * @param p
     * @return true si el punto esta a una distancia menor de 3 de la figura.
     */
    private boolean isNear(Point2D p) {
        return ((Line2D) geometria).ptLineDist(p) <= 3.0;
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
        Point2D pIni = ((Line2D) geometria).getP1();
        Point2D pFin = ((Line2D) geometria).getP2();

        pIni.setLocation(pIni.getX() + pos.getX(), pIni.getY() + pos.getY());
        pFin.setLocation(pFin.getX() + pos.getX(), pFin.getY() + pos.getY());

        ((Line2D) geometria).setLine(pIni, pFin);
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        this.setPoints(p1, p2);
    }
}
