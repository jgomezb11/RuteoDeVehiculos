import java.util.LinkedList;
import java.util.TreeSet;

public class Nodo{
    private String[][] matriz;
    private Nodo izq;
    private Nodo der;
    private int laColumna;
    private String elValor;
    private float gini;
    boolean exitoHoja;
    ImpurezaDeGini idg = new ImpurezaDeGini();
    Datos datos = new Datos();
    int a = datos.longitud;

    public Nodo (String[][] m){
        if (m.length < a/8){
            matriz = m;
            exitoHoja = calcularSiHayExitoONOEnUnaMatriz(m);
        }
        else{
            matriz = m;
            Pair<Integer,String> dato = encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(m);
            laColumna = dato.first;
            elValor = dato.second;
            gini = idg.impurezaPonderada(m, laColumna, elValor);
            String[][] mI = idg.matrizValoresDiferentes;
            String[][] mD = idg.matrizValoresIguales;
            Nodo izq = new Nodo(mI);
            Nodo der = new Nodo(mD);
        }
    }

    public boolean calcularSiHayExitoONOEnUnaMatriz(String[][] m){
        int count = 0;
        for(int i = 0; i < m.length; i++){
            if(m[i][m[0].length-1].equals("0")){
                count++;
            }
        }
        if(count > (a*85)/100){
            return true;
        }else{
            return false;
        }
    }

    public TreeSet<String> sacarLosValoresDiferentesSinRepetirDeUnaVariable(String[][] m, int posVariable){
        TreeSet<String> respuesta = new TreeSet();
        for (int fila = 0; fila < m.length; fila++)
            respuesta.add(m[fila][posVariable]);
        return respuesta;
    }

    public Pair<Integer,String> encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(String[][] m){
        TreeSet<String> valores = null;
        String elMejorValorDentreTodoElMundo = "";
        float laImpurezaMenorDentreTodoElmundo = 1;
        int laPosDeLaVariableDondeEstaElMejorValor = -1;
        for (int columna = 0; columna < m[0].length - 1; columna++) {
            valores = sacarLosValoresDiferentesSinRepetirDeUnaVariable(m, columna);
            for (String unValor : valores) {
                float impurezaPonderadaDeEstaColumnaConEsteValor = idg.impurezaPonderada(m, columna, unValor);
                if (impurezaPonderadaDeEstaColumnaConEsteValor < laImpurezaMenorDentreTodoElmundo){
                    laImpurezaMenorDentreTodoElmundo = impurezaPonderadaDeEstaColumnaConEsteValor;
                    elMejorValorDentreTodoElMundo = unValor;
                    laPosDeLaVariableDondeEstaElMejorValor = columna;
                }
            }
        }
        Pair<Integer,String> respuesta = new Pair(laPosDeLaVariableDondeEstaElMejorValor, elMejorValorDentreTodoElMundo);
        return respuesta;
    }

}