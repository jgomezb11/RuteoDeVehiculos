public class Main {
    public static void main(String[] args) {
        Datos datos = new Datos();
        datos.leerDatos();
        Nodo nodo = new Nodo(datos.datos);
    }
}
