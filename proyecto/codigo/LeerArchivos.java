package series;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 * Clase LeerArchivos.
 * Esta clase lee un archivo csv que será utilizado para cargar las velas y usar los valores contenidos en el
 * csv, el csv se compone de una firma,fecha,hora,apertura,máximo,mínimo,cierre, el nombre del archivo csv es:
 * "Datos históricos EUR_USD.csv"
 *
 * @author (Juan Pablo Rincon Uama)
 * @version (1.0)
 */
public class LeerArchivos {
    /**
     * Este método busca el archivo CSV con Paths.get(Dirección de archivo), depués hay un try para evitar errores del bufferedReader
     * dentro de este try, hay un while el cuál se encarga de leer linea por linea el archivo CSV, además sabemos que los archivos CSV
     * dividen los datos por comas(,) , en mi caso cree un Array con cada dato que hubiera en una linea y los dividi con un split en cada
     * coma(,) porque eso significa que empieza un nuevo dato, una vez que divide los datos lo que hago es almacenarlos en variables que
     * seran las que crearán una vela, al final cuando tenga todos los datos para poder crear una vela, la agrego a la colección de velas.
     * @return Este método devuelve la lista de velas que fueron cargadas del archivo CSV.
     */
    public ArrayList<Vela> cargarVelas(){
        ArrayList<Vela> velas = new ArrayList<Vela>();
        StringBuilder sb = new StringBuilder();
        Path filePath = Paths.get("src/recursos/Datos históricos EUR_USD.csv");
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;
            linea = br.readLine();
            while ((linea = br.readLine()) != null){
                String[] datosDeLinea = linea.split(",");
                String firma = datosDeLinea[0];
                String fecha = datosDeLinea[1];
                String hora = datosDeLinea[2];
                double apertura = Double.parseDouble(datosDeLinea[3]);
                double maximo = Double.parseDouble(datosDeLinea[4]);
                double minimo = Double.parseDouble(datosDeLinea[5]);
                double cierre = Double.parseDouble(datosDeLinea[6]);
                velas.add(new Vela(firma,fecha,hora,apertura,maximo,minimo,cierre));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return velas;
    }

}
