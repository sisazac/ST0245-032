import java.util.*;

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
        colisiones.tamaño(colisiones.leerArchivo(1000));
        long startTime = System.currentTimeMillis();
        colisiones.detectarColisiones(colisiones.arregloDeAbejas);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
        //colisiones.imprimirResultado();
    }
}