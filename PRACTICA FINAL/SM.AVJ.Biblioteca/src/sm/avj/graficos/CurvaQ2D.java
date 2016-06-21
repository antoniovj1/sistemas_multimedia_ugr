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
import java.awt.geom.QuadCurve2D;

/**
 *
 * @author antonio
 */
public final class CurvaQ2D extends QuadCurve2D.Double
        implements miShape {

    Atributos attr = new Atributos();
    private Point2D pI = new Point2D.Double();
    private Point2D pF = new Point2D.Double();
    private Point2D pC = new Point2D.Double();

    public CurvaQ2D() {
        super();
    }

    public CurvaQ2D(Point2D p) {
        super(p.getX(), p.getY(), p.getX(), p.getY(), p.getX(), p.getY());

        pI = p;
        pF = p;
        pC = p;
    }

    public CurvaQ2D(Point2D pIni, Point2D pCtrl, Point2D pFin) {
        super(pIni.getX(), pIni.getY(), pCtrl.getX(), pCtrl.getY(), pFin.getX(), pFin.getY());
        pI = pIni;
        pF = pFin;
        pC = pCtrl;
    }

    @Override
    public void setPointIni(Point2D p) {
        this.setCurve(p, pC, pF);
        pI = p;
    }

    @Override
    public void setPointFin(Point2D p) {
        pC = puntoMedio(pI, p);
        pF = p;

        this.setCurve(pI, pC, pF);

    }

    public void setPointCtrl(Point2D p) {
        this.setCurve(pI, p, pF);
        pC = p;
    }

    @Override
    public Point2D getPointIni() {
        return pI;
    }

    @Override
    public Point2D getPointFin() {
        return pF;
    }

    public Point2D getPointCtrl() {
        return pC;
    }

    @Override
    public void setLocation(Point2D pos) {
        pI.setLocation(pI.getX() + pos.getX(), pI.getY() + pos.getY());
        pF.setLocation(pF.getX() + pos.getX(), pF.getY() + pos.getY());
        pC.setLocation(pC.getX() + pos.getX(), pC.getY() + pos.getY());

        this.setCurve(pI, pC, pF);
    }

    @Override
    public void paint(Graphics2D g2d) {

        attr.conf(g2d);

        if (isRelleno()) {
            g2d.fill(this);
        }

        if (attr.isGradiente()) {
            attr.updateGradiente(this);
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
    public Color getColorFrente() {
        return attr.getColorFrente();
    }

    @Override
    public void setColorFrente(Color color) {
        attr.setColorFrente(color);
    }

    @Override
    public Color getColorFondo() {
        return attr.getColorFondo();
    }

    @Override
    public void setColorFondo(Color color) {
        attr.setColorFondo(color);
    }

    @Override
    public Stroke getStroke() {
        return attr.getStroke();
    }

    @Override
    public void setStroke(Stroke stroke) {
        attr.setStroke(stroke);
    }

    private Point2D puntoMedio(Point2D p1, Point2D p2) {
        double x = (p1.getX() + p2.getX()) / 2;
        double y = (p1.getY() + p2.getY()) / 2;

        return new Point2D.Double(x, y);
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

    @Override
    public void setGradiente(boolean gradiente) {
        attr.setGradiente(gradiente);
    }

    @Override
    public boolean isGradiente() {
        return attr.isGradiente();
    }

    @Override
    public void setConfigGradiente(int tipo) {
        attr.setConfigGradiente(tipo, this);
    }

    @Override
    public int getTipoGradiente() {
        return attr.getTipoGrad();
    }
}
