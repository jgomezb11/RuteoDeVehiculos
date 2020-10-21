package Taller11;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Juan Pablo Usma | Julian Gomez Benitez
 */
public class DigraphAL extends Digraph {
    ArrayList<LinkedList<Pair<Integer,Integer>>> grafoArregloLista;

    /**
     * Constructor para el grafo dirigido
     * @param size el numero de vertices que tendra el grafo dirigido
     *
     */
    public DigraphAL(int size) {
        super(size);
        grafoArregloLista = new ArrayList<>();
        for(int i = 0; i < size;i++){
            grafoArregloLista.add(new LinkedList<>());
            for(int k = 0; k < size;k++){
                grafoArregloLista.get(i).add(new Pair(0,0));
            }
        }
    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        grafoArregloLista.get(source).remove(destination);
        grafoArregloLista.get(source).add(destination,new Pair(destination,weight));
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Integer> getSuccessors(int vertex){
        ArrayList<Integer>vecinos = new ArrayList<>();
        for(int i = 0; i < grafoArregloLista.get(vertex).size(); i++){
            if(grafoArregloLista.get(vertex).get(i).first != 0){
                vecinos.add(i);
            }
        }
        if(vecinos.size() != 0){
            return vecinos;
        }
        return null;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     *
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */
    public int getWeight(int source, int destination) {
        LinkedList<Pair<Integer,Integer>> posiciones = grafoArregloLista.get(source);
        for(int i = 0; i < posiciones.size(); i++){
            if(posiciones.get(i).first == destination){
                return posiciones.get(i).second;
            }
        }
        return 0;
    }

}