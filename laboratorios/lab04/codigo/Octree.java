package Lab04.codigo;

/**
 * Esta es nuestra estructura de datos, Octree. Este se encargará de posicionar cada abeja en un cuadrante específico,
 * para que pueda determinar si choca o no. Su función principal estará dividida en ocho cuadrantes, en 3D.
 * Si se encuentra más de una abeja en un cuadrante, este cuadrante se dividirá en múltiples subóctonos, encontrado
 * en los límites de esta, hasta que la abeja esté sola, o dentro de un cuadrante diagonal de menos de 100 metros de longitud.
 * Esto se hace para asegurar que todas las abejas dentro de este cuadrante estén en peligro de chocar.
 * @author: Juan Pablo Rincon | Julian Gomez
 * @version: 1
 * @leer Octree
 * @leer Bee
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Octree
{
    private double midD,midW,midH;
    /**
     * Este será el método que representa el Octree, en este método se hará toda la recursividad, aquí se asignará cada abeja
     * a su respectivo sector del Octree, representado por una ArrayList de 8 espacios (cada uno representando cada sector), donde
     * almacenarse en una LinkedList. El proceso de decidir a qué sector va cada abeja se realizará mediante el método hash. Después de cada abeja
     * está ubicado en un sector que pasará a crear las sub-vistas del Octree con el nuevo método Octree. Antes de seguir creando
     * las nuevas subdivisiones del Octree, se pregunta si la diagonal real es menor a 100 metros, de ser así se empezará a imprimir la
     * abejas ubicadas en los sectores donde hay más de una abeja.
     * @param abejas: Arraylist con la cantidad de abejas
     * @param mins: Lista de las posiciones de las cordenadas
     * @param midD: promedio de latitudes
     * @param midW: promedio de longitudes
     * @param midD: promedio de altitudes
     * @leer hashing
     * @leer nuevoOct
     */
    public void octree (LinkedList<Bee> abejas,ArrayList<Double> mins,double midD,double midW,double midH) {
        this.midD = midD;
        this.midW = midW;
        this.midH = midH;
        ArrayList<LinkedList<Bee>> octree = new ArrayList(8);
        for (int i=0;i<8;++i) {
            LinkedList<Bee> ab = new LinkedList();
            octree.add(ab);
        }
        for (int i=0;i<abejas.size();++i){
            Bee abeja = abejas.poll();
            int sector = hashing(abeja,mins);
            octree.get(sector).addFirst(abeja);
        }
        double ph=Math.sqrt(Math.pow((midD)*111325,2)+Math.pow((midW)*111325,2)); //Primera hipotenusa
        double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((midH),2));
        if (diagonal>100) {
            for (int i=0;i<8;++i) {
                if (octree.get(i).size()>1) {
                    nuevoOctree(octree.get(i),mins,i);
                }
            }
        } else {
            for (int i=0;i<8;++i) {
                if (octree.get(i).size()>0) choque(octree.get(i));
            }
        }
    }

    /**
     * Este método se encargará de recibir cada abeja que se encuentre en el octárbol, y colocarla en un determinado sector de la estructura de datos,
     * para que se ubique en el espacio de la tabla ArrayList correspondiente al sector en el que se posiciona la abeja. Determina el
     * sector comparando el mínimo, es decir, los vértices del Octree, más los valores medios del Octree con los que se está trabajando.
     * @param abeja: abeja que sera ubicada.
     * @param mins: este ArrayList contendrá el mínimo, es decir, el vértice compuesto por cada coordenada. Este parámetro
     * es necesario poder hacer una ubicación adecuada para cada abeja, porque el uso de este parámetro simplificará el código para que solo
     * Deberá agregarse un valor para determinar si una abeja está en un sector o en otro.
     * @ número de retorno del sector en el que se encuentra la abeja.
     */
    private int hashing(Bee abeja,ArrayList<Double> mins) {
        if (abeja.getLatitude()<=mins.get(0)+midD) {
            if (abeja.getLongitude()<=mins.get(1)+midW) {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 2;
                } else {
                    return 3;
                }
            }
        } else {
            if (abeja.getLongitude()<=mins.get(1)+midW) {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 4;
                } else {
                    return 5;
                }
            } else {
                if (abeja.getAltitude()<=mins.get(2)+midH) {
                    return 6;
                } else {
                    return 7;
                }
            }
        }
    }

    /**
     * Este método se encarga de realizar la recursividad, con respecto al método del octárbol principal. Recibe los parámetros correspondientes a
     * las abejas ubicadas en el sector, y los vértices de este, que están en el ArrayLis minutos. Con el sector paramtero identifican cómo
     * Los vértices del siguiente sub-octárbol deberían redefinirse, ya que varían según el sector.
     * @param abejas: abejas del sector correspondiente.
     * @param mins: son los valores mínimos de coordenadas, a los que se sumarán otros parámetros para redefinir el
     * vértice del próximo Octree. Tómalo como si fuera uno de los vértices del octárbol.
     * @param sector: sector en el que se ubica.
     */
    public void nuevoOctree(LinkedList<Bee> abejas,ArrayList<Double> mins,int sector) {
        if (sector==0) {
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==1) {
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==2) {
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==3) {
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==4) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==5) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else if (sector==6) {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        } else {
            double nuevoD=mins.get(0)+midD;
            mins.remove(0);
            mins.add(0,nuevoD);
            double nuevoW=mins.get(1)+midW;
            mins.remove(1);
            mins.add(1,nuevoW);
            double nuevoH=mins.get(2)+midH;
            mins.remove(2);
            mins.add(2,nuevoH);
            octree(abejas,mins,midD/2,midW/2,midH/2);
        }
    }

    /**
     * Se carga un sector del árbol, estas se imprimen si estan en riesgo de colisión
     * @param abejas: abejas de un sector
     */
    public void choque(LinkedList<Bee> abejas) {
        //System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (Bee abeja:abejas) {
            System.out.println(abejas.poll().getLatitude()+","+abejas.poll().getLongitude()+","+abejas.poll().getAltitude());
        }
    }
}