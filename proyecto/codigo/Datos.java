/**
 * La clase datos se encarga de el manejo de los archivos, respecto a leerlos y saber cuantos datos se estan leyendo.
 *
 * @author Juan Pablo Rincon - Julian Gomez Benitez
 * @version 15-09-2020
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Datos{

    String[][] datos;
    int longitud = leerCantidadDatos();

    /**
     * Constructor de los datos, se encarga de definir el tamaño total de la matriz donde se guardaran.
     * @ver leerCantidadDatos().
     */
    Datos(){
        this.datos = new String[leerCantidadDatos()][];
    }

    /**
     * método toString para poder visualizar los datos almacenados.
     * @return String de datos.
     */
    @Override
    public String toString() {
        return "Datos{" +
                "datos=" + datos.toString() +
                '}';
    }

    /**
     * Método para acceder a los datos.
     * @return matriz con los datos.
     */
    public String[][] getDatos() {
        return datos;
    }

    /**
     * Método encargado de leer todas las filas del archivo y contar cuantas hay.
     * @return el número de filas totales del archivo.
     */
    public int leerCantidadDatos(){
        int count = 0;
        Path filePath = Paths.get("src\\4_train_balanced_135000.csv");
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea = br.readLine();
            while ((linea = br.readLine()) != null){
                count++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Método encargado de almacenar todos los datos a la matriz y llenarla.
     */
    public void leerDatos(){
        Path filePath = Paths.get("src\\4_train_balanced_135000.csv");
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;
            linea = br.readLine();
            linea = br.readLine();
            for(int i = 0;i < datos.length;i++){
                datos[i] = linea.split(";");
                linea = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
