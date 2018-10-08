import java.util.*;

/* Title: PosicionOptima
 * Authors: Arango, Isabella and Rengifo, Juan David
 * Date: October 7, 2018
 * Taken from:https:https://github.com/iarangor1/ST0245-032/blob/master/laboratorios/lab03/codigo/Lab03.java
 */
public class pivot
{
    public static void PosicionOptima(List<Integer> a, int data){
        int size= a.size();
        System.out.println("La lista es: " + a);
        int count=0;
        for(int i=0; i<=size; i++){
            count+=a.get(i);
        }
        int mitad1=count/2;
        int count2=0; 
        int posmax=0;
        for(int j=0; j<=size; j++){
            count2+=a.get(j);
            if(count2>mitad1){
                posmax=j-1;
                break;
            }
        }
        System.out.println("El pivote debe de ir en la posicion: " + posmax);
    }
}
