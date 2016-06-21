package sm.avj.graficos;

import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

/**
 *
 * @author antonio
 */
public final class CurvaQ2D extends MiShape {

    public CurvaQ2D() {
        super();
        geometria = new QuadCurve2D.Double();
    }

    public CurvaQ2D(Point2D p) {
        geometria = new QuadCurve2D.Double(p.getX(), p.getY(), p.getX(), p.getY(), p.getX(), p.getY());
    }

    public CurvaQ2D(Point2D pIni, Point2D pCtrl, Point2D pFin) {
        geometria = new QuadCurve2D.Double(pIni.getX(), pIni.getY(), pCtrl.getX(), pCtrl.getY(), pFin.getX(), pFin.getY());
    }

    public void setPointCtrl(Point2D p) {
        ((QuadCurve2D) geometria).setCurve(((QuadCurve2D) geometria).getP1(), p, ((QuadCurve2D) geometria).getP2());
    }

    @Override
    public void setLocation(Point2D pos) {
        Point2D pI = ((QuadCurve2D) geometria).getP1();
        Point2D pC = ((QuadCurve2D) geometria).getCtrlPt();
        Point2D pF = ((QuadCurve2D) geometria).getP2();

        pI.setLocation(pI.getX() + pos.getX(), pI.getY() + pos.getY());
        pF.setLocation(pF.getX() + pos.getX(), pF.getY() + pos.getY());
        pC.setLocation(pC.getX() + pos.getX(), pC.getY() + pos.getY());

        ((QuadCurve2D) geometria).setCurve(pI, pC, pF);
    }

    private Point2D puntoMedio(Point2D p1, Point2D p2) {
        double x = (p1.getX() + p2.getX()) / 2;
        double y = (p1.getY() + p2.getY()) / 2;

        return new Point2D.Double(x, y);
    }

    @Override
    public boolean contains(Point2D p) {
        return ((QuadCurve2D) geometria).contains(p);
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        Point2D pC = puntoMedio(p1, p2);

        ((QuadCurve2D) geometria).setCurve(p1, pC, p2);
    }

}
