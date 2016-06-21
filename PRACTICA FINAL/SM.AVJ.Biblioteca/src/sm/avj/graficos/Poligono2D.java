package sm.avj.graficos;

import java.awt.Polygon;
import java.awt.geom.Point2D;

/**
 *
 * @author antonio
 */
public final class Poligono2D extends MiShape {


    public Poligono2D() {
        geometria = new Polygon();
    }

    public Poligono2D(Point2D p) {
        geometria = new Polygon();
        this.addPoint(p);
    }

    public void addPoint(Point2D p) {
        ((Polygon)geometria).addPoint((int) p.getX(), (int) p.getY());
    }

    @Override
    /**
     * @TODO Preguntar por invalidate
     */
    public void setLocation(Point2D pos) {
        //((Polygon)geometria).translate((int)pos.getX(),(int)pos.getY() );
        for (int i = 0; i < ((Polygon)geometria).npoints; i++) {
            ((Polygon)geometria).xpoints[i] = (int) (((Polygon)geometria).xpoints[i] + pos.getX());
            ((Polygon)geometria).ypoints[i] = (int) (((Polygon)geometria).ypoints[i] + pos.getY());
        }
        ((Polygon)geometria).invalidate();
    }

    @Override
    public boolean contains(Point2D p) {
        return ((Polygon)geometria).contains(p);
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
