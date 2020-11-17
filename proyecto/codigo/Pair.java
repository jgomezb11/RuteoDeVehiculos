import java.util.Objects;

/**
 * Contenedor para dos objetos de cualquier tipo. Basada en la implementacion de
 * Android.
 *
 * @author Juan Pablo Usma | Julian Gomez Benitez
 */
public class Pair<F, S> {

    public final F first;
    public final S second;

    /**
     * Constructor de pares.
     *
     * @param first primer objeto del par.
     * @param second segundo objeto del par.
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Método para sacar el primer elemento de una pareja.
     * @return devuelve el primer elemento de la pareja.
     */
    public F getFirst() {
        return first;
    }

    /**
     * Método para sacar el segundo elemento de una pareja.
     * @return devuelve el segundo elemento de la pareja.
     */
    public S getSecond() {
        return second;
    }

    /**
     * Método para ver los elementos de una pareja(objeto).
     * @return un texto con los valores de una pareja tanto el primero como el segundo.
     */
    @Override
    public String toString() {
        return "Pair{" + String.valueOf(first) + " " + String.valueOf(second) + "}";
    }

}
