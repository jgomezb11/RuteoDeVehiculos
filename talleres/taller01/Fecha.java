/**
 * La clase Fecha tiene la intención de representar el tipo abstracto fecha.
 *
 * @author Julian Gomez, Juan Pablo Rincon.
 * @version 1
 */
public class Fecha {

    private int dia;
    private int mes;
    private int año;

    /**
     *Se inicializan los atributos de clase
     */
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    /**
     * Método para obtener la variable global dia.
     *
     * @return el día en que se encuentra la variable.
     */
    public int dia(){
        return this.dia;
    }

    /**
     * Método para obtener la variable global mes.
     *
     * @return el mes en que se encuentra la variable.
     */
    public int mes(){
        return this.mes;
    }

    /**
     * Método para obtener la variable global año.
     *
     * @return el año en que se encuentra la variable.
     */
    public int año(){
        return this.año;
    }

    /**
     *  Método para comparar fechas, retorna los siguientes digitos respectivamente:
     *
     *    -1 si esta fecha es anterior a la otra
     *    0 si son iguales
     *    1 si esta fecha es posterior a la otra
     *
     */
    public int compararFecha(Fecha otra){
        //Años
        if(this.año < otra.año){
            return -1;
        }
        if(this.año > otra.año){
            return 1;
        }
        //Mes
        if(this.mes < otra.mes){
            return -1;
        }if(this.mes > otra.mes){
            return 1;
        }
        //Día
        if(this.dia < otra.dia){
            return -1;
        }
        if(this.dia > otra.dia){
            return 1;
        }
        return 0;
    }

    /**
     *  Método toString para poder visualizar las fechas
     * @return la fecha del objeto.
     */
    public String toString(){
        return "Dia: " + dia + "\n" + "Mes: " + mes + "\n" + "Año: " + año;
    }
}
