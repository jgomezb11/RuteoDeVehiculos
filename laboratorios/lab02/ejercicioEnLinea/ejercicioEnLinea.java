package Lab02;


public class ejercicioEnLinea {
    /**
     * Este método se encarga de contar cuantos números pares hay en el arreglo.
     * @param nums es el arreglo donde hay números pares e impares.
     * @return la cantidad de números pares que hay en el arreglo
     */
    public int countEvens(int[] nums) {
        int count = 0; // c1
        for(int i = 0; i < nums.length; i++){ // T(n) = c2 * n + c3
            if(nums[i] % 2 == 0){ // (c4) * n
                count++; // c5
            }
        }
        return count;
    }
    // T(n) = c1 + c2 * n + c3 + c4 * n + c5 * n
    // T(n) = O(c2 * n + c3) ==> T(n) = O(n)
    // Donde n es el tamaño del arreglo

    /**
     * Este método busca el valor máximo y mínimo y devuelve la diferencia entre estos dos
     * valores.
     * @param nums es el arreglo donde estan los valores.
     * @return la diferencia entre el valor máximo del arreglo y el mínimo.
     */
    public int bigDiff(int[] nums){
        int maxAux = 0; // c1
        int minAux = 0; // c2
        int max = 0; // c3
        int min = Integer.MAX_VALUE; // c4
        for(int i = 0; i < nums.length; i++){ // T(n) = c4 * n + c5
            for(int j = 0; j < nums.length ;j++){ // T(n) = (c6 * n + c7) * n
                maxAux = Math.max(nums[i],nums[j]); // c8 * n * n
                if(maxAux > max){ // c9 * n * n
                    max = maxAux; // c10 * n * n
                }
                minAux = Math.min(nums[i],nums[j]); // c11 * n * n
                if(minAux < min){ // c12 * n * n
                    min = minAux; // c13 * n * n
                }
            }
        }
        return max - min;
    }
    // T(n) = c1 + c2 + c3 + c4 + c4 * n + c5 + c6 * n^2 + c7 * n + c8 * n^2 + c9 * n^2 + c10 * n^2 + c11 * n^2 + c12 * n^2 + c13 * n^2
    // T(n) = O(c6 * n^2 + c7 * n) ==> T(n) = O(n^2)
    // Donde n es el tamaño del arreglo

    /**
     * Dado un arreglo devolver verdadero si en él no aparecen unos y no aparecen tres, de caso contrario
     * devolver verdadero.
     * @param nums arreglo con los númeors dados.
     * @return devuelve si no hay númerso unos y números tres en el arreglo.
     */
    public boolean lucky13(int[] nums) {
        boolean has1 = false; // c1
        boolean has3 = false; // c2
        for(int i = 0; i < nums.length; i++){ // T(n) = c3 * n + c4
            if(nums[i] == 1){ //c5 * n
                has1 = true; // c6 * n
            }
            if(nums[i] == 3){ // c7 * n
                has3 = true; // c8 * n
            }
        }
        return !has1 && !has3;
    }
    // T(n) = c1 + c2+ c3 * n + c4 + c5 * n + c6 * n + c7 * n + c8 * n
    // T(n) = O(c3 * n + c4) ==> T(n) = O(n)
    // Donde n es el tamaño del arreglo

