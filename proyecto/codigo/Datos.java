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

    static String[][] datos;
    static String[][] datosTest;
    static int longitud = leerCantidadDatos();
    static int longitudTest = leerCantidadDatosTest();

    /**
     * Constructor de los datos, se encarga de definir el tamaño total de la matriz donde se guardaran.
     * @use leerCantidadDatos().
     */
    Datos(){
        this.datos = new String[leerCantidadDatos()][];
        this.datosTest = new String[leerCantidadDatosTest()][];
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
     * Método encargado de leer todas las filas del archivo y contar cuantas hay.
     * @return el número de filas totales del archivo.
     */
    public static int leerCantidadDatos(){
        int count = 0;
        Path filePath = Paths.get("src\\0_train_balanced_15000.csv");
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
    public static void leerDatos(){
        Path filePath = Paths.get("src\\0_train_balanced_15000.csv");
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
    /**
     * Método encargado de almacenar todos los datos a la matriz y llenarla.
     */
    public void leerDatosTest(){
        Path filePath = Paths.get("src\\1_test_balanced_15000.csv");
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;
            linea = br.readLine();
            linea = br.readLine();
            for(int i = 0;i < datosTest.length;i++){
                datosTest[i] = linea.split(";");
                linea = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Método encargado de leer todas las filas del archivo para testear el algoritmo y contar cuantas hay.
     * @return el número de filas totales del archivo.
     */
    public static int leerCantidadDatosTest(){
        int count = 0;
        Path filePath = Paths.get("src\\1_test_balanced_15000.csv");
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
     * Método encargado de sacar el exito total de una matriz (sacar todas las personas correctas).
     * @return la cantidad e personas que hayan acertado.
     */
    public static int datosRelevantesTest(){
        int verdaderosTotales = 0;
        for(int i = 0; i < datosTest.length; i++){
            if(datosTest[i][datosTest[0].length-1].equals("0")){
                verdaderosTotales++;
            }
        }
        return verdaderosTotales;
    }

    /**
     * Método encargado de sacar el exito total de una matriz (sacar todas las personas correctas).
     * @return la cantidad e personas que hayan acertado.
     */
    public static int datosRelevantes(){
        leerDatos();
        int verdaderosTotales = 0;
        for(int i = 0; i < datos.length; i++){
            if(datos[i][datos[0].length-1].equals("0")){
                verdaderosTotales++;
            }
        }
        return verdaderosTotales;
    }
}