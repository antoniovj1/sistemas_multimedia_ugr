/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.avj.graficos;

import java.awt.geom.Point2D;

//Preguntar jerarquia....
/**
 *
 * @author antonio
 */
public interface miShape extends java.awt.Shape {

    /**
     * Este metodo establece los dos puntos que forman un miShape.
     *
     * @param p1
     * @param p2
     */
    public void setPoints(Point2D p1, Point2D p2);

    /**
     * Este metodo establece el primer punto de la figura miShape.
     *
     * @param p
     */
    public void setPoint1(Point2D p);

    /**
     * Este metodo establece el segundo punto de la figura miShape.
     *
     * @param p
     */
    public void setPoint2(Point2D p);

    /**
     * Este metodo devuelve el primer punto de la figura miShape.
     *
     * @return
     */
    public Point2D getPoint1(); //Preguntar getBounds2D....

    /**
     * Este metodo permite comprobar si un punto esta encima de una figura.
     *
     * @param p
     * @return true si el punto esta sobre la figura.
     */
    @Override
    public boolean contains(Point2D p);

    /**
     * Este metodo establece la posición de la esquina superior izquierda de una
     * figura.
     *
     * @param pos
     */
    public void setLocation(Point2D pos);

}
