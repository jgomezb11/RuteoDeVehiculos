package Taller09;

import kotlin.Pair;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * La clase UnaTablaDeHash, es un plantilla para crear nuestra propia estructura hash
 * Dentro de sus características esta que tiene un string como llave (key) y un entero
 * como valor (value)
 * @author Juan Pablo Usma | Julian Gomez Benitez
 * @version 1
 */
public class UnaTablaDeHash
{
    /*
     * Utilizamos array por simplicidad sin embargo el uso de este no permite manejar coliciones
     * de manera eficiente, por lo cual esta primera versión de hash no implementa colisiones, esta
     * característica se implementará posteriormente.
     */
    private LinkedList<Pair<String,Integer>>[] tabla;

    /**
     * Este método define el array utilizado con 10 posiciones de manera que tenemos un límite de 10 elementos
     *
     */
    public UnaTablaDeHash(){
        tabla = new LinkedList[10];
        for(int i = 0; i < tabla.length; i++){
            tabla[i] = new LinkedList<Pair<String, Integer>>();
        }
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     * Este método se utiliza para darle una posicion dentro de la tabla, donde el %10 asegura que solo
     * se utilicen digitos de 0 a 10.
     */
    private int funcionHash(String k){
        return ((int) k.charAt(0)) % 10;
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     * @throws NoSuchElementException retorna esto en caso de que no se encuentre dentro de la tabla
     * Este método se utiliza para obtener el elmento con la clave k, se enlaza con funcionHash
     */
    public int get(String k) throws NoSuchElementException{
        for(int i = 0; i < tabla[funcionHash(k)].size(); i++){
            if(tabla[funcionHash(k)].get(i).getFirst().equals(k)){
                return tabla[funcionHash(k)].get(i).getSecond();
            }
        }
        System.out.println("Contacto no encontrado");
        throw new NoSuchElementException();
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar posteriormente
     * @param v es el valor asociado a la llave k
     * Este método se utiliza para agregar un nuevo elemento
     */
    public void put(String k, int v){
        tabla[funcionHash(k)].add(new Pair(v,k));
    }
}