
/**
 * Write a description of class Mul here.
 * 
 * @author Santiago Isaza Cadavid y Hamilton Smith Gómez Osorio
 * @version Agosto 2018
 */
public class Punto3
{
    public static void main(String[] args){
        for (int i = 10000; i <= 2000000; i = i + 10000){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            mul(i);
            long fin = System.currentTimeMillis();       
            System.out.println(fin-start);
        }
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
                //System.out.println(i +" * "+ j + " = "+ i*j);
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