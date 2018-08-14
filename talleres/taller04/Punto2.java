/**
 *La clase Taller4 dos tiene como objetivo dar solución al taller4
 *
 *@autor Mauricio Toro, Camilo Paez
 *@version 1
 */
import java.util.concurrent.TimeUnit;
public class Punto2 {
    public static void main(String[] args){
        for (int i = 1; i <= 20; i++){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            sumaGrupo(0,a,i);
            long fin = System.currentTimeMillis();    
            System.out.println(fin-start);
        }
    }

    public static boolean sumaG(int[]a, int r){
        return sumaGrupo(0,a,r);

    }

    /**
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param array es un arreglo de numeros enteros, representan volumen
     * @param target es la meta, el numero que debe alacanzar la suma 
     *
     * en este método se busca hacer la suma de los volumnes posibles
     * de modo que se acomode de tal forma que se alcance el valor target
     * pista: la clave esta en el numero de elementos y que no siempre se toman
     * los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
     * target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
     *
     *
     * @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
     */
    public static boolean sumaGrupo(int start, int[] nums, int target) {
        if(start>= nums.length) return target==0;
        try{ 
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e){ 
        }
        return sumaGrupo(start+1, nums, target - nums[start]) || sumaGrupo(start+1, nums, target);
    }

}