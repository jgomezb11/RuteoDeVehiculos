/**
 * La clase ImpurezaDeGini se encarga de sacar la impureza de gini respecto a la variable que se quiere dividir.
 *
 * @author Juan Pablo Rincon - Julian Gomez Benitez
 */
public class ImpurezaDeGini {

    String[][] matrizValoresIguales; // Matriz donde se guardaran los valores iguales de una variable.
    String[][] matrizValoresDiferentes;// Matriz donde se guardaran los valores que no sean iguales de una variable.

    /**
     * Método encargado de calcular la impureza de gini de una matriz, en este caso será la matriz con los datos ya leidos.
     * La impureza de gini se utiliza para atributos con valores continuos y nos permite saber cuan desordenados quedan los nodos dividos.
     * @param m la matriz con los datos ya cargados.
     * @return devuelve la impureza de gini de la matriz.
     */
    public static float sacarGini(String[][] m){
        float losQueTienenExito = 0;
        for (int fila = 0; fila < m.length; fila++){
            if (m[fila][m[0].length-1].equals("1"))
                losQueTienenExito++;
        }
        float losQueNoTienenExito = m.length - losQueTienenExito;
        float proporcionDeLosQueTienenExito = losQueTienenExito/m.length;
        float proporcionDeLosQueNoTieneExito = losQueNoTienenExito/m.length;
        float impureza = 1 - (proporcionDeLosQueTienenExito*proporcionDeLosQueTienenExito + proporcionDeLosQueNoTieneExito*proporcionDeLosQueNoTieneExito);
        return impureza;
    }

    /**
     * Método encargado de sacar el gini de 2 matrices y calcular el gini ponderado de ellas.
     * @param matrizDeLaIzq matriz con los estudiantes que cumplio la condición para dividirla.
     * @param matrizDeLaDer matriz con los estudiantes que no cumplieron con la condición para dividirla.
     * @return el gini poderador de entre las 2 matries.
     * @leer sacarGini(String[][] m).
     */
    public float calcularElGiniPonderado(String[][] matrizDeLaIzq, String[][] matrizDeLaDer){
        float elGiniDeLaMatrizDeLaIzquierda = sacarGini(matrizDeLaIzq);
        float elGiniDeLaMatrizDeLaDerecha = sacarGini(matrizDeLaDer);
        float elGiniPonderado = (elGiniDeLaMatrizDeLaIzquierda*matrizDeLaIzq.length +
                elGiniDeLaMatrizDeLaDerecha*matrizDeLaDer.length) / (matrizDeLaIzq.length + matrizDeLaDer.length);
        return elGiniPonderado;
    }

    /**
     * Método encargado de sacar la impureza ponderada de gini entre una matriz, dividiendola en 2 mediante una condición.
     * Si se cumple la condición dividira a los estudiantes en la matriz de la izquierda.
     * Si no cumplen con la condición se dividira a los estudiantes en la matriz de la derecha.
     * @param m la matriz de los estudiantes a dividir mediante el parametro @posVariable.
     * @param posVariable la posible variable que dividira a los estudiantes en 2 matrices (posición de matriz).
     * @param valor el valor que debe contener la posible vairable para que los estudiantes se puedan dividr en 2 grupos (valor de matriz).
     * @return devuelve la impureza ponderada de dividir a un grupo de estudiantes en una categoria.
     * @leer calcularElGiniPonderado(String[][] matrizDeLaIzq, String[][] matrizDeLaDer).
     */
    public float impurezaPonderada(String[][] m, int posVariable, String valor){
        int estudiantesConValorIgual = 0;
        for (int fila = 0; fila < m.length; fila++)
            if (m[fila][posVariable].equalsIgnoreCase(valor))
                estudiantesConValorIgual++;
        int estudiantesConValorDiferente = m.length - estudiantesConValorIgual;
        matrizValoresIguales = new String[estudiantesConValorIgual][m[0].length];
        matrizValoresDiferentes = new String[estudiantesConValorDiferente][m[0].length];
        // Copiar los datos a las matrices
        int fila = 0;
        int filaN1 = 0;
        int filaN2 = 0;
        while(fila<m.length)
        {
            if(m[fila][posVariable].equalsIgnoreCase(valor))
            {
                matrizValoresIguales[filaN1]=m[fila];
                fila++;filaN1++;
            }else
            {
                matrizValoresDiferentes[filaN2]=m[fila];
                fila++;filaN2++;
            }
        }
        float impurezaPonderada = calcularElGiniPonderado(matrizValoresIguales,matrizValoresDiferentes);
        return impurezaPonderada;
    }

    /**
     * Método encargado de sacar la impureza ponderada de gini entre una matriz, dividiendola en 2 mediante una condición.
     * Si se cumple la condición dividira a los estudiantes en la matriz de la izquierda.
     * Si no cumplen con la condición se dividira a los estudiantes en la matriz de la derecha.
     * @param m la matriz de los estudiantes a dividir mediante el parametro @posVariable.
     * @param posVariable la posible variable(valor decimal) que dividira a los estudiantes en 2 matrices (posición de matriz).
     * @param valor el valor que debe contener la posible vairable(valor decimal) para que los estudiantes se puedan dividr en 2 grupos (valor decimal de la matriz).
     * @return devuelve la impureza ponderada de dividir a un grupo de estudiantes en una categoria.
     * @leer calcularElGiniPonderado(String[][] matrizDeLaIzq, String[][] matrizDeLaDer).
     */
    public float impurezaPonderada(String[][] m, int posVariable, float valor){
        int estudiantesConValorIgual = 0;
        for (int fila = 0; fila < m.length; fila++)
            if (Float.parseFloat(m[fila][posVariable]) >= valor)
                estudiantesConValorIgual++;
        int estudiantesConValorDiferente = m.length - estudiantesConValorIgual;
        matrizValoresIguales = new String[estudiantesConValorIgual][m[0].length];
        matrizValoresDiferentes = new String[estudiantesConValorDiferente][m[0].length];
        // Copiar los datos a las matrices
        int fila = 0;
        int filaN1 = 0;
        int filaN2 = 0;
        while(fila<m.length)
        {
            if(Float.parseFloat(m[fila][posVariable]) >= valor)
            {
                matrizValoresIguales[filaN1]=m[fila];
                fila++;filaN1++;
            }else
            {
                matrizValoresDiferentes[filaN2]=m[fila];
                fila++;filaN2++;
            }
        }
        float impurezaPonderada = calcularElGiniPonderado(matrizValoresIguales,matrizValoresDiferentes);
        return impurezaPonderada;
    }
}
