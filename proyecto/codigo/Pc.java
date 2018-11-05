
/**
 * Write a description of class Pc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pc
{
   public static void detectarColisiones(Abeja[] arregloDeAbejas){
        Abeja aux = null;
        int x; // C
        int y; // C
        int z; // C
        for (int i = 0; i < arregloDeAbejas.length ; ++i) //C*n
        {
            aux = arregloDeAbejas[i]; //C*n
            x = (int)( ( (aux.getX()-AuxminX)*111111)/ (100/(Math.sqrt(3))) ); //C*n
            y = (int)( ( (aux.getY()-AuxminY) *111111) / (100/(Math.sqrt(3)))); //C*n
            z = (int)((aux.getZ()-AuxminZ) / (100/(Math.sqrt(3)))); //C*n
            if(x>0)x--; //C*n
            if(y>0)y--; //C*n
            if(z>0)z--; //C*n
            if(conjuntoDeAbejas[x][y][z]== null){ //C*n
                Stack<Abeja> colision= new Stack<>(); //C*n
                colision.push(aux); //C*n
                conjuntoDeAbejas[x][y][z]=colision; //C*n
            }else{ //C*n
                conjuntoDeAbejas[x][y][z].push(aux); //C*n
            }
        }
    } 
}
