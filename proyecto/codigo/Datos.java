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
import java.util.ArrayList;

public class Datos{
    ArrayList<String []> datos = new ArrayList<String []>();
    public void leerDatos(){
        StringBuilder sb = new StringBuilder();
        Path filePath = Paths.get("lite.csv");
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;
            linea = br.readLine();
            while ((linea = br.readLine()) != null){
                String[] datosDeLinea = linea.split(";");
                datos.add(datosDeLinea);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

