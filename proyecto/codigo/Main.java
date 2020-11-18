/**
 * La clase Main se encarga de empezar a funcionar el algoritmo.
 *
 * @author Juan Pablo Rincon - Julian Gomez Benitez
 */
public class Main {
    public static void main(String[] args) {
        Datos datos = new Datos();
        datos.leerDatos();
        Nodo nodo = new Nodo(datos.datos); //arbol entrenado
        Test test = new Test();
        datos.leerDatosTest();
        test.test(datos.datosTest, 0);
   }
}