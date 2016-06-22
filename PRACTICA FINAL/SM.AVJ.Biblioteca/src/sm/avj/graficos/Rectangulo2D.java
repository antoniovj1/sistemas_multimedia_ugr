package sm.avj.graficos;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author antonio
 */
public class Rectangulo2D extends MiShape {

    /**
     * Constructor por defecto.
     */
    public Rectangulo2D() {
        geometria = new Rectangle2D.Double();
    }

    /**
     * Crea un rectangulo a partir de dos puntos.
     *
     * @param p1
     */
    public Rectangulo2D(Point2D p1) {
        geometria = new Rectangle2D.Double();

        ((Rectangle2D) geometria).setFrameFromDiagonal(p1, p1);
    }

    /**
     * Crea un rectangulo a partir de dos puntos.
     *
     * @param p1
     * @param p2
     */
    public Rectangulo2D(Point2D p1, Point2D p2) {
        geometria = new Rectangle2D.Double();

        ((Rectangle2D) geometria).setFrameFromDiagonal(p1, p2);
    }

    public Rectangulo2D(Rectangle2D rec) {
        geometria = new Rectangle2D.Double();
        Point2D p1 = new Point2D.Double(rec.getMaxX(), rec.getMaxY());
        Point2D p2 = new Point2D.Double(rec.getMinX(), rec.getMinY());

        ((Rectangle2D) geometria).setFrameFromDiagonal(p1, p2);
    }

    public void setRectangulo(Rectangle2D rec) {
        Point2D p1 = new Point2D.Double(rec.getMaxX(), rec.getMaxY());
        Point2D p2 = new Point2D.Double(rec.getMinX(), rec.getMinY());

        ((Rectangle2D) geometria).setFrameFromDiagonal(p1, p2);
    }

    /**
     * Este metodo establece los dos puntos que forman un MiShape.
     *
     * @param p1
     * @param p2
     */
    public void setPoints(Point2D p1, Point2D p2) {
        ((Rectangle2D) geometria).setFrameFromDiagonal(p1, p2);
    }

    @Override
    public void setLocation(Point2D pos) {
        Point2D esquina = new Point2D.Double(((Rectangle2D) geometria).getX(), ((Rectangle2D) geometria).getY());
        esquina.setLocation(esquina.getX() + pos.getX(), esquina.getY() + pos.getY());
        
        ((Rectangle2D) geometria).setFrame(esquina, new Dimension((int) ((Rectangle2D) geometria).getWidth(), (int) ((Rectangle2D) geometria).getHeight()));
    }

    @Override
    public boolean contains(Point2D p) {
        return geometria.contains(p);
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        ((Rectangle2D) geometria).setFrameFromDiagonal(p1, p2);
    }
}
