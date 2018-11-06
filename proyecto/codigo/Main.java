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
        long startTime2 = System.currentTimeMillis();
        colisiones.areaDeUbicacion(colisiones.leerArchivo(1000000));
        long estimatedTime2 = System.currentTimeMillis() - startTime2;
        System.out.println("El algoritmo areaDeUbicacion tomo un tiempo de: "+estimatedTime2+" ms");
        
        long startTime = System.currentTimeMillis();
        colisiones.detectarColisiones(colisiones.arregloDeAbejas);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo detectarColisiones tomo un tiempo de: "+estimatedTime+" ms");
        
        long startTime1 = System.currentTimeMillis();
        colisiones.guardarArchivo(1000000);
        long estimatedTime1 = System.currentTimeMillis() - startTime1;
        System.out.println("El algoritmo guardarArchivo tomo un tiempo de: "+estimatedTime1+" ms");

    }
}
