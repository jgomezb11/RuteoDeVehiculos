import java.util.LinkedList;

/**
 * La clase Test se encarga de probar el árbol creado, después de entrenarlo.
 *
 * @author Juan Pablo Rincon - Julian Gomez Benitez
 */
public class Test{

    public static LinkedList<Pair<Integer, String>> struct = Nodo.struct2;
    ImpurezaDeGini idg2 = new ImpurezaDeGini();
    int longitudInicial = Datos.longitudTest;

    /**
     * Método encargado de poner a prueba a el algoritmo, primero se realiza el entrenamiento del modelo, ahora con los datos
     * se dispone a revisar que si sea capaz de predecir gente.
     * @param matriz conjunto
     * @param cont es un contador para saber cuales imprimir.
     * @use impurezaPonderada(matriz, we.first, we.second) y datosRelevantesTest().
     */
    public void test(String [][] matriz, int cont){
        if(struct.isEmpty()){
            return;
        }
        Pair<Integer, String> we = struct.removeFirst();
        idg2.impurezaPonderada(matriz, we.first, we.second);
        String[][] mI = idg2.matrizValoresDiferentes;
        String[][] mD = idg2.matrizValoresIguales;
        if(cont == 0){
            float verdaderosPositivos = 0;
            float verdaderosTotales = Datos.datosRelevantesTest();
            for(int i = 0; i < mD.length; i++){
                if(mD[i][mD[0].length-1].equals("0")){
                    verdaderosPositivos++;
                }
            }
            System.out.println("La precisión es: " + (verdaderosPositivos/mD.length));
            System.out.println("Los recuperados son: " + (verdaderosPositivos/verdaderosTotales));
            //System.out.println("La exactitud es: " + ((verdaderosPositivos + ())/longitudInicial));
        }
        if(cont == 1){
            cont++;
            test(mI, cont);
        }else {
            cont++;
            test(mI, cont);

            test(mD, cont);
        }
    }
}