import java.util.*;

/* 
 * @author Juan Pablo Usma | Julian Gomez Benitez 
 */

public class Taller8 {
    
    /**
    * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
    * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public static int polaca  (String st) {
        String [] elemento = st.split(" ");
        Stack<Integer> pila = new Stack<>();

        for (int i=0;i<elemento.length;i++) {
            if (elemento[i].equals("+")) {
                int b = pila.peek();
                pila.pop();
                int a = pila.peek();
                pila.pop();
                pila.push(a + b);
            } else if (elemento[i].equals("*")) {
                int b = pila.peek();
                pila.pop();
                int a = pila.peek();
                pila.pop();
                pila.push(a * b);
            } else if (elemento[i].equals("-")) {
                int b = pila.peek();
                pila.pop();
                int a = pila.peek();
                pila.pop();
                pila.push(a - b);
            } else if(elemento[i].equals("/")) {
                int b = pila.peek();
                pila.pop();
                int a = pila.peek();
                pila.pop();
                pila.push(a / b);
            } else {
                pila.push(Integer.parseInt(elemento[i]));
            }
        }
        return (pila.pop());
    }
	
    /**
    *
    *  posición de una pila si no que tambien devuelve su valor.
    * @return una pila que aga el inverso de sta ck
    */
    public static Stack<Integer> inversa (Stack<Integer> stack){
        int n = stack.size();
        Stack<Integer> temp = new Stack<Integer>();
        for(int i = 0; i < n; i++) 
            temp.push(stack.pop());
        return temp;
    }
}