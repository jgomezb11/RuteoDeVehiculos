package Lab04.codigo;

/**
 * Este objeto se encarga de almacenar las posiciones de las abjeas en un instante
 * las posiciones son leidas dentro de la clase Reader.
 * @author Juan Pablo Rincon | Julian Gomez
 * @version: 1
 */
public class Bee
{
    private double latitude;
    private double longitude;
    private double altitude;
    /**
     * Este es el método constructor de la clase
     * @param latitude: latitud en grados
     * @param longitude: longitud en grados
     * @param altitude: altitud en metros
     */
    public Bee (double latitude, double longitude, double altitude){
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    /**
     * método getter de latitud
     * @return el valor de latitud
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     * método getter de longitud
     * @return el valor de la longitud
     */
    public double getLongitude(){
        return longitude;
    }

    /**
     * método getter de altitud
     * @return el valor de la altitud
     */
    public double getAltitude(){
        return altitude;
    }
}