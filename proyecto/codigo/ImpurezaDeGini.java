public class ImpurezaDeGini {

    public float sacarGini(String[][] m){
        float losQueTienenExito = 0;
        for (int fila = 0; fila < m.length; fila++)
            if (m[fila][m[0].length-1].equals("1"))
                losQueTienenExito++;
        float losQueNoTienenExito = m.length - losQueTienenExito;
        float proporcionDeLosQueTienenExito = losQueTienenExito/m.length;
        float proporcionDeLosQueNoTieneExito = losQueNoTienenExito/m.length;
        float impureza = 1 - (proporcionDeLosQueTienenExito*proporcionDeLosQueTienenExito + proporcionDeLosQueNoTieneExito*proporcionDeLosQueNoTieneExito);
        return impureza;
    }

    public float calcularElGiniPonderado(String[][] matrizDeLaIzq, String[][] matrizDeLaDer){
        float elGiniDeLaMatrizDeLaIzquierda = sacarGini(matrizDeLaIzq);
        float elGiniDeLaMatrizDeLaDerecha = sacarGini(matrizDeLaDer);
        float elGiniPonderado = (elGiniDeLaMatrizDeLaIzquierda*matrizDeLaIzq.length +
                elGiniDeLaMatrizDeLaDerecha*matrizDeLaDer.length) /  (matrizDeLaIzq.length + matrizDeLaDer.length);
        return elGiniPonderado;
    }


    public  float impurezaPonderada(String[][] m, int posVariable, String valor){
        int estudiantesConValorIgual = 0;
        for (int fila = 0; fila < m.length; fila++)
            if (m[fila][posVariable].equalsIgnoreCase(valor))
                estudiantesConValorIgual++;
        int estudiantesConValorDiferente = m.length - estudiantesConValorIgual;
        String[][] matrizValoresIguales = new String[estudiantesConValorIgual][m[0].length];
        String[][] matrizValoresDiferentes = new String[estudiantesConValorDiferente][m[0].length];
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

    public  float impurezaPonderada(String[][] m, int posVariable, float valor){
        int estudiantesConValorIgual = 0;
        for (int fila = 0; fila < m.length; fila++)
            if (Float.parseFloat(m[fila][posVariable]) >= valor)
                estudiantesConValorIgual++;
        int estudiantesConValorDiferente = m.length - estudiantesConValorIgual;
        String[][] matrizValoresIguales = new String[estudiantesConValorIgual][m[0].length];
        String[][] matrizValoresDiferentes = new String[estudiantesConValorDiferente][m[0].length];
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

