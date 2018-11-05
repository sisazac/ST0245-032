
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main (String [] args){
        PrevencionColisiones colisiones= new PrevencionColisiones();
        colisiones.tamaño(colisiones.leerArchivo(100));
        colisiones.detectarColisiones(colisiones.arregloDeAbejas);
        colisiones.imprimirResultado();
        //colisiones.guardarArchivo(100);
        //prueba colisiones= new prueba();
        //colisiones.tamaño(colisiones.leerArchivo(100));
        //colisiones.detectarColisiones(colisiones.arregloDeAbejas);
        //colisiones.imprimirResultado();
    }
}
