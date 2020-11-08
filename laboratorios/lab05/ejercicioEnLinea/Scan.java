package Lab05.EjercicioEnLinea;

import javax.tools.Diagnostic;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scan {

    public Scan() {
    }

    public void readBicolor() throws FileNotFoundException {

        Scanner read = new Scanner(new File("src\\Lab05\\EjercicioEnLinea\\Entrada.txt"));
        String line = read.nextLine();
        Scanner scanLine = new Scanner(line);
        DigraphAM am = null;

        int nodos = scanLine.nextInt();
        while (nodos != 0) {
            am = new DigraphAM(nodos);
            line = read.nextLine();
            scanLine = new Scanner(line);
            int aris = scanLine.nextInt();
            for (int i = 0; i < aris; i++){
                line = read.nextLine();
                scanLine = new Scanner(line);
                am.addArc(scanLine.nextInt(), scanLine.nextInt(), 1);
            }
            line = read.nextLine();
            scanLine = new Scanner(line);
            nodos = scanLine.nextInt();
            am.imprimir();
            Node node = new Node(nodos);
            if (Algorithm.DFSColorFC(am,node)){
                System.out.println("BICOLORABLE");
            }else{
                System.out.println("NO BICOLORABLE");
            }
        }
    }
}