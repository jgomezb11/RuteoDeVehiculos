/**
 * Write a description of class Datos here.
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

    Datos(){
        this.datos = new String[leerCantidadDatos()][];
    }

    @Override
    public String toString() {
        return "Datos{" +
                "datos=" + datos.toString() +
                '}';
    }

    public String[][] getDatos() {
        return datos;
    }

    public void setDatos(String[][] datos) {
        this.datos = datos;
    }

    public int leerCantidadDatos(){
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

    public void leerDatos(){
        Path filePath = Paths.get("src\\1_test_balanced_15000.csv");
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