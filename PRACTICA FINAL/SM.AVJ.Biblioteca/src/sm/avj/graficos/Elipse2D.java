package sm.avj.graficos;

import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author antonio
 */
public class Elipse2D extends MiShape {
 

    /**
     * Constructor por defecto.
     */
    public Elipse2D() {
        this.geometria = new Ellipse2D.Double();
    }

    /**
     * Crea una elipse a partir de dos puntos.
     *
     * @param p1
     */
    public Elipse2D(Point2D p1) {
        this.geometria = new Ellipse2D.Double();
        ((Ellipse2D)geometria).setFrameFromDiagonal(p1, p1);
    }

    /**
     * Crea una elipse a partir de dos puntos.
     *
     * @param p1
     * @param p2
     */
    public Elipse2D(Point2D p1, Point2D p2) {
        this.geometria = new Ellipse2D.Double();
        ((Ellipse2D)geometria).setFrameFromDiagonal(p1, p2);
    }

    /**
     * Este metodo establece los dos puntos que forman un MiShape.
     *
     * @param p1
     * @param p2
     */
    public void setPoints(Point2D p1, Point2D p2) {
        ((Ellipse2D)geometria).setFrameFromDiagonal(p1, p2);
    }

    @Override
    public void setLocation(Point2D pos) {
        Point2D esquina = new Point2D.Double(((Ellipse2D)geometria).getX(), ((Ellipse2D)geometria).getY());
        esquina.setLocation(esquina.getX() + pos.getX(), esquina.getY() + pos.getY());
        
        ((Ellipse2D)geometria).setFrame(esquina, new Dimension((int) ((Ellipse2D)geometria).getWidth(), (int) ((Ellipse2D)geometria).getHeight()));

    }

    @Override
    public boolean contains(Point2D p) {
        return ((Ellipse2D)geometria).contains(p);
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        ((Ellipse2D) geometria).setFrameFromDiagonal(p1, p2);
    }
}
