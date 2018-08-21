
/**
 * Write a description of class Punto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto1
{
    /**
     * @param array es un arreglo de números desordenados
     * El método insertionSort tiene la intención ordenar los números
     * del arreglo array por el método insertion:
     * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
     * mediante la anidación de funciones cíclicas (while/for/...)
     * 
     */
    public static int[] insertionSort (int[] array){
        for(int a=0;a<array.length;a++){
            int menor= a;
            for(int b=a+1;b<array.length;b++){
                if(array[b]< array[menor]){
                    menor= b;
                }
            }
            int aux= array[a];
            array[a]= array[menor];
            array[menor]= aux;

        }
        return array;
    }    
}
