
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller06;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Anything
 */
public class Taller06 {

     /**
     * Se puede leer los elementos por consola con la ayuda de la clase index.
     * luego solo se agregan a un objeto arraylist y se imprime.
     * el arreglo tiene que estar de forma inversa
     * ejemplo, para las entras 1 , 2 , 6, -1
     * el arreglo tendría este orden [ 6, 2, 1].
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
     * @param n el numero hasta el cual se llevara acabo el patrón siguiente
     * vamos a implementar un nuevo nuevo a la vez no antes de haber
     * contado desde el inicio ejemplo n=4 entonces el arreglo sería
     * [ 1,1,2,1,2,3,1,2,3,4] de modo que siempre que se ingresa uno nuevo
     * comienza la cuenta desde 1.
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
