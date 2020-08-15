/**
 * Write a description of class Datos here.
 *
 * @author Juan Pablo Rincon - Julian Gomez Benitez
 * @version 15-09-2020
 */
import java.io.*;
import com.opencsv.*;
import java.util.List;
import java.io.IOException;

public class Datos{
    
    public static void leerDatos(){
        FileReader archCSV = null;
        CSVReader csvReader = null;
        int cont = 0;
        try {
            archCSV = new FileReader("lite.csv");
            CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
            csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
            String[] fila = null;
            while((fila = csvReader.readNext()) != null) {
                System.out.println(fila[0]
                    + " | " + fila[1]
                    + " |  " + fila[2]);
            }
        }
        catch(IOException e) {
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            try { 
                if(csvReader != null){
                    csvReader.close();
                    archCSV.close();
                }
            }
            catch(IOException e) {
                System.out.println(e);
            }
        }
    }
}
