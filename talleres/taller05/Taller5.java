package Taller05;

import java.util.ArrayList;

/**
 * La clase Taller5 tiene la intención de resolver el taller número 5.
 *
 * @author Julian Gomez, Juan Pablo Rincon.
 * @version 1
 */

public class Taller5 {

    /**
     * @param array es una arreglo de numeros enteros.
     * El método suma tiene la intención de hacer el proceso de suma
     * mediante una funcion cíclica (while/for/...)
     * @return la suma de todos los numeros sumados.
     */

    public static int suma(int[] array){
        int acum = 0;  // c1
        for (int i = 0; i < array.length; i++) // c2 + c3 * n
            acum = acum + array[i];            // c4 * n
        return acum;        // c5
    }                       // T(n) = c1 + c2 + c5 + (c3 + c4) * n
                            // T(n) es O(n)
                            // Donde n es el tamaño del array
    /**
     * Código usado para medir el tiempo usado
        for (int n = 10000000; n < 500000000; n = n + 10000000){
        long ti = System.currentTimeMillis();
        suma(new int[n]);
        long tf = System.currentTimeMillis();
        System.out.println(tf-ti);
     }

     **/

    /**
     * @param num es el numero el cual se utiliza para ser multiplicado.
     * El método mul tiene la intención de hacer la multiplicación
     * de 1 a n por el numero mul
     * mediante una funcion cíclica (while/for/...)
     *
     */
    public static void mul (int num){
        for(int i = 1; i <= num; i++){ // T(n) = c1 * n +c2
           System.out.println(num + " x " + i + " = " + (num*i)); // c3 * n
        }   //T(n) = c3 * n + c2 + c1 * n
            //T(n) = O(n)
            //Donde n es el valor máximo por el cual se va a multiplicar y será la últiam tabla de multiplicar.
    }
    /**
     * Código usado para medir el tiempo usado
    ArrayList<Integer> nums = new ArrayList<>();
        for (int n = 1000000; n < 1002000; n = n + 100){
        long ti = System.currentTimeMillis();
        Taller5.mul(n);
        long tf = System.currentTimeMillis();
        nums.add((int)(tf-ti));
    }
        for(int a = 0; a < nums.size(); a++){
        System.out.println(nums.get(a));
    }
     **/

    /**
     * @param array es un arreglo de números desordenados
     * El método insertionSort tiene la intención ordenar los números
     * del arreglo array por el método insertion:
     * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
     * mediante la anidación de funciones cíclicas (while/for/...)
     *
     */
    public static int[] insertionSort (int[] array){
        for(int i = 1; i < array.length; i++){ //T(n) = c1 * n + c2
            for(int j = i; j > 0; j--){ // T(n) = (c3 * n - c4) * n
                if(array[j] < array[j-1]){ // (c5) * n * n
                    int temp = array[j-1]; // (c6) * n * n
                    array[j-1] = array[j]; // (c7) * n * n
                    array[j] = temp; // (c8) * n * n
                }
            }
        }
       return array;
    }
    // T(n) = c1 * n + c2 + c3n + n^2 + c4n + c5n^2 + c6n^2 + c7n^2 + c8n^2
    // T(n) = O(c8n^2) ==> T(n) = O(n^2)
    // Donde n es el tamaño del arreglo
    /**
     *        Código usado para medir el tiempo usado
     *
     public static void pruebaTNums(int n){
     for(int i = 10000; i <= 110000; i = i + 5000){
         pruebaTiempoInsertionSort(i);
     }
     }
     public static void pruebaTiempoInsertionSort(int n){
     int [] prueba = new int[n];
     for(int i = 0; i < prueba.length; i++) {
         prueba[i] = (int) Math.random() * 1000000000 + 1;
     }
     long ti = System.currentTimeMillis();
     Taller5.insertionSort(prueba);
     long tf = System.currentTimeMillis();
     System.out.println(tf-ti);
     }
     */
}