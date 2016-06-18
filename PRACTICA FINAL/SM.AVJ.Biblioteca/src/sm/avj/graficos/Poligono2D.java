/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 *
 * @author antonio
 */
public final class Poligono2D extends Polygon
        implements miShape {

    Atributos attr = new Atributos();

    public Poligono2D() {
        super();
    }

    public Poligono2D(Point2D p) {
        super();
        this.addPoint(p);
    }

    public void addPoint(Point2D p) {
        this.addPoint((int) p.getX(), (int) p.getY());
    }

    @Override
    public void setPointIni(Point2D p) {
        this.addPoint(p);
    }

    @Override
    public void setPointFin(Point2D p) {
        this.addPoint(p);
    }

    @Override
    public Point2D getPointIni() {
        Point2D p = new Point2D.Double(this.xpoints[0], this.ypoints[0]);
        return p;
    }

    @Override
    /**
     * @TODO Preguntar por invalidate
     */
    public void setLocation(Point2D pos) {
        //this.translate((int)pos.getX(),(int)pos.getY() );
        for (int i = 0; i < this.npoints; i++) {
            this.xpoints[i] = (int) (this.xpoints[i] + pos.getX());
            this.ypoints[i] = (int) (this.ypoints[i] + pos.getY());
        }
        this.invalidate();
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
        return new Point2D.Double(this.xpoints[npoints - 1], this.ypoints[npoints - 1]);
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
