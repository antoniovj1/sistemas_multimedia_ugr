/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 *
 * @author antonio
 */
public class Linea2D extends java.awt.geom.Line2D.Double
        implements miShape {

    Atributos attr = new Atributos();

    /**
     * Contructor por defecto.
     */
    public Linea2D() {
        super();
    }

    /**
     * Crea una línea a partir de dos puntos.
     *
     * @param p1
     */
    public Linea2D(Point2D p1) {
        super(p1, p1);
    }

    /**
     * Crea una línea a partir de dos puntos.
     *
     * @param p1
     * @param p2
     */
    public Linea2D(Point2D p1, Point2D p2) {
        super(p1, p2);
    }

    /**
     * Este metodo establece los dos puntos que forman un miShape.
     *
     * @param p1
     * @param p2
     */
    public void setPoints(Point2D p1, Point2D p2) {
        super.setLine(p2, p1);
    }

    @Override
    public void setPointIni(Point2D p) {
        super.setLine(p, super.getP2());
    }

    @Override
    public void setPointFin(Point2D p) {
        super.setLine(super.getP1(), p);
    }

    /**
     * Este metodo permite comprobar si un punto cerca de una línea.
     *
     * @param p
     * @return true si el punto esta a una distancia menor de 3 de la figura.
     */
    private boolean isNear(Point2D p) {
        return this.ptLineDist(p) <= 3.0;
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
        Point2D pIni = this.getPointIni();
        Point2D pFin = this.getPointFin();

        pIni.setLocation(pIni.getX() + pos.getX(), pIni.getY() + pos.getY());
        pFin.setLocation(pFin.getX() + pos.getX(), pFin.getY() + pos.getY());

        this.setLine(pIni, pFin);
    }

    @Override
    public Point2D getPointIni() {
        return super.getP1();
    }

    @Override
    public Point2D getPointFin() {
        return super.getP2();
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
