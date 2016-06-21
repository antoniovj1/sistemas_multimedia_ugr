package sm.avj.graficos;

import java.awt.geom.Line2D;
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


    /**
     * Este metodo permite comprobar si un punto cerca de un punto.
     *
     * @param p
     * @return true si el punto esta a una distancia menor de 5 de la figura.
     */
    private boolean isNear(Point2D p) {
        return ((Line2D)geometria).getP1().distance(p) <= 5.0;
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

}
