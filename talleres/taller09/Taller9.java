package Taller09;

import java.util.HashMap;
/**
 * Dar solucion taller numero 9
 * Se recomienda hacer una clase o metodo main que instancie esta clase de manera que sirva como test
 * y desarrolle las actividades y cuestiones presentadas en el taller.
 * En esta clase se hará uso total de la clase HashMap:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html">HashMap API</a>
 * @author Juan Pablo Usma | Julian Gomez Benitez
 * @version 1
 */
public class Taller9{

    /**
     * pedrito 2
     * @param empresas es el hashmap ya creado donde se guardaran los valores
     * @param key es la llave en el conjunto
     * @param value es el valor asociado a la llave key
     * El metodo agregara un nuevo valor a empresas con los atributos key y value.
     */
    public static void agregar(HashMap empresas,String key, String value){
        empresas.put(key,value);
    }

    /**
     * pedrito 3
     * @param empresas es el hashmap ya creado donde se guardaran los valores
     * @param key es la llave en el conjunto
     *
     * El metodo buscara el valor asociado a la llave key
     * @return true, si lo encuentra, false de lo contrario.
     */
    public static boolean buscar(HashMap empresas,String key){
        return empresas.containsKey(key);
    }

    /**
     * pedrito 4
     * @param empresas es el hashmap ya creado donde se guardaran los valores
     * @param value es el valor asociado a la llave key
     * El metodo nos dira si hay una llave asociado al valor value.
     * @return true, si lo encuentra, false de lo contrario.
     */
    public static boolean contieneValue(HashMap empresas,String value){
        return empresas.containsValue(value);
    }

    /**
     * Método main para probar los datos del HashMap
     *
     */
    public static void main(String[] args) {
        /**
         * Punto 1
         */
        UnaTablaDeHash uth = new UnaTablaDeHash();
        uth.put("Carlos", 31456742);
        uth.put("Alberto", 31213151);
        uth.put("Camilo", 315623213);
        uth.put("Alejandro", 31456742);
        uth.put("Daniel", 313123542);
        int num1 = uth.get("Carlos");
        int num2 = uth.get("Camilo");
        int num3 = uth.get("Alberto");
        int num4 = uth.get("Daniel");
        if(num1 == 31456742){
            System.out.println("El número 1 coincide");
        }else{
            System.out.println("El número 1 no coincide");
        }
        if(num2 == 315623213){
            System.out.println("El número 2 coincide");
        }else{
            System.out.println("El número 2 no coincide");
        }
        if(num3 == 31213151){
            System.out.println("El número 3 coincide");
        }else{
            System.out.println("El número 3 no coincide");
        }
        if(num4 == 313123542){
            System.out.println("El número 4 coincide");
        }else{
            System.out.println("El número 4 no coincide");
        }
        /**
         * Punto 2, 3 y 4
         */
        HashMap<String,String> empresasPaises = new HashMap<>();
        agregar(empresasPaises,"Google","Estados Unidos");
        agregar(empresasPaises,"La locura","Colombia");
        agregar(empresasPaises,"Nokia","Finlandia");
        agregar(empresasPaises,"Sony","Japon");
        boolean a = buscar(empresasPaises,"Sony");
        boolean b =buscar(empresasPaises,"Amazon");
        boolean c = buscar(empresasPaises,"Google");
        boolean d = contieneValue(empresasPaises, "Colombia");
        boolean e = contieneValue(empresasPaises, "China");
        boolean f = contieneValue(empresasPaises, "India");
        if(a && !b && c && d && !e && !f){
            System.out.println("El punto 2 esta bueno");
        }else{
            System.out.println("El punto 2 tiene algo malo");
        }
    }
}