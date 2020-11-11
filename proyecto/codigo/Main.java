public class Main {
    public static void main(String[] args) {
        Datos datos = new Datos();
        datos.leerDatos();
        Nodo nodo = new Nodo(datos.datos);
        if(nodo.exitoHoja){
            System.out.println("Hay alguno bien predecido");
        }else{
            System.out.println("Estan es perdidos");
        }
    }
}
