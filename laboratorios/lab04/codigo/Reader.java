package Lab04.codigo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
/**
 * Esta clase se encarga de leer losd atos de las abjeas y almacenandolas en una lista enlaza de un objeto de abjeas
 * así mismo se van a guardar las cordenadas de cada abeja de lista enlazada.
 * Así mismo estos datos los requiera una funcion de la clase Octree
 * @author Juan Pablo Rincon | Julian Gomez
 * @version: 1
 * @leer Octree
 * @leer Bee
 */
public class Reader
{
    //Lista enlazadas donde se guarda las abejas y las cordenadas.
    LinkedList<Double> lat = new LinkedList(); // Se encarga de guardar las latitudes
    LinkedList<Double> lon = new LinkedList();// Se encarga de guardar las longitudes
    LinkedList<Double> alt = new LinkedList();// Se encarga de guardar las altitudes
    LinkedList<Bee> bees = new LinkedList();// Se encarga de guardar las aebjas
    /**
     * Este método se encarga de recibir la dirreción donde se encuentra el archivo con la información de
     * las abejas y almacenarlas en las listas enlazadas anteriormente mencionadas.
     * @param dir: dirección donde se encuentra el archivo con las cordenadas de cada abjea.
     * @ver splitString método que se encarga de agregar abjeas y las cordenadas.
     */
    public void leer(String dir) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(dir))){
            String line;
            while ((line = br.readLine())!=null){
                splitString(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        getMaxMin();
    }

    /**
     * este método se encarga de alamcenar las cordenadas de las abejas y además agregar las abjeas
     * a las listas enlazadas del principio.
     * @param s: line of coordinates
     */
    public void splitString(String s){
        String[] str = s.split(",");
        try{
            lat.addFirst(Double.parseDouble(str[0]));
            lon.addFirst(Double.parseDouble(str[1]));
            alt.addFirst(Double.parseDouble(str[2]));
            Bee bee = new Bee(Double.parseDouble(str[0]),Double.parseDouble(str[1]),Double.parseDouble(str[2]));
            bees.addFirst(bee);
        } catch (Exception e){
        }
    }

    /**
     *Este método se encarga de obtener el mínimo y el máximo de cada coordenada,
     *por lo que podemos estimar la longitud de las diagonales que se crearán en la primera división
     *del Octree, y determinar si vale la pena crear un Octree con este conjunto de datos.
     *Asimismo, este es el último paso de esta clase antes de que comencemos a trabajar con
     *nuestra estructura de datos Octree.
     *Si no vale la pena crear el Octree (porque la longitud de sus diagonales será inferior a 100 m)
     *se imprimirán todas las coordenadas de las abejas del conjunto de datos.
     * @leer choque método
     */
    public void getMaxMin(){
        double minlat = (double)Collections.min(lat);
        double maxlat = (double)Collections.max(lat);

        double minlon = (double)Collections.min(lon);
        double maxlon = (double)Collections.max(lon);

        double minalt = (double)Collections.min(alt);
        double maxalt = (double)Collections.max(alt);

        ArrayList<Double> mins = new ArrayList();
        mins.add(minlat);mins.add(minlon);mins.add(minalt);
        double midD=(minlat-maxlat);
        double midW=(maxlon-minlon);
        double midH=(maxalt-minalt);
        double ph = Math.sqrt(Math.pow((midD)*111325,2)+Math.pow((midW)*111325,2));
        double diagonal = Math.sqrt(Math.pow(ph,2)+Math.pow((midH),2));
        if (diagonal > 100){
            Octree octree = new Octree();
            octree.octree(bees,mins,midD,midW,midH);
        } else {
            choque();
        }
    }

    /**
     * Este método se encarga de imprimir las abejas que estan en riesgo de colisión
     * si se imprimen es porque estas estan en un rango menor a 100 y por lo tanto estan
     * riesgo de colsión.
     */
    public void choque() {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        int beesSize = bees.size();
        for (int i=0;i<beesSize;++i) {
            String latitude = bees.peek().getLatitude()+"";
            String longitud = bees.peek().getLongitude()+"";
            String altitud = bees.poll().getAltitude()+"";
            System.out.println(latitude+","+longitud+","+altitud);        }
    }
}