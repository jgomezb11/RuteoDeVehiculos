
/**
 * La clase Laboratorio1 busca la longitud de la cadena común más larga entre dos cadenas de Caracteres 
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

    public static int lcs(String x, String y) {
        if((x.length() == 0) || (y.length() == 0)) return 0;
        if(x.charAt(x.length() - 1) == y.charAt(y.length() -1)){
            return 1 + lcs(x.substring(0,x.length() - 1), y.substring(0, y.length() - 1));

        }else{
            return Math.max(lcs(x, y.substring(0, y.length() - 1)),
                lcs(x.substring(0,x.length() - 1), y));
        }

    }
    
    int ways(int n){
        if(n <= 2)
            return 1;
        return ways(n-1) + ways(n-2);
    }

}
