package Taller08;

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
    public static int polaca  (String string) {
        String [] elemento = string.split(" ");
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

    public static void punto2() {
        Scanner in = new Scanner(System.in);
        Stack almacen = new Stack();
        LinkedList<Solicitud> queue = new LinkedList<>();

        System.out.print("Cantidad de neveras en almacén: ");
        int neveras_totales = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= neveras_totales; i++) {
            String desc;
            switch((int)(Math.random()*5 + 1)) {
                case 1:
                    desc = "Buen estado";
                    break;
                case 2:
                    desc = "Puerta grande";
                    break;
                case 3:
                    desc = "Blanca";
                    break;
                case 4:
                    desc = "Con antifrost";
                    break;
                default:
                    desc = "Sencilla";
                    break;
            }
            almacen.add(new Nevera(i, desc));
        }

        System.out.print("Cantidad de solicitudes: ");
        int n = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= n; i++) {
            System.out.print("Tienda " + i + ": ");
            String store = in.nextLine();
            System.out.print("Cantidad de neveras: ");
            int id = Integer.parseInt(in.nextLine());
            queue.add(new Solicitud(id, store));
        }

        System.out.println();
        for(Solicitud s: queue) {
            for(int i = 0; i < s.cantidad_neveras; i++) {
                if(!almacen.isEmpty()) s.neveras.add((Nevera) (almacen.pop()));
                else s.neveras.add(new Nevera(0, "NO DISPONIBLE"));
            }
            System.out.println(s.toString());
        }
    }

    /**
     *
     *  posición de una pila si no que tambien devuelve su valor.
     * @return una pila que aga el inverso de sta ck
     */
    public static Stack<Integer>inversa(Stack<Integer> stack){
        int n = stack.size();
        Stack<Integer> temp = new Stack<Integer>();
        for(int i = 0; i < n; i++)
            temp.push(stack.pop());
        return temp;
    }

}

class Nevera {
    int id;
    String description;

    public Nevera(int id, String description) {
        this.id = id;
        this.description = description;
    }
}

class Solicitud {
    int cantidad_neveras;
    String nombre_tienda;
    LinkedList<Nevera> neveras;

    public Solicitud(int n, String name) {
        cantidad_neveras = n;
        nombre_tienda = name;
        neveras = new LinkedList<>();
    }

    @Override
    public String toString() {
        String s = nombre_tienda + "\n";
        for(Nevera n : neveras) {
            s += n.id + " - " + n.description + "\n";
        }
        return s;
    }
}