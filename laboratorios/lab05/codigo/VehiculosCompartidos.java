package Lab05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Implementacion de un algoritmo para asignar vehiculos compartidos
 * Estructura de datos utilizada: Grafo con Matrices de Adyacencia
 * Complejidad: Peor Caso y Mejor Caso O(n*n)
 *
 * @author Juan Pablo Usma | Julian Gomez Benitez
 * @version 1
 */
public class VehiculosCompartidos
{
    /**
     * Metodo para leer un archivo con los duenos de vehiculos y la empresa
     * Complejidad: Mejor y peor caso es O(n*n), donde n es son los duenos de vehiculos y la empresa
     *
     * @param  numeroDePuntos  El numero de puntos es 1 de la empresa y n-1 de los duenos de vehiculos
     * @return un grafo completo con la distancia mas corta entre todos los vertices
     */
    public static DigraphAM leerArchivo(int numeroDePuntos, float p){
        final String nombreDelArchivo = "dataset-ejemplo-U="+numeroDePuntos+"-p="+p+".txt";
        DigraphAM grafo = new DigraphAM(numeroDePuntos);
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\Lab05\\dataset-ejemplo-U=205-p=1.3.txt"));
            String lineaActual = br.readLine();
            for (int i = 1; i <= 3; i++) // Descarta las primeras 3 lineas
                lineaActual = br.readLine();
            lineaActual = br.readLine();
            for (int i = 1; i <= numeroDePuntos; i++){ //Descarta los nombres y coordenadas de los vertices
                lineaActual = br.readLine();
            }
            for (int i = 1; i <= 3; i++) // Descarta las siguientes 3 lineas
                lineaActual = br.readLine();
            while (lineaActual != null){ // Mientras no llegue al fin del archivo. Lee la informacion de las aristas
                String [] cadenaParticionada = lineaActual.split(" ");
                grafo.addArc(Integer.parseInt(cadenaParticionada[0])-1, Integer.parseInt(cadenaParticionada[1])-1, Integer.parseInt(cadenaParticionada[2]));
                lineaActual = br.readLine();
            }
        }
        catch(IOException ioe) {
            System.out.println("Error leyendo el archivo de entrada: " + ioe.getMessage());
        }
        return grafo;
    }

    /**
     * Algoritmo para asignar vehiculos compartidos
     * Complejidad: O(n), donde n son los duenos de vehiculos y la empresa
     *
     * @param  grafo  Un grafo que puede estar implementado con matrices o con listas de adyacencia
     * @return una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo
     */
    public static LinkedList<LinkedList<Integer>> asignarVehiculos(Graph grafo, float p){
        LinkedList<LinkedList<Integer>> posiblesCaminos = new LinkedList<LinkedList<Integer>>();
        int dueno = 2; // Empieza en 2 porque 1 es la empresa
        int contador = 1;
        LinkedList<Integer> permutacion = new LinkedList<Integer>();
        while (dueno <= grafo.size()){
            if (contador == 1){ // Si el contador es 1, crear una nueva permutacion
                permutacion = new LinkedList<Integer>();
                permutacion.add(dueno);
                dueno++;
                contador++;
            }
            else { // Sino, seguir insertando en la permutacion actual
                permutacion.add(dueno);
                dueno++;
                contador++;
                if (contador == 6 || dueno == grafo.size()){  //Si esto se cumple, agregar la permutacion a la respuesta
                    contador = 1;
                    posiblesCaminos.add(permutacion);
                }
            }
        }
        return posiblesCaminos;
    }

    /**
     * Este método se encarga de saber cuales parejas son optimas para que puedan llegar en un tiempo menor a P
     * a la universidad.
     * Complejidad: O(n) donde n son las permutaciones dadas en el método de asignarVehiculos.
     * @param posiblesPermutaciones las permutaciones retornadas en el método asignarVehiculos.
     * @param grafo el grafo leido en el método leerArchivo.
     * @return las posibles permutaciones que cumplen la condición de no demorarse más de un tiempo P.
     */
    public static LinkedList<LinkedList<Integer>> verificarPermutaciones(LinkedList<LinkedList<Integer>> posiblesPermutaciones, DigraphAM grafo){
        LinkedList<LinkedList<Integer>> solucion = new LinkedList<LinkedList<Integer>>();
        int contador = 0;
        int countLinked = 0;
        while(!posiblesPermutaciones.isEmpty()){
            if(posiblesPermutaciones.get(contador).size() != 5){
                for(int i = 0; i < posiblesPermutaciones.get(contador).size(); i++){
                    if(i == posiblesPermutaciones.get(contador).size()-1){
                        countLinked += grafo.getWeight(posiblesPermutaciones.get(contador).get(i),1);
                    }else{
                        countLinked += grafo.getWeight(posiblesPermutaciones.get(contador).get(i),posiblesPermutaciones.get(contador).get(i+1));
                    }
                }
            }else{
                countLinked += grafo.getWeight(posiblesPermutaciones.get(contador).get(0),posiblesPermutaciones.get(contador).get(1));
                countLinked += grafo.getWeight(posiblesPermutaciones.get(contador).get(1),posiblesPermutaciones.get(contador).get(2));
                countLinked += grafo.getWeight(posiblesPermutaciones.get(contador).get(2),posiblesPermutaciones.get(contador).get(3));
                countLinked += grafo.getWeight(posiblesPermutaciones.get(contador).get(3),posiblesPermutaciones.get(contador).get(4));
                countLinked += grafo.getWeight(posiblesPermutaciones.get(contador).get(4),1);
            }
            if(countLinked <= 78){
                solucion.add(posiblesPermutaciones.get(contador));
            }
            posiblesPermutaciones.poll();
            countLinked = 0;
        }
        return solucion;
    }

    /**
     * Metodo para escribir un archivo con la respuesta
     * Complejidad: Mejor y peor caso es O(n), donde n son los duenos de vehiculo y la empresa
     *
     * @param  permutacionParaCadaSubconjunto es una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo
     */
    public static void guardarArchivo(LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto,int numeroDePuntos, float p){
        final String nombreDelArchivo = "respuesta-ejemplo-U="+numeroDePuntos+"-p="+p+".txt";
        try {
            PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
            for (LinkedList<Integer> lista: permutacionParaCadaSubconjunto){
                for (Integer duenoDeVehiculo: lista)
                    escritor.print(duenoDeVehiculo + " ");
                escritor.println();
            }
            escritor.close();
        }
        catch(IOException ioe) {
            System.out.println("Error escribiendo el archivo de salida " + ioe.getMessage() );
        }
    }

    public static void main(String[] args){
        //Recibir el numero de duenos de vehiculo y la empresa, y el valor de p por el main
        final int numeroDePuntos = args.length == 0 ? 205 : Integer.parseInt(args[0]);
        final float p = args.length < 2 ? 1.3f : Float.parseFloat(args[1]);
        // Leer el archivo con las distancias entre los duenos de los vehiculos y la empresa
        DigraphAM grafo = leerArchivo(numeroDePuntos, p);
        // Asignar los vehiculos compartidos
        long startTime = System.currentTimeMillis();
        LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto = asignarVehiculos(grafo,p);
        // Verifica cuales permutaciones cumplen la condición de que no se demore más de P
        permutacionParaCadaSubconjunto = verificarPermutaciones(permutacionParaCadaSubconjunto,grafo);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
        // Guardar en un archivo
        guardarArchivo(permutacionParaCadaSubconjunto, numeroDePuntos, p);
    }
}

