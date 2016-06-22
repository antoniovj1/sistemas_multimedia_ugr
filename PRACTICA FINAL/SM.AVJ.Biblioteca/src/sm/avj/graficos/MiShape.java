package sm.avj.graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

//Preguntar jerarquia....
/**
 *
 * @author antonio
 */
public abstract class MiShape {

    Atributos attr = new Atributos();
    Shape geometria;

    
    /**
     * Este metodo permite comprobar si un punto esta encima de una figura.
     *
     * @param p
     * @return true si el punto esta sobre la figura.
     */

    public abstract boolean contains(Point2D p);

    /**
     * Este metodo establece la posición de la esquina superior izquierda de una
     * figura.
     *
     * @param pos
     */
    public abstract void setLocation(Point2D pos);

    public abstract void updateShape(Point2D p1, Point2D p2);

    public Rectangle2D getBounds() {
        return geometria.getBounds2D();
    }

    public void paint(Graphics2D g2d) {

        attr.conf(g2d);

        if (isRelleno()) {
            g2d.fill(geometria);
        }
        if (attr.isGradiente()) {
            attr.updateGradiente(this);
        }

        g2d.draw(geometria);
    }

    public boolean isAlisado() {
        return attr.isAlisado();
    }

    public void setAlisado(boolean alisado) {
        attr.setAlisado(alisado);
    }

    public boolean isTransparencia() {
        return attr.isTransparencia();
    }

    public void setTransparencia(boolean transparencia) {
        attr.setTransparencia(transparencia);
    }

    public boolean isRelleno() {
        return attr.isRelleno();
    }

    public void setRelleno(boolean relleno) {
        attr.setRelleno(relleno);
    }

    public Color getColorFrente() {
        return attr.getColorFrente();
    }

    public void setColorFrente(Color color) {
        attr.setColorFrente(color);
    }

    public Color getColorFondo() {
        return attr.getColorFondo();
    }

    public void setColorFondo(Color color) {
        attr.setColorFondo(color);
    }

    public Stroke getStroke() {
        return attr.getStroke();
    }

    public void setStroke(Stroke stroke) {
        attr.setStroke(stroke);
    }

    public void setTransparenciaValue(float val) {
        attr.setTransparenciaValue(val);
    }

    public float getTransparenciaVlaue() {
        return attr.getTrnaspareciaValue();
    }

    public void setStrokeDash(float[] dash) {
        attr.setStrokeDash(dash);
    }

    public void setStrokeWidth(float w) {
        attr.setStrokeWidth(w);
    }

    public void setGradiente(boolean gradiente) {
        attr.setGradiente(gradiente);
    }

    public boolean isGradiente() {
        return attr.isGradiente();
    }

    public void setConfigGradiente(int tipo) {
        attr.setConfigGradiente(tipo, this);
    }

    public int getTipoGradiente() {
        return attr.getTipoGrad();
    }

}
