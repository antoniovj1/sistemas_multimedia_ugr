package sm.avj.graficos;

/**
 *
 * @author antonio
 */
public enum Forma {
    PUNTO("sm.avj.graficos.Punto2D"),
    LINEA("sm.avj.graficos.Linea2D"),
    RECTANGULO("sm.avj.graficos.Rectangulo2D"),
    ELIPSE("sm.avj.graficos.Elipse2D"),
    POLIGONO("sm.avj.graficos.Poligono2D"),
    CURVAQ("sm.avj.graficos.CurvaQ2D");

    private final String nombreClase;

    Forma(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getNombreClase() {
        return nombreClase;
    }

}
