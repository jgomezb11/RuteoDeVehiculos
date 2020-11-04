package Taller13;

import com.sun.jdi.request.ExceptionRequest;
import java.util.Arrays;
/**
 * Implementacion de un monticulo
 *
 * @author Juan Pablo Usma | Julian Gomez Benitez
 */
public class Monticulo {

    // Variables de la clase Monticulo
    int[] monticulo;
    int numElementos;
    int maxElementos;

    /**
     * Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro
     *  el numero de elementos y el numero maximo
     */
    public Monticulo (int num, int max) {
        this.numElementos = num;
        this.maxElementos = max;
        this.monticulo = new int[max];
    }

    /**
     * Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro un vector
     */
    public Monticulo (int[] vector, int max) {
        this.monticulo = new int[max];
        this.maxElementos = max;
        for(int i = 0; i < vector.length; i++){
            monticulo[i] = vector[i];
        }
    }

    //devuelve cierto si el montículo está vacío.
    public boolean EmptyHeap(){
        return monticulo.length == 0;
    }

    //reubica el elemento i-esimo del vector en caso de que este sea mayor que el
    //padre (montículo de maximos).
    public void flotar (int elemento){
        int index = numElementos - 1;
        while(hasPadre(index) && getPadre(index) < monticulo[index]){
            int temp = monticulo[getPadre(index)];
            monticulo[getPadre(index)] = monticulo[index];
            monticulo[index] = temp;
            index = getPadre(index);
        }
    }

    //reubica el elemento i-esimo del vector en caso de que éste sea menor que alguno
    //de sus hijos. En tal caso, intercambia su valor por el del mayor de sus hijos (montículo de máximos).
    public void hundir (int elemento) {
        int index = 0;
        while(hasHijoIzq(index)){
            int masGandre = monticulo[getHijoIzq(index)];
            if(hasHijoDer(index) && monticulo[getHijoDer(index)] > monticulo[getHijoIzq(index)]){
                masGandre = monticulo[getHijoDer(index)];
            }
            if(monticulo[index] > monticulo[masGandre]){
                break;
            }else{
                int temp = monticulo[index];
                monticulo[index] = monticulo[masGandre];
                monticulo[masGandre] = temp;
            }
                index = masGandre;
        }
    }

    //inserta un elemento en el montículo y lo flota hasta restaurar la propiedad de
    //montículo.
    public void insert(int elemento){
        growMonticulo();
        monticulo[numElementos] = elemento;
        numElementos++;
        flotar(monticulo[numElementos]);
    }

    //devuelve la cima del montículo sin modificarlo.
    public int first() {
        return monticulo[0];
    }

    //devuelve la cima del montículo, la elimina del mismo y recompone la
    //propiedad de montículo.
    public int peek() {
        if(EmptyHeap()){
            throw new IllegalStateException();
        }
        int index = monticulo[0];
        monticulo[0] = monticulo[numElementos-1];
        numElementos-=1;
        hundir(monticulo[0]);
        return index;
    }

    //Método para obtener el hijo izquierdo de un padre
    private int getHijoIzq(int parent){
        return 2*parent;
    }

    //Método para obtener el hijo derecho de un padre
    private int getHijoDer(int parent){
        return 2*parent+1;
    }

    //Método para obtener el padre de un hijo
    private int getPadre(int hijo){
        return (hijo-1)/2;
    }

    //Método para saber si el nodo tiene un hijo izquierdo
    private boolean hasHijoIzq(int index){
        return getHijoIzq(index) < numElementos;
    }

    //Método para saber si el nodo tiene un hijo derecho
    private boolean hasHijoDer(int index){
        return getHijoDer(index) < numElementos;
    }

    //Método para saber si el nodo tiene un padre
    private boolean hasPadre(int index){
        return getPadre(index) >= 0;
    }
    // Método para aumentar la capacidad del monticulo en caso de que se llene
    private void growMonticulo(){
        if(numElementos == maxElementos){
            monticulo = Arrays.copyOf(monticulo, maxElementos*2);
            maxElementos*=2;
        }
    }
}