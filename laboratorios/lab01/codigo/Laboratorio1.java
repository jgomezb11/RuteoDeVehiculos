/**
 * La clase Laboratorio1 da respuesta a los puntos 1.1 y 1.2 del primer laboratorio propuesto.
 *
 * @author Julian Gomez | Juan Pablo Rincon 
 * @version 08/23/2020
 */

public class Laboratorio1{  
    /*
     * Este metodo determina la subsecuencia común más larga entre dos cadenas de caracteres.
     * @param x Primera cadena a comparar.
     * @param y Segunda cadena a comparar.
     * @return La longitud de la subsecuencia común más larga.
     */

    public static int lcs(String x, String y) {
        if((x.length() == 0) || (y.length() == 0)) return 0;
        if(x.charAt(x.length() - 1) == y.charAt(y.length() - 1)){
            return 1 + lcs(x.substring(0,x.length() - 1), y.substring(0, y.length() - 1));

        }else{
            return Math.max(lcs(x, y.substring(0, y.length() - 1)),
                lcs(x.substring(0,x.length() - 1), y));
        }

    }
    /*
     * Este metodo calcula cuantas maneras hay de organizar rectangulos de 1x2 en un
     * rectangulo de 2xn.
     * @param n Tamaño del rectangulo 2xn.
     * @return La cantidad de maneras que hay para ordenar rectangulos 1x2
     * wn un rectangulo de 2xn.
     */
    
    int ways(int n){
        if(n <= 2)
            return 1;
        return ways(n-1) + ways(n-2);
    }

}
