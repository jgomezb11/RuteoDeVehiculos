import java.util.ArrayList;
/**
 * La clase Punto tiene la intención de representar coordenadas en el espacio y calcular su distancia.
 * 
 * @author Juan Pablo Rincon, Julian Gomez
 * @version 1
 */

public class Punto {

    private double x, y;

    /**
     * Se inicializan los atributos de clase
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Método para obtener la variable global x.
     *
     * @return eje coordenado x
     */
    public double x() {
        return x;
    }

    /**
     * Método para obtener la variable global y.
     *
     * @return eje coordenado y
     */
    public double y() {
        return y;
    }

    /**
     * Método para obtener el radio polar, en este caso se puede obtener por medio del teorema de pitágoras.
     * 
     *
     * @return radio polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver más <a/>
     */
    
    public double radioPolar() {
        return Math.sqrt((Math.pow(this.x,2)) + ((Math.pow(this.y,2))));
    }


    /**
     * Método para obtener el ángulo polar, en este caso se puede obtener por medio de la tangente inversa.
     * 
     *
     * @return angulo polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver más <a/>
     */
    public double anguloPolar() {
        return Math.atan2(this.y, this.x);
    }

    /**
     * Método para obtener la distacia euclidiana. La distacia
     * euclidiana o euclídea es la distancia "ordinaria" (que se mediría con una regla) entre 
     * dos puntos de un espacio euclídeo, la cual se deduce a partir del teorema de Pitágoras.
     * En otras palabras es halla el radio polar a la diferencia entre los dos puntos.
     *
     *
     *
     * @return distancia euclidiana (radio polar a la diferencia de dos puntos)
     *
     * @param otro Este parámetro hace referencia a otro Punto en el espacio con es cual se desea
     * comparar el Punto desde el cual fue llamado.
     * @see <a href="http://mathworld.wolfram.com/Distance.html"> Ver más <a/>
     */
  
    public double distanciaEuclidiana(Punto otro) {
        return Math.sqrt(Math.pow( (this.x - otro.x), 2) +
                         Math.pow( (this.y - otro.y), 2) );
    }
    

    /**
     *  Para realizar este punto hay que saber que tenemos y a donde vamos,
     *  Nos van a proporcionar 2 puntos en el plano cartesiano y nos interesa saber cuales puntos hay entre
     *  estos dos.
     *  Con estos 2 puntos hasta el momento tenemos algo en común "Su pendiente".
     *          y2-y1
     *      m = -----
     *          x2-x1
     *  Usaremos la ecuación de la recta para poder calcular la pendiente que siguen estos puntos y así poder
     *  llegar a los demás puntos que están en medio de los puntos.
     *
     *  Recordemos que la pendiente nos indica una razón de cambio con respecto al eje "Y" y el eje "X"
     *
     *  poniendo de ejemplo:
     *   Si tenemos la línea definida por los puntos (0,0) y (3,3), ¿cuáles son los puntos intermedios?
     *                                                | |     | |
     *                                               x1,y1   x2,y2
     *   Al aplicar la ecuación de la recta nos queda:
     *
     *              3-0           3
     *          m = ---  --> m = ---  ---> m = 1.
     *              3-0           3
     *
     *    La pendiente vale "1", lo que significa que, el eje "Y" y el "X" tienen una razón de cambio de 1.
     *    por lo tanto el próximo valor del siguiente punto después de (0,0) será:
     *    para el eje x será: valor anterior en punto del eje X + razón de cambio de X
     *    para el eje y será: valor anterior en punto del eje Y + razón de cambio de Y
     *
     *      así:
     *            Razón de cambio de X      Razón de cambio de Y
     *               |                                |
     *         X = 0+1 = 1                      Y = 0+1 = 1
     *             |                                |
     *      Valor anterior                  Valor anterior
     *
     * de modo que nos quedará el siguiente punto: "(1,1)", si seguimos aplicando el mismo proceso hasta
     * llegar al punto (3,3) tendremos que los puntos intermedios son: (1,1) , (2,2)
     *
     * En conclusión los puntos (0,0), (1,1), (2,2), (3,3) tienen la misma pendiente y por eso podemos hallarlos
     *
     * @param punto1 este punto me proporciona información del eje "X" y del "Y" para obtener la pendiente.
     * @param punto2 este punto me proporciona información del eje "X" y del "Y" para obtener la pendiente.
     * @return devuelvo los puntos intermedio entre los dos puntos dados.
     */
    public ArrayList<Punto> dibujarLinea2D(Punto punto1, Punto punto2){
        //Creo un ArrayList donde almacénare los puntos intermedios
        ArrayList<Punto> puntosIntermedio = new ArrayList<>();
        //Guardo las razones de cambio de cada eje, tanto X como Y.
        double cambioEnY = punto2.y() - punto1.y();
        double cambioEnX = punto2.x() - punto1.x();
        //Ahora procedo a simplificar el resultado si es posible, debido a que la formula es una fracción.
        //Para ello se busca su MCD(Máximo comun divisor).
        double simplificar = mcd(cambioEnY,cambioEnX);
        cambioEnY = cambioEnY/simplificar;
        cambioEnX = cambioEnX/simplificar;
        // Se incia desde el primer punto hasta llegar a el último, para ello se crea un objeto punto
        //el objeto punto se inicia desde el primero, ya que recorreremos todos los que hayan entre el punto1 y punto2
        Punto recorridoEntrePuntos = punto1;
        //Se recorre hasta que se llegue hasta el punto2, ahí sabremos que hemos recorrido todos los puntos
        //Que se pueden encontrar entre estos.
        while(recorridoEntrePuntos.x() != punto2.x() && recorridoEntrePuntos.y() != punto2.y()){
            //Se agrega el punto
            puntosIntermedio.add(recorridoEntrePuntos);
            //Se halla el nuevo punto con:
            //para el eje x será: valor anterior en punto del eje X + razón de cambio de X
            //para el eje y será: valor anterior en punto del eje Y + razón de cambio de Y
            recorridoEntrePuntos = new Punto(recorridoEntrePuntos.x() + cambioEnX, recorridoEntrePuntos.y() + cambioEnY);
        }
        //Se agrega el punto final.
        puntosIntermedio.add(punto2);
        //Se retorna la lista de puntos agregados.
        return puntosIntermedio;
    }

    /**
     * Este método me sirve para simplificar fracciones, debido a que la ecuacion de la recta
     * es una ecuación que termina siendo una fracción.
     *
     * @param numerador me da el numerador de la fracción
     * @param denominador me da el denominador de la fracción
     * @return retorna el máximo comun divisor, así podremos saber si se puede simplificar.
     */
    public double mcd(double numerador, double denominador){
        numerador = Math.abs(numerador);
        denominador = Math.abs(denominador);
        if(numerador == 0){
            return denominador;
        }
        double r;
        while(denominador!=0){
            r = numerador % denominador;
            numerador = denominador;
            denominador = r;
        }
        return numerador;
    }

    /**
     * @return este método me retorna los atributos de un punto.
     */
    public String toString(){
        return "(" + x +", "+ y + ")";
    }
}