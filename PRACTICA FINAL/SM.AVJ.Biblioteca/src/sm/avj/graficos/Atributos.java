/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.graficos;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;

/**
 *
 * @author antonio
 */
public class Atributos {

    Color color;
    Stroke stroke;
    float transp;

    AlphaComposite comp;
    RenderingHints antialiasing;

    boolean alisado;
    boolean transparencia;
    boolean relleno;

    public Atributos() {
        color = Color.BLACK;
        transp = 0.5f;
        stroke = new BasicStroke(1.0f);
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transp);
        antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        alisado = false;
        transparencia = false;
        relleno = false;
    }

    public void conf(Graphics2D g2d) {
        g2d.setPaint(color);
        g2d.setStroke(stroke);

        if (isTransparencia()) {
            g2d.setComposite(comp);
        }

        if (isAlisado()) {
            g2d.setRenderingHints(antialiasing);
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

}
