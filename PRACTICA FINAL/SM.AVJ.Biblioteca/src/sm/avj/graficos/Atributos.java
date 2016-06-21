/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.graficos;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 *
 * @author antonio
 */
public class Atributos {

    Color colorFrente;
    Color colorFondo;
    Stroke stroke;
    float transp;

    AlphaComposite comp;
    RenderingHints antialiasing;
    GradientPaint gradiente;

    boolean alisado;
    boolean transparencia;
    boolean relleno;
    boolean gradienteB;

    Point2D p1 = null;
    Point2D p2 = null;
    int tipoGrad;

    public Atributos() {
        colorFrente = Color.BLACK;
        colorFondo = Color.BLACK;
        tipoGrad = 0;
        transp = 0.5f;
        stroke = new BasicStroke(1.0f);
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transp);
        antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        alisado = false;
        transparencia = false;
        relleno = false;
        gradienteB = false;
    }

    public void conf(Graphics2D g2d) {
        g2d.setPaint(colorFrente);
        g2d.setStroke(stroke);

        if (isTransparencia()) {
            g2d.setComposite(comp);
        }

        if (isAlisado()) {
            g2d.setRenderingHints(antialiasing);
        }

        if (isGradiente()) {
            g2d.setPaint(gradiente);
        }
    }

    public boolean isAlisado() {
        return alisado;
    }

    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
    }

    public boolean isTransparencia() {
        return transparencia;
    }

    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
    }

    public void setTransparenciaValue(float val) {
        if (val > 1.0f) {
            val = 1.0f;
        } else if (val < 0.0f) {
            val = 0.0f;
        }

        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, val);
        transp = val;
        transparencia = true;
    }

    public float getTrnaspareciaValue() {
        return transp;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public Color getColorFrente() {
        return colorFrente;
    }

    public void setColorFrente(Color color) {
        this.colorFrente = color;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public void setStrokeDash(float[] dash) {
        int cap = ((BasicStroke) stroke).getEndCap();
        int join = ((BasicStroke) stroke).getLineJoin();
        float width = ((BasicStroke) stroke).getLineWidth();

        stroke = new BasicStroke(width, cap, join, 10.0f, dash, 0.0f);
    }

    public void setStrokeWidth(float w) {
        int cap = ((BasicStroke) stroke).getEndCap();
        int join = ((BasicStroke) stroke).getLineJoin();
        float dash[] = ((BasicStroke) stroke).getDashArray();

        stroke = new BasicStroke(w, cap, join, 10.0f, dash, 0.0f);
    }

    public boolean isGradiente() {
        return gradienteB;
    }

    public void setGradiente(boolean gradienteB) {
        this.gradienteB = gradienteB;
    }

    public void setConfigGradiente(int tipo, miShape s) {
        tipoGrad = tipo;

        calcularPuntosGradiente(tipo, s);

        gradiente = new GradientPaint(p1, colorFrente, p2, colorFondo);
        gradienteB = true;
    }

    void updateGradiente(miShape s) {
        calcularPuntosGradiente(tipoGrad, s);
        gradiente = new GradientPaint(p1, colorFrente, p2, colorFondo);
    }

    public int getTipoGrad() {
        return tipoGrad;
    }

    
    private void calcularPuntosGradiente(int tipo, miShape s) {
        Rectangulo2D rect = new Rectangulo2D(s.getBounds2D());
        switch (tipo) {
            case 1: // Horizontal
                p1 = new Point2D.Double(rect.getX(), rect.getY());
                p2 = new Point2D.Double(rect.getX() + rect.width, rect.getY());
                break;
            case 2: // Vertical
                p1 = new Point2D.Double(rect.getX(), rect.getY());
                p2 = new Point2D.Double(rect.getX(), rect.getY() + rect.height);
                break;
            case 3: // Diagonal
                p1 = new Point2D.Double(rect.getX(), rect.getY());
                p2 = new Point2D.Double(rect.getX() + rect.width, rect.getY() + rect.height);
                break;
        }
    }
}
