package Taller03;

/**
 *
 * La clase Taller3 tiene como objtivo dar solución a los puntos del taller 3
 *
 * @author Julian Gomez, Juan Pablo Rincon.
 * @version 1
 */


public class Taller3 {

    /**
     *
     * El método torresDeHannoi es un auxiliar del proceso
     * @param n numero de discos
     *
     */

    public static void torresDeHannoi(int n) {
        torresDeHannoiAux(n, 1, 2, 3);
    }

    /**
     *
     * El método torresDeHannoi es un auxiliar del proceso
     * @param n numero de discos
     * @param origen la torre número uno donde se posicionan todos los discos inicialmente
     * @param destino la torre donde deben posicionarse todos los discos terminado el proceso
     * @param intermedio torre auxiliar para que el cambio de torres se haga efectivo
     *
     * debe devolver la secuencia de pasos en consola de esta manera:
     * System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
     *
     * @see <a href="http://www.uterra.com/juegos/torre_hanoi.php"> Simulación del funcionamiento</a>
     * @see <a href="https://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i"> Un poco de historia </a>
     */

    private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
        if(n == 1){
            System.out.println("Disco "+ n + " desde "+ origen + " hacia "+ destino);
        }else{
            torresDeHannoiAux(n-1 ,origen ,destino ,intermedio);
            System.out.println("Disco "+ n + " desde "+ origen + " hacia "+ destino);
            torresDeHannoiAux(n-1 ,intermedio ,origen ,destino);
        }
    }

    /**
     *
     * El método combinations es un auxiliar del proceso
     * @param s es la cadena a permutar
     */
    public static void combinations(String s) {
        combinationsAux("", s);
    }

    /**
     *
     * El método combinationsAux es el core del proceso, en el se busca conseguir
     * las posibles permutaciones que puede tener la cadena s
     * @param s es la cadena a permutar
     * @param prefix cadena auxiliar donde se guarda la cadena de salida
     *
     * Las cadenas de salida tienes una longitud desde 0 hasta el lenght de la cadena s
     * por simplicidad del ejercicio no se repiten letras y el orden de la secuencia
     * no supone importancia, es decir, la cadena AB es igual a la cadena BA.
     * Ej: para la cadena ABC se tiene la salida: { A, AB, ABC, AC, B, BC, C}
     *
     */
    private static void combinationsAux(String prefix, String s) {
        if(s.length() > 0) {
            System.out.println(prefix + s.charAt(0));
            combinationsAux(prefix + s.charAt(0),s.substring(1));
            combinationsAux(prefix,s.substring(1));
        }
    }

    /**
     *
     * El método permutation es un auxiliar del proceso
     * @param str es la cadena a permutar
     */
    public static void permutation(String str) {
        permutationAux("", str);
    }

    /**
     *
     * El método permutationAux es el core del proceso, en el se busca conseguir
     * las posibles permutaciones que puede tener la cadena str
     * @param str es la cadena a permutar
     * @param prefix cadena auxiliar donde se guarda la cadena de salida
     *
     * Las cadenas de salida tienes una longitud de lenght de la cadena s
     * Ej: para la cadena AB se tiene la salida: { ABC,ACB,BAC,BCA,CAB,CBA }
     * donde los caracteres no se repiten pero el orden tiene un papel importante.
     *
     */
    private static void permutationAux(String prefix, String str) {
        int n = str.length();
        if(n == 0){
            System.out.println(prefix);
        }else{
            for(int i = 0; i < n; i++) {
                permutationAux(prefix + str.charAt(i),str.substring(0,i) + str.substring(i+1,n));
            }
        }
    }

    private static boolean comprobar (int fila, int reinas[], int n)
    {

        for (int i=0; i<fila; i++)
            if (  ( reinas[i]==reinas[fila] )                      // Misma columna
                    || ( Math.abs(fila-i) == Math.abs(reinas[fila]-reinas[i]) ) ) // Misma diagonal
                return false;

        return true;
    }
    public static void colocarReina (int fila, int reinas[], int n)
    {
        if (fila<n) {
            // Quedan reinas por colocar
            for (reinas[fila]=0; reinas[fila]<n; reinas[fila]++) {
                // Comprobamos si la posición
                // de la reina actual es válida
                if (comprobar(fila,reinas,n)) {
                    // Si es así, intentamos colocar
                    // las reinas restantes
                    colocarReina (fila+1, reinas, n);
                }
            }

        } else {
            // No quedan reinas por colocar (solución)
            mostrarTablero(reinas,n);
        }
    }

    private static void mostrarTablero (int reinas[], int n)
    {
        System.out.println("Posiciones: ");
        for(int a = 0; a < reinas.length; a++){
            System.out.print(reinas[a]+" ,");
        }
        System.out.println();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (reinas[i]==j)
                    System.out.printf("#");
                else
                    System.out.printf("-");
            }
            System.out.printf(" %d %d\n",i,reinas[i]);
        }
        System.out.printf("\n");
    }
    static int M = 8;
    static int N = 8;

    public static void floodFillUtil(int screen[][], int x, int y,
                              int prevC, int newC)
    {
        if (x < 0 || x >= M || y < 0 || y >= N)
            return;
        if (screen[x][y] != prevC)
            return;

        screen[x][y] = newC;

        floodFillUtil(screen, x+1, y, prevC, newC);
        floodFillUtil(screen, x-1, y, prevC, newC);
        floodFillUtil(screen, x, y+1, prevC, newC);
        floodFillUtil(screen, x, y-1, prevC, newC);
    }

    static void floodFill(int screen[][], int x, int y, int newC)
    {
        int prevC = screen[x][y];
        floodFillUtil(screen, x, y, prevC, newC);
    }
}