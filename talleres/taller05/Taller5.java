
/**

 * La clase Taller4 tiene la intención de resolver el taller número 4.

 *

 * @author Mauricio Toro, Andres Paez

 * @version 1

 */
import java.util.concurrent.TimeUnit;
public class Taller5{
    
    public static void main(String[] args){
        for (int i = 10000000; i <= 200000000; i = i + 10000000){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            suma(a);
            long fin = System.currentTimeMillis();       
            System.out.println(fin-start);
        }
    }

    public static int suma(int[] a){
        int suma = 0; // c_1
        for(int i = 0; i < a.length; i++) // c2 + sum c3, i=0 to n
            suma += a[i];  //sum c4, i=0 to n-1
        return suma; //c5
    }


    /**

     * @param num es el numero el cual se utiliza para ser multiplicado.

     * El método mul tiene la intención de hacer la multiplicación

     * de 1 a n por el numero mul

     * mediante una funcion cíclica (while/for/...)

     * 

     */

    public static void mul (int num){
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
                System.out.println(i +" * "+ j + " = "+ i*j);
            }
        }
    }

    /**

     * @param array es un arreglo de números desordenados

     * El método insertionSort tiene la intención ordenar los números

     * del arreglo array por el método insertion:

     * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>

     * mediante la anidación de funciones cíclicas (while/for/...)

     * 

     */

    //public static int[] insertionSort (int[] array){

    //...

}    

