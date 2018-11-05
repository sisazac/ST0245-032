import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.geometry.Point3D;
import java.util.*;
import java.lang.Math;

/**
 * Implementacion de un algoritmo para prevenir Colisiones
 * Estructura de datos utilizada: Arreglos
 * Complejidad: Peor Caso O(n al cubo) y Mejor caso O(n al cuadrado)
 *
 * @author Mauricio Toro
 * @version 1
 */
public class PrevencionColisiones
{
    static Stack [][][] conjuntoDeAbejas;
    static Abeja[] arregloDeAbejas;
    static int xl = 0;
    static int yl = 0;
    static int zl = 0;
    static double AuxminX;
    static double AuxminY;
    static double AuxminZ;
    static int cont=1;
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
        arregloDeAbejas = new Abeja[numeroDeAbejas];
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
                arregloDeAbejas[index] = abeja;
                index++;
                lineaActual = br.readLine();
            }
        }
        catch(IOException ioe) {
            System.out.println("Error leyendo el archivo de entrada");
        }
        return arregloDeAbejas;
    }

    public static void tamaño (Abeja[] arregloDeAbejas){
        AuxminX= arregloDeAbejas[0].getX();
        AuxminY= arregloDeAbejas[0].getY();
        AuxminZ= arregloDeAbejas[0].getZ();
        double AuxmaxX= arregloDeAbejas[0].getX();
        double AuxmaxY= arregloDeAbejas[0].getY();
        double AuxmaxZ= arregloDeAbejas[0].getZ();
        for (int i=0;i<=arregloDeAbejas.length-1;i++){
            if (arregloDeAbejas[i].getX()<AuxminX){
                AuxminX=arregloDeAbejas[i].getX();
            } 
            if (arregloDeAbejas[i].getX()>AuxmaxX){
                AuxmaxX=arregloDeAbejas[i].getX();
            } 
            if (arregloDeAbejas[i].getY()<AuxminY){
                AuxminY=arregloDeAbejas[i].getY();
            } 
            if (arregloDeAbejas[i].getY()>AuxmaxY){
                AuxmaxY=arregloDeAbejas[i].getY();
            }
            if (arregloDeAbejas[i].getZ()<AuxminZ){
                AuxminZ=arregloDeAbejas[i].getZ();
            } 
            if (arregloDeAbejas[i].getZ()>AuxmaxZ){
                AuxmaxZ=arregloDeAbejas[i].getZ();
            } 
        }
        double deltaX= ( (AuxmaxX-AuxminX)*111111)/ (100/(Math.sqrt(3)));
        double deltaY= ( (AuxmaxY-AuxminY)*111111)/ (100/(Math.sqrt(3)));
        double deltaZ= (AuxmaxZ-AuxminZ)/ (100/(Math.sqrt(3)));
        double auxlado=(50* Math.sqrt(2));
        xl= (int)deltaX;
        //System.out.println(xl);
        yl= (int)deltaY;
        zl=(int)deltaZ;
        if(xl==0)xl=1;
        if(yl==0)yl=1;
        if(zl==0)zl=1;
        conjuntoDeAbejas=new Stack[xl][yl][zl];
    }

    /**
     * Algoritmo para prevenir colisiones (genera muchas respuestas repetidas)
     *
     * @param  arregloDeAbejas  Un arreglo con coordenadas de las abejas
     * @return una lista definida con arreglos con las abejas que tienen riesgo de colision
     */
    public static void detectarColisiones(Abeja[] arregloDeAbejas){
        Abeja aux = null;
        int x;
        int y;
        int z;
        for (int i = 0; i < arregloDeAbejas.length ; ++i)
        {
            aux = arregloDeAbejas[i];
            x = (int)( ( (aux.getX()-AuxminX)*111111)/ (100/(Math.sqrt(3))) );
            y = (int)( ( (aux.getY()-AuxminY) *111111) / (100/(Math.sqrt(3))));
            z = (int)((aux.getZ()-AuxminZ) / (100/(Math.sqrt(3))));
            if(x>0)x--;
            if(y>0)y--;
            if(z>0)z--;
            if(conjuntoDeAbejas[x][y][z]== null){
                Stack<Abeja> colision= new Stack<>();
                colision.push(aux);
                conjuntoDeAbejas[x][y][z]=colision;
            }else{
                conjuntoDeAbejas[x][y][z].push(aux);
            }
        }
    } 

    /** Metodo para imprimir pila
     * 
     */
    public static void imprimirPila(Stack <Abeja> colision){
        Abeja aux= colision.pop();
        System.out.println(cont + " " +aux.getX() + "     " + aux.getY() + "     " + aux.getZ()+ "\n");
        cont++;
        if(colision.empty()!=true){
            imprimirPila(colision);
        }

    }

    /**Metodo para imprimir las respuestas
     * 
     */

    public static void imprimirResultado(){
        System.out.println("Coordenadas de abejas que colisionan");
        System.out.println("Coordenada x       " + "Coordenada y      "+ "Coordenada z"+ "\n");
        for(int i=0;i< conjuntoDeAbejas.length;i++){
            for(int j=0;j< conjuntoDeAbejas[0].length;j++){
                for(int k=0;k<conjuntoDeAbejas[0][0].length;k++){
                    if(i>0 && j>0 && k>0){
                        if(i<conjuntoDeAbejas.length-1 && j<conjuntoDeAbejas[0].length-1 && k<conjuntoDeAbejas[0][0].length-1){
                            if(conjuntoDeAbejas[i][j][k]!=null && conjuntoDeAbejas[i][j][k].size()==1){
                                int cont2= 0;
                                int x= i-1;
                                while(x<=i+1){
                                    int y= j-1;
                                    while(y<=j+1){
                                        int z= k-1;
                                        while(z<= k+1){
                                            if(conjuntoDeAbejas[x][y][z]!=conjuntoDeAbejas[i][j][k]){
                                                if(conjuntoDeAbejas[x][y][z]!=null && conjuntoDeAbejas[x][y][z].size()==1){
                                                    Stack<Abeja> aux = conjuntoDeAbejas[x][y][z];
                                                    Abeja aux2= aux.pop();
                                                    System.out.println("["+ x +"]" + "["+ y +"]" + "[" + z + "]"+ "\n");
                                                    System.out.println(cont + " " +aux2.getX() + "     " + aux2.getY() + "     " + aux2.getZ()+ "\n");
                                                    cont++;
                                                    cont2++;
                                                }
                                            }
                                            z++;
                                        }
                                        y++;
                                    }
                                    x++;
                                }
                                if(cont2!=0){
                                    Stack<Abeja> aux = conjuntoDeAbejas[i][j][k];
                                    Abeja aux2= aux.pop();
                                    System.out.println("["+ i +"]" + "["+ j +"]" + "[" + k + "]"+ "\n");
                                    System.out.println(cont + " " +aux2.getX() + "     " + aux2.getY() + "     " + aux2.getZ()+ "\n");
                                    cont++;
                                    cont2=0;
                                }
                            }
                        }
                    }	
                    if(conjuntoDeAbejas[i][j][k]!=null && conjuntoDeAbejas[i][j][k].size()>1){
                        System.out.println("["+ (i) +"]" + "["+ j +"]" + "[" + k + "]"+ "\n");
                        imprimirPila(conjuntoDeAbejas[i][j][k]);
                    }
                }
            }

        }
    }

    /** Metodo para imprimir pila2
     * 
     */
    public static void imprimirPila2(Stack <Abeja> colision, PrintWriter escritor){
        Abeja aux= colision.pop();
        escritor.println(cont + " " +aux.getX() + "     " + aux.getY() + "     " + aux.getZ()+ "\n");
        cont++;
        if(colision.empty()!=true){
            imprimirPila2(colision,escritor);
        }

    }

    /**
     * Metodo para escribir un archivo con la respuesta
     *
     * @param  abejasConRiesgoDeColision  Lista definida con arreglos con las abejas con riesgo de colision
     * @param  numeroDeAbejas  Numero de abejas del conjunto de datos original
     */

    public static void guardarArchivo( int numeroDeAbejas){
        final String nombreDelArchivo = "respuestaConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";  
        int cont=1;
        try {
            PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
            escritor.println("Coordenadas de abejas que colisionan");
            escritor.println("Coordenada x       " + "Coordenada y      "+ "Coordenada z"+ "\n");
            for(int i=0;i< conjuntoDeAbejas.length;i++){
                for(int j=0;j< conjuntoDeAbejas[0].length;j++){
                    for(int k=0;k<conjuntoDeAbejas[0][0].length;k++){
                        if(conjuntoDeAbejas[i][j][k]!=null && conjuntoDeAbejas[i][j][k].size()>1){
                            escritor.println("["+ (i) +"]" + "["+ j +"]" + "[" + k + "]"+ "\n");
                            imprimirPila2(conjuntoDeAbejas[i][j][k], escritor);
                        }
                    }
                }
            }
            escritor.close();
        }
        catch(IOException ioe) {
            System.out.println("Error escribiendo el archivo de salida");
        } 
    }

    public static void main(String[] args){
        // Recibir el numero de abejas como parametro
        final int numeroDeAbejas = args.length == 0 ? 10 : Integer.parseInt(args[0]);
        // Leer el archivo con las coordenadas de las abejas
        Abeja[] arregloDeAbejas = leerArchivo(numeroDeAbejas);
        // Prevenir las colisiones revisando todas con todas
        long startTime = System.currentTimeMillis();
        //Abeja[] abejasConRiesgoDeColision = detectarColisiones(arregloDeAbejas);
        // Guardar en un archivo las abejas con riesgo de colision   
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
        //guardarArchivo(abejasConRiesgoDeColision, numeroDeAbejas);
    }
}