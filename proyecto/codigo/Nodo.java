import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
    int longitudInicial = datos.longitud;

    int[] d = new int[]{0, 1, 2, 3, 4, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 32, 33, 34, 37, 38, 39, 40, 41, 43, 45, 46, 47, 48, 49, 50, 52, 53, 56, 57, 58, 59, 61, 62, 63, 64, 74, 75, 76};
    List<Integer> you = Arrays.stream(d).boxed().collect(Collectors.toList());
    TreeSet<Integer> valoresNoPermitidos = new TreeSet<Integer>();

    public Nodo (String[][] m){
        valoresNoPermitidos.addAll(you);
        if (m.length <= (longitudInicial*33)/100){
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
        if(count > (m.length*80)/100){
            System.out.println("Alguno dio");
            return true;
        }else{
            System.out.println("Estan perdidos");
            return false;
        }
    }

    public TreeSet<String> sacarLosValoresDiferentesSinRepetirDeUnaVariable(String[][] m, int posVariable){
        TreeSet<String> respuesta = new TreeSet<String>();
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
            if(valoresNoPermitidos.contains(columna)){
                continue;
            }
            for (String unValor : valores) {
                float impurezaPonderadaDeEstaColumnaConEsteValor = Math.min((idg.impurezaPonderada(m, columna, unValor)),((!unValor.isEmpty()&&(unValor.matches("^[0-9]*$")))?idg.impurezaPonderada(m, columna,70.0f):1.0f));
                if (impurezaPonderadaDeEstaColumnaConEsteValor < laImpurezaMenorDentreTodoElmundo){
                    laImpurezaMenorDentreTodoElmundo = impurezaPonderadaDeEstaColumnaConEsteValor;
                    elMejorValorDentreTodoElMundo = unValor;
                    laPosDeLaVariableDondeEstaElMejorValor = columna;
                }
            }
        }
        Pair<Integer,String> respuesta = new Pair<Integer,String>(laPosDeLaVariableDondeEstaElMejorValor, elMejorValorDentreTodoElMundo);
        return respuesta;
    }

}
