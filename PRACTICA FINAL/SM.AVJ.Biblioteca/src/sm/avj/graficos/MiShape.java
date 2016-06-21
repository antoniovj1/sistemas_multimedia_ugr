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

//Preguntar jerarquia....
/**
 *
 * @author antonio
 */
public interface MiShape extends java.awt.Shape {

    /**
     * Este metodo establece el primer punto de la figura MiShape.
     *
     * @param p
     */
    void setPointIni(Point2D p);

    /**
     * Este metodo establece el segundo punto de la figura MiShape.
     *
     * @param p
     */
    void setPointFin(Point2D p);

    /**
     * Este metodo devuelve el primer punto de la figura MiShape.
     *
     * @return
     */
    Point2D getPointIni(); //Preguntar getBounds2D....

    /**
     * Este metodo devuelve el primer punto de la figura MiShape.
     *
     * @return
     */
    Point2D getPointFin(); //Preguntar getBounds2D....

    /**
     * Este metodo permite comprobar si un punto esta encima de una figura.
     *
     * @param p
     * @return true si el punto esta sobre la figura.
     */
    @Override
    boolean contains(Point2D p);

    /**
     * Este metodo establece la posición de la esquina superior izquierda de una
     * figura.
     *
     * @param pos
     */
    void setLocation(Point2D pos);

    Color getColorFrente();

    void setColorFrente(Color color);

    Color getColorFondo();

    void setColorFondo(Color color);

    Stroke getStroke();

    void setStroke(Stroke stroke);

    void setStrokeDash(float[] dash);

    void setStrokeWidth(float w);

    public boolean isAlisado();

    public void setAlisado(boolean alisado);

    public boolean isTransparencia();

    public void setTransparencia(boolean transparencia);

    public void setTransparenciaValue(float val);

    public float getTransparenciaVlaue();

    public boolean isRelleno();

    public void setRelleno(boolean relleno);

    public void setGradiente(boolean gradiente);

    public boolean isGradiente();

    public void setConfigGradiente(int tipo);

    public int getTipoGradiente();
    
    void paint(Graphics2D g2d);

}
