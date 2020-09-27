package Lab03.codigo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Esta clase se encarga de leer el archivo txt con las cordenadas y distancias
 *
@version 1
@author Juan Pablo Rincon Usma | Julian Gómez Benitez
*/
public class LectorDatos
{
    /**
     * Método que se encarga de leer los lugares del archivo txt y devolverlos como una estructura de datos
     * @return Devuelve una LinkedList de lugares, decidimos usar LinkedList porque para insertar elementos es O(1)
     */
    public LinkedList<Lugar> leerLugar() {
        try{
            FileReader f  = new FileReader("medellin_colombia-grande.txt");
            BufferedReader b = new BufferedReader(f);
            String line;
            LinkedList<Lugar> lugares = new LinkedList<>();
            int lineCount = 0;
            while((line = b.readLine()) != null) {
                if(lineCount != 0) {
                    String[] data = line.split(" ");
                    Long idX = Long.parseLong(data[1]);
                    Long idY = Long.parseLong(data[2]);
                    lugares.add(new Lugar(idX,idY));
                }
                lineCount++;
            }
            b.close();
            return lugares;
        }catch (IOException e) {
            System.out.println("Asegurece de tener el documento ''medellin_colombia-grande''");
        }
        return null;
    }
    /**
     * Método que se encarga de leer las calles del archivo txt y devolverlos como una estructura de datos
     * @return Devuelve una LinkedList de calles, decidimos usar LinkedList porque para insertar elementos es O(1)
     */
    public LinkedList<Calle> leerCaller(){
        try{
            FileReader f  = new FileReader("medellin_colombia-grande.txt");
            BufferedReader b = new BufferedReader(f);
            String line;
            LinkedList<Calle> calles = new LinkedList<>();
            int lineCount = 0;
            while((line = b.readLine()) != null) {
                if(lineCount != 0) {
                    String[] data = line.split(" ");
                    Long distancia = Long.parseLong(data[0]);
                    Long idX = Long.parseLong(data[1]);
                    Long idY = Long.parseLong(data[2]);
                    calles.add(new Calle(idX,idY,distancia));
                }
                lineCount++;
            }
            b.close();
            return calles;
        }catch (IOException e) {
            System.out.println("Asegurece de tener el documento ''medellin_colombia-grande''");
        }
        return null;
    }
}