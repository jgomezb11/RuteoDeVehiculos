public class Main {
    public static void main(String[] args) {
        Datos datos = new Datos();
        datos.leerDatos();
        ImpurezaDeGini idg = new ImpurezaDeGini();
        System.out.println(idg.impurezaPonderada(datos.datos, 13, "0 A 10 LIBROS"));
        System.out.println(idg.impurezaPonderada(datos.datos, 28, "Postgrado"));
        System.out.println(idg.impurezaPonderada(datos.datos, 29, "Educación profesional completa"));
        System.out.println(idg.impurezaPonderada(datos.datos, 30, "Trabajador por cuenta propia"));
        System.out.println(idg.impurezaPonderada(datos.datos, 31, "Hogar"));
        System.out.println(idg.impurezaPonderada(datos.datos, 55, "ACADÉMICO"));
        System.out.println(idg.impurezaPonderada(datos.datos, 65, 50));
        System.out.println(idg.impurezaPonderada(datos.datos, 66, 50));
        System.out.println(idg.impurezaPonderada(datos.datos, 67, 50));
        System.out.println(idg.impurezaPonderada(datos.datos, 68, 50));
        System.out.println(idg.impurezaPonderada(datos.datos, 69, 50));
        System.out.println(idg.impurezaPonderada(datos.datos, 70, 50));
        System.out.println(idg.impurezaPonderada(datos.datos, 71, 50));
        System.out.println(idg.impurezaPonderada(datos.datos, 72, 50));
    }
}
