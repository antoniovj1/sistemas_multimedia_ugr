/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author antonio
 */
public class Rectangulo2D extends java.awt.geom.Rectangle2D.Double
        implements miShape {

    Atributos attr = new Atributos();

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
     */
    public Rectangulo2D(Point2D p1) {
        super();

        this.setFrameFromDiagonal(p1, p1);
        this.p1 = p1;
        this.p2 = p1;
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

    public Rectangulo2D(Rectangle2D rec) {
        super();
        this.p1 = new Point2D.Double(rec.getMaxX(), rec.getMaxY());
        this.p2 = new Point2D.Double(rec.getMinX(), rec.getMinY());

        this.setFrameFromDiagonal(p1, p2);
    }

    public void setRectangulo(Rectangle2D rec) {
        this.p1 = new Point2D.Double(rec.getMaxX(), rec.getMaxY());
        this.p2 = new Point2D.Double(rec.getMinX(), rec.getMinY());

        this.setFrameFromDiagonal(p1, p2);
    }

    /**
     * Este metodo establece los dos puntos que forman un miShape. throw new
     * UnsupportedOperationException("Not supported yet."); //To change body of
     * generated methods, choose Tools | Templates.
     *
     * @param p1
     * @param p2
     */
    public void setPoints(Point2D p1, Point2D p2) {
        this.setFrameFromDiagonal(p1, p2);
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void setPointIni(Point2D p) {
        this.setFrameFromDiagonal(p, p2);
    }

    @Override
    public void setPointFin(Point2D p) {
        this.setFrameFromDiagonal(p1, p);
    }

    @Override
    public void setLocation(Point2D pos) {
        Point2D esquina = this.getPointIni();
        // Muevo la figura añadiendo el punto calculado anteriormente 
        //para evitar que se mueva desde la esquina.
        esquina.setLocation(esquina.getX() + pos.getX(), esquina.getY() + pos.getY());
        this.setFrame(esquina, new Dimension((int) this.width, (int) this.height));

    }

    @Override
    public Point2D getPointIni() {
        return new Point2D.Double(this.getBounds2D().getX(), this.getBounds2D().getY());
    }

    @Override
    public void paint(Graphics2D g2d) {

        attr.conf(g2d);

        if (isRelleno()) {
            g2d.fill(this);
        }

        g2d.draw(this);
    }

    @Override
    public boolean isAlisado() {
        return attr.isAlisado();
    }

    @Override
    public void setAlisado(boolean alisado) {
        attr.setAlisado(alisado);
    }

    @Override
    public boolean isTransparencia() {
        return attr.isTransparencia();
    }

    @Override
    public void setTransparencia(boolean transparencia) {
        attr.setTransparencia(transparencia);
    }

    @Override
    public boolean isRelleno() {
        return attr.isRelleno();
    }

    @Override
    public void setRelleno(boolean relleno) {
        attr.setRelleno(relleno);
    }

    @Override
    public Color getColor() {
        return attr.getColor();
    }

    @Override
    public void setColor(Color color) {
        attr.setColor(color);
    }

    @Override
    public Stroke getStroke() {
        return attr.getStroke();
    }

    @Override
    public void setStroke(Stroke stroke) {
        attr.setStroke(stroke);
    }

    @Override
    public Point2D getPointFin() {
        return this.p2;
    }

    @Override
    public void setTransparenciaValue(float val) {
        attr.setTransparenciaValue(val);
    }

    @Override
    public float getTransparenciaVlaue() {
        return attr.getTrnaspareciaValue();
    }

    @Override
    public void setStrokeDash(float[] dash) {
        attr.setStrokeDash(dash);
    }

    @Override
    public void setStrokeWidth(float w) {
        attr.setStrokeWidth(w);
    }
}
