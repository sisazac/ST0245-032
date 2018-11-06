
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.geometry.Point3D;
import java.util.*;
import java.lang.Math;

/**
 * Clase prevencion de colisiones
 * 
 * @author Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio
 * @version Octubre 2018
 */
public class PrevencionColisiones
{
    Stack<Abeja> [][][] conjuntoDeAbejas;
    Abeja[] arregloDeAbejas;
    int xl = 0;
    int yl = 0;
    int zl = 0;
    double AuxminX;
    double AuxminY;
    double AuxminZ;
    int cont=1;
    ArrayList<Abeja> adyacentes;
    
    /**
     * Metodo para leer un archivo de abejas y almacenarlas en un arreglo de puntos en 3D
     *
     * @param  numeroDeAbejas  El numero de abejas a leer
     * @return un arreglo de puntos 3D donde cada elemento representa las coordenadas de una abeja
     */

    public  Abeja[] leerArchivo(int numeroDeAbejas){
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
    
    
    /**
     * Metodo para definir el area de ubicacion de las abejas
     * @param arregloDeAbejas  numero total de abejas de abejas organizadas
     */
    public  void areaDeUbicacion (Abeja[] arregloDeAbejas){
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
     */
    public  void detectarColisiones(Abeja[] arregloDeAbejas){
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
        abejasAdyacentes();
    } 

    /** Metodo para encontrar abejas adyacentes
     * 
     */
    public  void abejasAdyacentes(){
        adyacentes= new ArrayList<>();
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
                                                    adyacentes.add(conjuntoDeAbejas[x][y][z].pop());
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
                                    adyacentes.add(conjuntoDeAbejas[i][j][k].pop());
                                    cont2=0;
                                }
                            }
                        }
                    }	

                }
            }

        }
    }

    /** Metodo para imprimir pila2
     * @param Colision Pila de abejas que colisionan
     * @param PrintWriter escritor para guardar el archivo
     */
    public  void imprimirPila(Stack <Abeja> colision, PrintWriter escritor){
        Abeja aux= colision.pop();
        escritor.println(cont + " " +aux.getX() + "         " + aux.getY() + "         " + aux.getZ()+ "\n");
        cont++;
        if(colision.empty()!=true){
            imprimirPila(colision,escritor);
        }

    }

    /**
     * Metodo para escribir un archivo con la respuesta
     *
     * @param  numeroDeAbejas  Numero de abejas del conjunto de datos original
     */

    public void guardarArchivo( int numeroDeAbejas){
        final String nombreDelArchivo = "respuestaConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";  
        try {
            PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
            escritor.println("Coordenadas de abejas que colisionan");
            escritor.println("Coordenada x          " + "Coordenada y          "+ "Coordenada z"+ "\n");
            for(int i=0;i< conjuntoDeAbejas.length;i++){
                for(int j=0;j< conjuntoDeAbejas[0].length;j++){
                    for(int k=0;k<conjuntoDeAbejas[0][0].length;k++){
                        if(conjuntoDeAbejas[i][j][k]!=null && conjuntoDeAbejas[i][j][k].size()>1){
                            imprimirPila(conjuntoDeAbejas[i][j][k], escritor);
                        }
                    }
                }
            }
            for(int a=0;a<adyacentes.size();a++){
                Abeja aux= adyacentes.get(a);
                escritor.println(cont + " " +aux.getX() + "         " + aux.getY() + "         " + aux.getZ()+ "\n");
                cont++;

            }
            escritor.close();
        }
        catch(IOException ioe) {
            System.out.println("Error escribiendo el archivo de salida");
        } 
    }

}