package Lab04.codigo;


/**Se encarga de probar la estrucutra de datos creada para las abejas.
 *
 * @author Juan Pablo Rincon | Julian Gomez
 * @version 1
 */
import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
public class Main
{
    public static void main(String[] args) throws IOException {
        Reader rm = new Reader();
        try {
            //System.out.println("Porfavor ingrese la direccion donde se encuentran las coordenadas de las abejas");
            //Scanner dir=new Scanner(System.in);
            //String direccion=dir.nextLine();
            ArrayList<Long> a = new ArrayList();
            for (int i = 0;i < 13;++i){
                long ab = 0;
                a.add(ab);
            }
            ArrayList<Long> memoria = new ArrayList();
            for (int i = 0;i < 13;++i) {
                long ab=0;
                memoria.add(ab);
            }
            for (int i = 0;i < 100;++i){
                System.out.println(i);
                long start = System.currentTimeMillis();
                if (i==0) {
                    System.gc();
                }
                rm.leer("src\\Lab04\\codigo\\ConjuntoDeDatosCon4abejas.csv");
                if (i==0) {
                    Runtime rt = Runtime.getRuntime();
                    long usedMB = (rt.totalMemory()-rt.freeMemory())/1024/1024;
                    memoria.add(0,usedMB);
                    System.out.println("Memory Usage:"+ usedMB);
                }
                long tiempo=System.currentTimeMillis()-start;
                long ti=a.get(0)+tiempo;
                a.add(0,ti);
                a.remove(1);
                start=System.currentTimeMillis();
                if (i==0) {
                    System.gc();
                }
                rm.leer("src\\Lab04\\codigo\\ConjuntoDeDatosCon10abejas.csv");
                if (i==0) {
                    Runtime rt=Runtime.getRuntime();
                    long usedMB=(rt.totalMemory()-rt.freeMemory())/1024/1024;
                    memoria.add(0,usedMB);
                    System.out.println("Memory Usage:"+usedMB);
                }
                tiempo=System.currentTimeMillis()-start;
                ti=a.get(1)+tiempo;
                a.add(1,ti);
                a.remove(2);
                start=System.currentTimeMillis();
                if (i==0) {
                    System.gc();
                }
                rm.leer("src\\Lab04\\codigo\\ConjuntoDeDatosCon15abejas.csv");
                if (i==0) {
                    Runtime rt=Runtime.getRuntime();
                    long usedMB=(rt.totalMemory()-rt.freeMemory())/1024/1024;
                    memoria.add(0,usedMB);
                    System.out.println("Memory Usage:"+usedMB);
                }
                tiempo=System.currentTimeMillis()-start;
                ti=a.get(2)+tiempo;
                a.add(2,ti);
                a.remove(3);
                start=System.currentTimeMillis();
                if (i==0) {
                    System.gc();
                }
                rm.leer("src\\Lab04\\codigo\\ConjuntoDeDatosCon150abejas.csv");
                if (i==0) {
                    Runtime rt=Runtime.getRuntime();
                    long usedMB=(rt.totalMemory()-rt.freeMemory())/1024/1024;
                    memoria.add(0,usedMB);
                    System.out.println("Memory Usage:"+usedMB);
                }
                tiempo=System.currentTimeMillis()-start;
                ti=a.get(4)+tiempo;
                a.add(4,ti);
                a.remove(5);
                start=System.currentTimeMillis();
                if (i==0) {
                    System.gc();
                }
                rm.leer("src\\Lab04\\codigo\\ConjuntoDeDatosCon1000abejas.csv");
                if (i==0) {
                    Runtime rt=Runtime.getRuntime();
                    long usedMB=(rt.totalMemory()-rt.freeMemory())/1024/1024;
                    memoria.add(0,usedMB);
                    System.out.println("Memory Usage:"+usedMB);
                }
                tiempo=System.currentTimeMillis()-start;
                ti=a.get(5)+tiempo;
                a.add(5,ti);
                a.remove(6);
                start=System.currentTimeMillis();
                if (i==0) {
                    System.gc();
                }
                rm.leer("src\\Lab04\\codigo\\ConjuntoDeDatosCon1500abejas.csv");
                if (i==0) {
                    Runtime rt=Runtime.getRuntime();
                    long usedMB=(rt.totalMemory()-rt.freeMemory())/1024/1024;
                    memoria.add(0,usedMB);
                    System.out.println("Memory Usage:"+usedMB);
                }
                tiempo=System.currentTimeMillis()-start;
                ti=a.get(6)+tiempo;
                a.add(6,ti);
                a.remove(7);
            }
            for (int i=0;i<13;++i){
                long promedio=a.get(i)/100;
                System.out.println(promedio);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}