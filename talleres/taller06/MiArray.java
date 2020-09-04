/**
 *
 * @author Juan Pablo Usma | Julián Gómez
 */

import java.util.Arrays;
public class MiArray {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int array[];

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArray() {
        array = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return size;
    }

    /**
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) {
        add(size, e);
    }

    /**
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) {
        if (i < size && i >= 0) {
            return array[i];
        }else {
            throw new IndexOutOfBoundsException("Index : " + i);
        }
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {
        if ( index < size && index >= 0) {
            for (int i = 0; i <= size; i++) { 
                if (i == size && size == array.length) {
                    extend();
                }

                if (i == index) {
                    for(int j = size; j > 0; j--){ 
                        array[j] = array[j-1];
                    }
                    array[i]= e;
                    i++;
                    size++;

                }
            }
        }else if (index >= size) {
            array[index] = e;
            size++;
            if (size == array.length) {
                extend();
            }
        }
    } // La compeljidad de este metodo add es O(n) (Donde n es la cantidad de elementos) 
     // y creemos que puede ser viable para millones de abejas puesto que no aumenta exponencialmente la compeljidad.

    private void extend() {
        int [] array2 =  new int[array.length + 1 ];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }

    /**
     * @param index es la posicion en la cual se va eliminar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){
        if ( index < size && index >= 0) {
            array[index]= 0;
            for(int j = index; j < size; j++){ 
                array[j] = array[j+1];
            }
        }
    }
}
