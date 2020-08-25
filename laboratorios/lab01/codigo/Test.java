import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test{
    private static String x[] = new String [20];
    private static String y[] = new String [20];
    
   /*
     * Este metodo lee un archivo para obtener de ahí la cadena de caracteres que representan el ADN mitocondrial que se busca 
     * comparar.
     * @param file Nombre o PATH del archivo.
     * @return linea Variable en la que queda guardada lo que se lee del archivo.
     */
    public static void leerDatos(){
        StringBuilder sb = new StringBuilder();
        Path filePath = Paths.get("prueba.txt");
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea = br.readLine();
            for(int i = 0; i < 20; i++){
                String datos[] = linea.split(",");
                x[i] = datos[0];
                y[i] = datos[1];
                linea = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
   public static void main (String[] args){
       long sTime, tTime;
       double tiempo;
       leerDatos();
       for(int i = 0; i < 20 ; i++){
        sTime = System.currentTimeMillis();
        System.out.print("\nLa subsecuencia común más larga tiene una longitud de: " 
                            + Laboratorio1.lcs(x[i],y[i]) + "\n");
        tTime = System.currentTimeMillis();
        tiempo = tTime - sTime;
        System.out.print(tiempo);
    }
   }
}