    /**
     * Este método devuelve verdadero si el arreglo cotiene 2 números 7 seguido uno detras de otro o
     * si hay dos sietes separados por otro número así {7, 1, 7}, en caso contrario retorna falso.
     * @param nums el arreglo en el cual se buscarán los sietes.
     * @return si hay 2 sietes uno seguido de otro o si hay 2 que esten separados por un número.
     */
    public boolean has77(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){ // T(n) = c1 * n + c2
            if(nums[i] == 7){ // c3 * n
                if((nums[i+1] == 7) || (i != nums.length-2 && nums[i+2] == 7)){ // c4 * n
                    return true; //c5 * n
                }
            }
        }
        return false;
    }
    // T(n) = c1 * n + c2 + c3 * n + c4 * n + c5 * n
    // T(n) = O(c1 * n + c2) ==> T(n) = O(n)
    // Donde n es el tamaño del arreglo

    /**
     * Este método evalua que haya un 1 en el arreglo y después de ese uno en cualquier posición aparezaca un 2
     * si esto se cumple retorna verdadero en caso contrario falso.
     * @param nums el arreglo con los número a evaluar
     * @return si después de un 1 hay un dos en cualquier posición delante del 1
     */
    public boolean has12(int[] nums) {
        boolean has1 = false; // c1
        boolean has2 = false; // c2
        for(int i = 0; i < nums.length; i++){ // T(n) = c3 * n + c4
            if(nums[i] == 1){ // c5 * n
                has1 = true; // c6 * n
            }
            if(nums[i] == 2 && has1){ // c7 * n
                has2 = true; //c8 * n
            }
        }
        return (has1&&has2)?true:false;
    }
    // T(n) = c1 + c2 + c3 * n + c4 + c5 * n + c6 * n + c7 * n + c8 * n
    // T(n) = O(c3 * n + c4) ==> T(n) = O(n)
    // Donde n es el tamaño del arreglo

    /**
     * Dado un arreglo, considere buscar un intervalo inclusivo de números, para ello
     * se buscará un primer elemento a la izquierda y después se buscará la misma aparición de ese elemento
     * a la derecha, cada que se pase un valor dentro del intervalo contara como 1.
     * devuelva el intervalo más grande que se puede hacer con el arreglo.
     * @param nums el arreglo al cual se le buscarán los intervalos.
     * @return la longitud inclusiva del intervalo encontrado.
     *           elemento 1  elemento2
     *           |           |
     *  ejemplo {1, 3, 6, 2, 1, 5} la longitud seria de 5
     */
    public int maxSpan(int[] nums) {
        int count = 0; // c1
        int aux = 0; // c2
        for(int i = 0; i < nums.length; i++){ // T(n) = c3 * n + c4
            int firstDig = nums[i]; //c5 * n
            for(int j = nums.length-1; j >= i; j--){ // T(n) = (c6 * n +c7)n
                if(nums[j] == firstDig){ // c8 * n * n
                    aux = j-i+1; // c9 * n * n
                    if(aux > count){ // c10 * n * n
                        count = aux; // c11 * n * n
                    }
                }
            }
        }
        return count;
    }
    // T(n) = c1 + c2 + c3 * n + c4 + c5 * n + c6 n^2 + c7 * n + c8 * n^2 + c9 * n^2 + c10 * n^2 + c11 * n^2
    // T(n) = O(c6 n^2 + c7 * n) ==> T(n) = O(n^2)
    // Donde n es el tamaño del arreglo

    /**
     * Este método devuelve una arreglo que contiene la misma cantidad de 3 y 4 que estarán distribuidos en
     * el arreglo, la idea es organizar los 4 de manera que queden después de un 3, la idea es dejar los
     * 3 fijos y los 4 son los que se moveran dentro de el arreglo.
     * @param nums arreglo donde estan todos los números y a organizar 3 y 4's.
     * @return el arreglo con los 4 después de los 3.
     */
    public int[] fix34(int[] nums) {
        int [] res = new int[nums.length]; // c1
        int [] pos3 = new int[nums.length]; // c2
        int [] pos4 = new int[nums.length]; // c3
        int iterator3 = 0; //c4
        int iterator4 = 0; // c5
        int aux = 0; // c6
        for(int i = 0; i < nums.length; i++){ // T(n) = c7 * n + c8
            if(nums[i] == 3){ // c9 * n
                pos3[iterator3] = i; // c10 * n
                iterator3 += 1; //c11 * n
            }
            if(nums[i] == 4){ // c12 * n
                pos4[iterator4] = i; // c13 * n
                iterator4 += 1; // c14 * n
            }
        }
        res = nums; // c15
        int [] pos31= new int[iterator3]; //c16
        for(int i = 0; i < pos31.length; i++){ // T(n) = c17 * n + c18
            pos31[i] = pos3[i]; //c19 * n
        }
        for(int i = 0; i < pos31.length; i++){// T(n) = c20 * n + c21
            aux = res[pos31[i]+1]; // c22 * n
            res[pos31[i]+1] = res[pos4[i]]; // c23 * n
            res[pos4[i]] = aux; // c24 * n
        }
        return res;
    }
    // T(n) = c1 + c2 + c3 + c4 + c5 + c6 + c7 * n + c8 + c9 * n + c10 * n + c11 * n + c12 * n + c13 * n + c14 * n + c15 + c16 + c17 * n + c18 + c19 * n + c20 * n + c21 + c22 * n + c23 * n + c24 *n
    // T(n) = c7 * n + c8 ==> T(n) = O(n)
    // Donde n es el tamaño del arreglo

    /**
     *Este método determina si se puede dividir el arrelo de tal forma que al sumar los de un lado sea
     * igual a la suma de los del otro lado.
     * @param nums el arreglo a dividir.
     * @return si se puede dividir de tal manera que la suma de uno sea igual a la del otro es verdadero
     */
    public boolean canBalance(int[] nums) {
        int lSum = 0; // c1
        for (int i = 0; i < nums.length; i++) { // T(n) = c2 * n + c3
            lSum += nums[i]; // c4 * n
            int rSum = 0; // c5 * n
            for (int j = nums.length-1; j > i; j--) { //T(n) = (c6 * n + c7) * n
                rSum += nums[j]; // c8 * n * n
            }
            if (rSum == lSum) // c9 * n
                return true;
        }
        return false;
    }
    // T(n) = c1 + c2 * n + c3 + c4 * n + c5 * n + c6 * n^2 + c7 * n^2 + c8 * n^2 + c9 * n
    // T(n) = O(c6 * n^2 + c7) ==> T(n) = O(n^2)
    // Donde n es el tamaño del arreglo

    /**
     * dado dos arreglos outer e inner, ambos ordenados de menor a mayor, devuelve verdadero si todos
     * los elementos de inner aparecen en el outer, en caso contrario devuelve falso.
     * @param outer arreglo con elementos ordenados de menor a mayor donde se comparará con los elementos de
     *              inner.
     * @param inner arreglo con elementos ordeandos de menor a mayor.
     * @return verdadero si todos los elementos de inner estan en outer.
     */
    public static boolean linearIn(int[] outer, int[] inner) {
        int timesOfTrue = inner.length; // c1
        int timesCount = 0; // c2
        for(int i = 0; i < outer.length; i++){ // T(n) = c3 * n + c4
            if(!(timesCount == inner.length)){ // c5 * n
                if(inner[timesCount] == outer[i]){ // c6 * n
                    timesCount += 1; // c7 * n
                }
            }else{break;}
        }
        return timesCount == timesOfTrue;
    }
    // T(n) = c1 + c2 + c3 * n + c4 + c5 * n + c6 * n
    // T(n) = O(c3 * n + c4) ==> T(n) = O(n)
    // Donde n es el tamaño del arreglo outer

    /**
     * dado un entero n >= 0, cree un arreglo con longitud n * n, y llenelo con la siguiente secuencia
     * por ejemplo para n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1}, sin contar los espacios, solo estan para
     * ver la secuencia por ejemplo para n=2 : {0, 1,   2, 1}.
     * @param n va a hacer la cantidad de subconjuntos del arreglo y nos servira para saber cual es la
     *          longitud del arreglo.
     * @return devuelve un arreglo de longitud n * n con el patrón para ese número.
     */
    public int[] squareUp(int n) {
        int array[] = new int[n*n]; // c1
        for(int i = 0; i < n; i++){ // T(n) = c2 * n + c3
            for(int j = 0; j < n; j++){ //T(n) = (c4 * n + c5) * n
                if(j < n - i - 1){ // c6 * n * n
                    continue; // c7 * n * n
                }
                array[i * n + j] = n - j; // c8 * n * n
            }
        }
        return array;
    }
    // T(n) = c1 + c2 * n c3 + c4 * n^2 + c5 * n + c6 * n^2 + c7 * n^2 + c8 * n^2
    // T(n) = O(c4 * n^2 + c5 * n) ==> T(n) = O(n^2)
    // Donde n es el tamaño del arreglo creado por la entrada n y seteado como n * n
}
