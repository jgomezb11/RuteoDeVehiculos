package Lab03.codigo;

/**
 * Esta clase representa un lugar en la ciudad esta dado por una cordenada x y una cordenada y
 *
@version 1
@author Juan Pablo Rincon Usma | Julian Gómez Benitez
*/
public class Lugar {
    private float cordenadaX;
    private float cordenadaY;
    /**
     * Constructor de un Lugar
     * @param cordenadaX representación de una cordenada
     * @param cordenadaY representación de una cordenada
     */
    public Lugar(float cordenadaX, float cordenadaY) {
        this.cordenadaX = cordenadaX;
        this.cordenadaY = cordenadaY;
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
     * Método para ver lugares
     * @return devuelve la representación de un lugar
     */
    @Override
    public String toString() {
        return "Lugar{" +
                "cordenadaX=" + cordenadaX +
                ", cordenadaY=" + cordenadaY +
                '}';
    }
}
