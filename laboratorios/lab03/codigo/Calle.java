package Lab03.codigo;

/**
 * Esta clase representa un punto de la ciudad comparado con otro y la distancia entre ambos puntos.
 *
@version 1
@author Juan Pablo Rincon Usma | Julian Gómez Benitez
*/
public class Calle {
    private float cordenadaX;
    private float cordenadaY;
    private long distancia;

    /**
     * Constructor de una calle
     * @param cordenadaX representación de una cordenada
     * @param cordenadaY representación de una cordenada
     * @param distancia Distancia entre dos puntos
     */
    public Calle(float cordenadaX, float cordenadaY, long distancia) {
        this.cordenadaX = cordenadaX;
        this.cordenadaY = cordenadaY;
        this.distancia = distancia;
    }
    /**
     * Método getter de una cordenada
     * @return cordenada en x
     */
    public double getCordenadaX() {
        return cordenadaX;
    }
    /**
     * Método setter de una cordenada
     */
    public void setCordenadaX(float cordenadaX) {
        this.cordenadaX = cordenadaX;
    }
    /**
     * Método getter de una cordenada
     * @return cordenada en y
     */
    public double getCordenadaY() {
        return cordenadaY;
    }
    /**
     * Método setter de una cordenada
     */
    public void setCordenadaY(float cordenadaY) {
        this.cordenadaY = cordenadaY;
    }
    /**
     * Método getter de una distancia
     * @return distancia de dos puntos
     */
    public double getDistancia() {
        return distancia;
    }
    /**
     * Método setter de una distancia
     */
    public void setDistancia(long distancia) {
        this.distancia = distancia;
    }

    /**
     * Método para ver calles
     * @return devuelve la representación de una calle
     */
    @Override
    public String toString() {
        return "Calle{" +
                "cordenadaX=" + cordenadaX +
                ", cordenadaY=" + cordenadaY +
                ", distancia=" + distancia +
                '}';
    }
}
