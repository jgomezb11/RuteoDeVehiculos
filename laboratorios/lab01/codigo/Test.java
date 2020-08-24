public class Test{
   public static void main (String[] args){
       String x, y;
       x = "abcdgh";
       y = "aedfhr";
       //x = Laboratorio1.leerDatos("Acipenser transmontanus mitochondrial DNA.txt");
       //y = Laboratorio1.leerDatos("Anoplogaster cornuta mitochondrial DNA.txt");
       long startTime = System.currentTimeMillis();
       System.out.print("La subsecuencia común más larga tiene una longitud de: " + Laboratorio1.lcs(x,y) + "\n");
       long estimatedTime = System.currentTimeMillis() - startTime;
       System.out.print(estimatedTime);
   }
}
