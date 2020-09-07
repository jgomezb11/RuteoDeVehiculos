
/**
 * Solucion al punto 1 del lab 2.
 *
 * @author Juan Pablo Rincon | Julian Gomez
 * @version (a version number or a date)
 */
public class Codigo {

    public static void main(String[] args) {
        int n = 100000; // Poner aqui el valor de n con el que quieran probar el codigo
        aM = new int[n];
        aI = new int[n];
         for(int i = 0; i < aM.length; i++) {
         int m = (int) (Math.random() * 100000 + 1);
         aM[i] = m;
         aI[i] = m;
     }
        System.out.println("Este es es por ordenamiento Merge Sort");
        positiveTest();
        System.out.println("\n\nEste es por ordenamiento Insertion Sort");
        insertionTest();
    }

    private static int[] aM, aI;

    /**
     * Codigo tomado de:
     * https://www.geeksforgeeks.org/insertion-sort/
     */

    public static void insertionSort (int[] array) {
        for (int i = 1; i < array.length; i++) {  
            int key = array[i];     
            int j = i-1;    
            while(j >= 0 && array[j] > key){ 
                array[j+1] = array[j];  
                j = j - 1;    
            }
            array[j+1] = key; 
        }
    }

    /**
     * Código tomado de internet
     * https://www.geeksforgeeks.org/merge-sort/
     */
    public static void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 

        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    public static void sort(int arr[], int l, int r) 
    { 
        if (l < r) { 
            int m = (l + r) / 2; 
            sort(arr, l, m); 
            sort(arr, m + 1, r); 
            merge(arr, l, m, r); 
        } 
    } 

    public static void insertionTest() {
        long inicio = System.currentTimeMillis();
        insertionSort(aI);
        long terminar = System.currentTimeMillis();
        long total = terminar - inicio;
        System.out.println("Para longitud " + aI.length + " tiempo: " + total + " milisegundos");
        for (int a : aI) {
            System.out.print(a+"\t");
        }
    }

    public static void positiveTest() {
        long inicio = System.currentTimeMillis();
        sort(aM, 0, aM.length - 1);
        long terminar = System.currentTimeMillis();
        long total = terminar - inicio;
        System.out.println("Para longitud " + aM.length + " tiempo: " + total + " milisegundos");
        for (int a : aM) {
            System.out.print(a+"\t");
        }
    }
}