
/**
 *La clase Taller4 dos tiene como objetivo dar solución al taller4
 *
 *@autor Mauricio Toro, Camilo Paez
 *@version 1
 */
import java.util.concurrent.TimeUnit;
public class Punto3{
    public static void main(String[] args){
        for (int i = 1; i <= 20; i++){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            fibonacci(i);
            long fin = System.currentTimeMillis();    
            System.out.println(fin-start);
        }
    }

    public static long tFibon(long a){
        return fibonacci(a);

    }

    /**
     * @param array es un arreglo de numeros enteros
     * @param n la longitud del array anterior 
     *
     *en este método se busca hacer la suma de los numeros en un
     *arreglo de forma recursiva.
     *
     * @return la suma
     */
    public static int arrayMax(int[] array, int n) {
        if(n== array.length) return 0;
        else{
            try{
                TimeUnit.SECONDS.sleep(1);
                return array[n] + arrayMax(array,n+1);
            } catch(Exception e){

            }
        }
        return array[n] + arrayMax(array,n+1);
    }

    /**
     * @param n numero entero, hasta que numero se hace la serie
     *
     * el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
     * @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
     * @return el valor encontrado en long dada la posible cantidad de bits
     */
    public static long fibonacci(long n) { 
        if(n<=1)return n;
        try{ 
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e){
        } 
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
