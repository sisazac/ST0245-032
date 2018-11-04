import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.geometry.Point3D;
import java.util.ArrayList;
import java.lang.Math;

/**
 * Implementacion de un algoritmo para prevenir Colisiones
 * Estructura de datos utilizada: Arreglos
 * Complejidad: Peor Caso O(n al cubo) y Mejor caso O(n al cuadrado)
 *
 * @author Mauricio Toro
 * @version 1
 */
public class PrevencionColisiones1
{
    static boolean [][][] conjuntoDeAbejas;
    static int xl = 0;
    static int yl = 0;
    static int zl = 0;
    /**
     * Metodo para aproximar la distancia entre dos abejas roboticas
     *
     * @param  abeja1  la primera abeja
     * @param  abeja2  la segunda abeja
     * @return la distancia aproximada entre las dos abejas, aproximando 1 grado como 111111 metros
     */
    /*public static double distancia(Point3D abeja1, Point3D abeja2){
      return Math.sqrt(  Math.pow((abeja1.getX() - abeja2.getX())*111111,2) +
      Math.pow((abeja1.getY() - abeja2.getY())*111111,2) +
      Math.pow(abeja1.getZ() - abeja2.getZ(),2)
      );
      }*/
    /**
     * Metodo para leer un archivo de abejas y almacenarlas en un arreglo de puntos en 3D
     *
     * @param  numeroDeAbejas  El numero de abejas a leer
     * @return un arreglo de puntos 3D donde cada elemento representa las coordenadas de una abeja
     */

    public static Abeja[] leerArchivo(int numeroDeAbejas){
	final String nombreDelArchivo = "ConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";
	Abeja[] arregloDeAbejas = new Abeja[numeroDeAbejas];
	try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine(); // Descarta la primera linea
            int index = 0;
            while (lineaActual != null){ // Mientras no llegue al fin del archivo
                String [] cadenaParticionada = lineaActual.split(",");
                Abeja abeja = new Abeja(cadenaParticionada[0],
					cadenaParticionada[1],
					cadenaParticionada[2]);
                arregloDeAbejas[index++] = abeja;
                lineaActual = br.readLine();
            }
	}
	catch(IOException ioe) {
	    System.out.println("Error leyendo el archivo de entrada");
	}
	return arregloDeAbejas;
    }

    public static void tamaño(Abeja[] arregloDeAbejas){
        double AuxminX= arregloDeAbejas[0].getX();
        double AuxminY= arregloDeAbejas[0].getY();
        double AuxminZ= arregloDeAbejas[0].getZ();
        double AuxmaxX= arregloDeAbejas[0].getX();
        double AuxmaxY= arregloDeAbejas[0].getY();
        double AuxmaxZ= arregloDeAbejas[0].getZ();
        for (int i=0;i<=arregloDeAbejas.length-1;i++){
            if (arregloDeAbejas[i].getX()<=AuxminX){
                AuxminX=arregloDeAbejas[i].getX();
            } 
            if (arregloDeAbejas[i].getX()>=AuxmaxX){
                AuxmaxX=arregloDeAbejas[i].getX();
            } 
            if (arregloDeAbejas[i].getY()<=AuxminY){
                AuxminY=arregloDeAbejas[i].getY();
            } 
            if (arregloDeAbejas[i].getY()<AuxmaxY){
                AuxmaxY=arregloDeAbejas[i].getY();
            }
            if (arregloDeAbejas[i].getZ()<AuxminZ){
                AuxminZ=arregloDeAbejas[i].getZ();
            } 
            if (arregloDeAbejas[i].getZ()<AuxmaxZ){
                AuxmaxZ=arregloDeAbejas[i].getZ();
            } 
        }
        double deltaX= ((AuxmaxX-AuxminX)/70.71067812)*10000;
        double deltaY= ((AuxmaxY-AuxminY)/70.71067812)*10000;
        double deltaZ= ((AuxmaxZ-AuxminZ)/70.71067812)*10000;
        xl=(int)deltaX;
        //System.out.println(xl);
        yl=(int)deltaY;
        zl=(int)deltaZ;
        conjuntoDeAbejas=new boolean[xl][yl][zl];
    }
    
    /**
     * Algoritmo para prevenir colisiones (genera muchas respuestas repetidas)
     *
     * @param  arregloDeAbejas  Un arreglo con coordenadas de las abejas
     * @return una lista definida con arreglos con las abejas que tienen riesgo de colision
     */
    public static Abeja[] detectarColisiones(Abeja[] arregloDeAbejas){
	Abeja aux = null;
	int x = 0;
	int y = 0;
	int z = 0;
	for (int i = 0; i < arregloDeAbejas.length ; ++i)
	    {
		aux = arregloDeAbejas[0];
		x = (int)(aux.getX()*100000) % xl;
		y = (int)(aux.getY()*100000) % yl;
		z = (int)(aux.getZ()*100000) % zl;
		if(conjuntoDeAbejas[x][y][z] == false)
		    {
			conjuntoDeAbejas[x][y][z] = true;
		    }else if(conjuntoDeAbejas[x][y][z] == true)
		    {
			aux.setColision(true);
		    }
	    }
	return arregloDeAbejas;
    }  
    /**

     * Metodo para escribir un archivo con la respuesta

     *

     * @param  abejasConRiesgoDeColision  Lista definida con arreglos con las abejas con riesgo de colision

     * @param  numeroDeAbejas  Numero de abejas del conjunto de datos original

     */

    /* public static void guardarArchivo(ArrayList<Point3D> abejasConRiesgoDeColision, int numeroDeAbejas){

        final String nombreDelArchivo = "respuestaConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";

	try {

	    PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");

	    for (Point3D abeja : abejasConRiesgoDeColision)

		escritor.println(abeja.getX()+","+abeja.getY()+","+abeja.getZ());

	    escritor.close();

	}

	catch(IOException ioe) {

	    System.out.println("Error escribiendo el archivo de salida");

	}

    }*/



    public static void main(String[] args){
	// Recibir el numero de abejas como parametro
	final int numeroDeAbejas = args.length == 0 ? 10 : Integer.parseInt(args[0]);
	// Leer el archivo con las coordenadas de las abejas
	Abeja[] arregloDeAbejas = leerArchivo(numeroDeAbejas);
	// Prevenir las colisiones revisando todas con todas
	long startTime = System.currentTimeMillis();
	Abeja[] abejasConRiesgoDeColision = detectarColisiones(arregloDeAbejas);
	// Guardar en un archivo las abejas con riesgo de colision   
	long estimatedTime = System.currentTimeMillis() - startTime;
	System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
	//guardarArchivo(abejasConRiesgoDeColision, numeroDeAbejas);
    }
}