/**
 * La clase Laboratorio1 da respuesta a los puntos 1.1 y 1.2 del primer laboratorio propuesto.
 *
 * @author Julian Gomez | Juan Pablo Rincon 
 * @version 08/23/2020
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Laboratorio1{
    /*
     * Este metodo lee un archivo para obtener de ahí la cadena de caracteres que representan el ADN mitocondrial que se busca 
     * comparar.
     * @param file Nombre o PATH del archivo.
     * @return linea Variable en la que queda guardada lo que se lee del archivo.
     */
    public static String leerDatos(String file){
        StringBuilder sb = new StringBuilder();
        Path filePath = Paths.get(file);
        String linea = null;
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            linea = br.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        return linea;
    }
    
    /*
     * Este metodo determina la subsecuencia común más larga entre dos cadenas de caracteres.
     * @param x Primera cadena a comparar.
     * @param y Segunda cadena a comparar.
     * @return La longitud de la subsecuencia común más larga.
     */

    public static int lcs(String x, String y) {
        if((x.length() == 0) || (y.length() == 0)) return 0;
        if(x.charAt(x.length() - 1) == y.charAt(y.length() -1)){
            return 1 + lcs(x.substring(0,x.length() - 1), y.substring(0, y.length() - 1));

        }else{
            return Math.max(lcs(x, y.substring(0, y.length() - 1)),
                lcs(x.substring(0,x.length() - 1), y));
        }

    }
    /*
     * Este metodo calcula cuantas maneras hay de organizar rectangulos de 1x2 en un
     * rectangulo de 2xn.
     * @param n Tamaño del rectangulo 2xn.
     * @return La cantidad de maneras que hay para ordenar rectangulos 1x2
     * wn un rectangulo de 2xn.
     */
    
    int ways(int n){
        if(n <= 2)
            return 1;
        return ways(n-1) + ways(n-2);
    }

}
