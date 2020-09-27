package Lab03.codigo;

import java.util.LinkedList;

/**
 * Esta clase es la representación de un mapa de medellín, esta dado por calles y lugares.
 *
 @version 1
 @author Juan Pablo Rincon Usma | Julian Gómez Benitez
 */
public class Mapa {
    LectorDatos ld = new LectorDatos();
    LinkedList<Lugar> lugares = ld.leerLugar();
    LinkedList<Calle> calles = ld.leerCaller();
}
