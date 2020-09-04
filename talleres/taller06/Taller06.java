package taller06;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Julian Gomez || Juan Pablo Usma
 */
public class Taller06 {

     /**
     * Imprime los datos ingresados por consola de forma inversa
     * hasta que se digite un -1.
     * @return un arraylist con todos los elementos ingresados de forma invertida
     */
    public static ArrayList<Integer> opcinal2 (){
	ArrayList<Integer> arry = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	while (n != -1 ) {
	    arry.add(n);
	    n = in.nextInt();
	}
	ArrayList<Integer> arreglo = new ArrayList<>();
	for(int i = 0; i < arry.size() ; i++) {
	    arreglo.add(arry.get(arry.size()-1-i ));
	}
	return arreglo;
    }

    /**
     * Este metodo genera un arreglo con un patron que empieza desde 1 
     * y termina en n. 
     * @param n el numero hasta el cual se llevara acabo el patrón
     * @return un arraylist con todos los elementos ingresados
     */
    public static ArrayList<Integer> opcinal3 (int n){
	ArrayList<Integer> patron = new ArrayList<>();
	for(int i = 1; i <= n; i++){
	    for(int j = 1; j <= i; j++){
		patron.add(j);
	    }
	}
	return patron;
    }
    public static void ejercicio2(){
        ArrayList<Integer> temp;
        temp = Taller06.opcinal2();
            System.out.print("Los números ingresados de forma inversa fueron fueron");
        for(int i=0;i<temp.size();i++){
            System.out.print(" "+temp.get(i));
        }
        System.out.println("");
    }
    
    public static boolean ejercicio3(){
        ArrayList<Integer> temp;
        int[] a,b,c,d,temp1,temp2,temp3,temp4;
        
        temp = Taller06.opcinal3(2);
        a = new int[] {1,1,2};
        temp1 = temp.stream().mapToInt(Integer::intValue).toArray();
        
        
        temp = Taller06.opcinal3(4);
        b = new int[] {1,1,2,1,2,3,1,2,3,4};
        temp2 = temp.stream().mapToInt(Integer::intValue).toArray();
        
        
        temp = Taller06.opcinal3(6);
        c = new int[] {1,1,2,1,2,3,1,2,3,4,1,2,3,4,5,1,2,3,4,5,6};
        temp3 = temp.stream().mapToInt(Integer::intValue).toArray();
        
        
        temp = Taller06.opcinal3(11);
        d = new int[] {1,1,2,1,2,3,1,2,3,4,1,2,3,4,5,1,2,3,4,5,6,1,2,3,4,5,6,7,1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,11};
        temp4 = temp.stream().mapToInt(Integer::intValue).toArray();
        
        
        if (!Arrays.equals(a,temp1) || !Arrays.equals(b,temp2) || !Arrays.equals(c,temp3) || !Arrays.equals(d,temp4))
            return false;
        return true;
    }
    
    public static void main(String[] args) {
        //Ejercicio2
        System.out.println("");
        System.out.println("Ejecutandose ejercicio Opcinal 2, recuerde escribir -1 para parar");
        ejercicio2();
        
        //Ejercicio3
        if(ejercicio3())
            System.out.println("Ejercicio 3 Correcto");
        else
        System.out.println("Ejercicio 3 Incorrecto");
    }
    
}
