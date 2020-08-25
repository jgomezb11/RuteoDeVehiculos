package Lab01;

public class ejerciciosEnLinea {

    //Recursión 1
    //Ejercicio 1
    /**
     * Este método saca el factorial de un número dado.
     * @param n Es el número al cual se le va
     * a sacar el factorial.
     * @return el factorial de n.
     */
    public int factorial(int n) {
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }
    //T(n) = c_2 + T(n-1)

    //Ejercicio 2

    public int bunnyEars(int bunnies) {
        if(bunnies == 0){
            return 0;
        }
        return 2 + bunnyEars(bunnies-1);
    }
    // T(n) = c_3 + 2 + T(n-1)

    //Ejercicio 3
    /**
     * Este método calcula el número de Fibonacci en
     * la posición dada.
     * @param n la posición en la cual se desea conocer
     * el valor del número de fibonacci.
     * @return el valor de fibonacci en la posición n.
     */
    public int fibonacci(int n) {
        if(n == 0){
            return 0;
        }if(n == 1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    // T(n) = T(n-1) + T(n-2)
    //Ejercicio 4
    /**
     * Este método calcula la cantidad de orejas
     * que hay en una cantidad dada de conejos, siendo
     * los conejos en posiciones pares de tres orejas
     * y los conejos en posiciones impares de dos orejas.
     * @param bunnies la cantidad de conejos
     * @return la cantidad de orejas, teniendo
     * los conejos en posición par tres orejas y
     * los conejos en posición impar dos orejas.
     * Se retorna la suma total de orejas.
     */

    public int bunnyEars2(int bunnies) {
        if(bunnies == 0){
            return 0;
        }
        return (bunnies % 2 == 0)? 3 + bunnyEars2(bunnies - 1): 2 + bunnyEars2(bunnies - 1);
    }
    // T(n) = T(n-1) + c_1
    //Ejercicio 5
    /**
     * @param rows la cantidad de filas horizontales
     * que tiene el triángulo.
     * @return el número de bloques necesarios para 
     * construir dicho triángulo con las filas dadas.
     */
    public int triangle(int rows) {
        if(rows == 0){
            return 0;
        }
        return rows + triangle(rows - 1);
    }
    //T(n) = c_2 + T(n-1)

    //Recursión 2
    //Ejercicio 1
    /**
     * Este método determina si dado un arreglo de enteros,
     * es posible escoger un grupo de algunos enteros, de tal
     * manera que, la suma del grupo sea igual al entero objetivo (target).
     * @param start posición de comienzo del arreglo.
     * @param nums arreglo de enteros a considerar.
     * @param target valor esperado.
     * @return true si la suma del grupo es igual al
     * entero dado. De lo contrario, retorna false.
     */
    public boolean groupSum6(int start, int[] nums, int target) {
        if(start == nums.length){
            return target == 0;
        }
        if(groupSum6(start+1, nums, target - nums[start]) || (nums[start] != 6 && groupSum6(start+1, nums, target))){ return true;}
        return false;
    }
    //T(n) = 2 T(n-1) + c_2

    //Ejercicio 2
     /**
     * Este método determina si, dado un arreglo de enteros,
     * es posible escoger un grupo de algunos de los enteros,
     * comenzando por el índice de inicio (start), tal que la
     * suma de los elementos en el grupo sea igual al (entero dado)
     * objetivo (target). Sin embargo, con la restricción de que si 
     * un valor en el arreglo es incluído en el grupo, el valor
     * que sigue inmediatamente a este en el arreglo no puede
     * ser incluído.
     * @param start índice o posición de inicio.
     * @param nums arreglo de enteros a considerar.
     * @param target valor esperado.
     * @return true si se cumple. De lo contrario retorna false.
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start >= nums.length){
            return target == 0;
        }
        if (groupNoAdj(start+1, nums, target) || (groupNoAdj(start+2, nums, target-nums[start]))){return true;}
        return false;
    }
    // T(n) = 2 T(n-1) + c_2

    //Ejercicio 3
     /**
     * Este método determina si, dado un arreglo de enteros,
     * se puede dividir el arreglo en dos nuevos arreglos,
     * de tal manera que, la suma de ambos grupos sea la misma.
     * Con la condición adicional de que todos los números que
     * sean múltiplos de 5 deben estar en un grupo, y todos los
     * que sean múltiplos de 3 (y solamente de 3, no de 5),
     * deberán estar en otro grupo.
     * En este método se trabaja con un auxiliar
     * que evalúa todos los condicionales y devuelve el
     * resultado al método split53
     * @param nums arreglo de enteros a considerar.
     * @return true si se cumple. De lo contrario retorna false.
     */

    public static boolean split53(int[] nums) {
        int index = 0;
        int sum1 = 0;
        int sum2 = 0;
        return recArray(nums, index, sum1, sum2);
    }

    private static boolean recArray ( int[] nums, int index, int sum1, int sum2 ) {
        if ( index >= nums.length ) {
            return sum1 == sum2;
        }
        int value = nums[index];
        if (value%5 == 0) {
            return recArray(nums, index + 1, sum1 + value, sum2);
        } else if (value%3 == 0) {
            return recArray(nums, index + 1, sum1, sum2 + value);
        } else {
            return (recArray(nums, index + 1, sum1 + value, sum2) ||
                    recArray(nums, index + 1, sum1, sum2 + value));
        }
    }
    //T(n) = 2 T(n-1) + c_2

    //Ejercicio 4
    /**
     * Este método determina si, dado un arreglo de enteros,
     * es posible tomar un grupo de algunos de los enteros,
     * comenzando por el índice o posición de inicio (start),
     * de tal manera que la suma de los elementos en el grupo
     * sea igual al entero objetivo dado (target). Sin embargo,
     * con la condición adicional de que si hay números en el
     * arreglo que son adyacentes y tienen ambos el mismo valor,
     * se abren dos posibilidades: La primera en la que se pueden
     * incluir a todos en el grupo, o la segunda, que es no incluir
     * a ninguno.
     * @param start índice o posición de inicio.
     * @param nums arreglo de enteros a considerar.
     * @param target valor esperado.
     * @return true si se cumple. De lo contrario retorna false.
     */
    public boolean groupSumClump(int start, int[] nums, int target) {
        altArray(nums);
        if (start >= nums.length) return target == 0;
        if (groupSumClump(start+1, nums, target-nums[start])) return true;
        if (groupSumClump(start+1, nums, target)) return true;
        else return false;
    }
    private void altArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                nums[i-1] += nums[i];
                if (i+1 < nums.length && nums[i] != nums[i+1])
                    nums[i] = 0;
                else if (i == nums.length-1)
                    nums[i] = 0;
            }
        }
    }
    // T(n) = 2 T(n-1) + c_2

    //Ejercicio 5
    /**
     * Este método determina si, dado un arreglo de enteros,
     * es posible dividir el arreglo en dos nuevos arreglos,
     * de tal manera que la suma de los dos grupos sea la misma.
     * Cada entero debe estar en uno u otro grupo.
     * @param nums arreglo de enteros a considerar.
     * @return true si se cumple. De lo contrario retorna false.
     */
    public static boolean splitArray(int[] nums) {
        return splitArrayHelper(0, nums, 0, 0);
    }

    public static boolean splitArrayHelper(int start, int[] nums, int group1, int group2) {
        if (start >= nums.length) {
            return group1 == group2;
        }
        if (splitArrayHelper(start+1, nums, group1 + nums[start], group2)) {
            return true;
        }
        if (splitArrayHelper(start+1, nums, group1, group2 + nums[start])) {
            return true;
        }
        return false;
    }
    //T(n) = 2 T(n-1) + c_2

}
