import java.util.*;
/**
 * balance
 * 
 * @author Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio 
 * @version October 2018
 */
public class balance
{
    public static void balance(ArrayList<Integer> numbers){
        int sum=0;    
        int aux=0;
        for(int i=0;i<=numbers.size();i++){
            sum+=i;
        }

        for(int i=0;i<numbers.size()-1;i++){
            aux+=numbers.get(i);
            if((sum/2)<=aux){
             System.out.println("The pivot should be on " + i+ " position.");
             break;
            }
        }
    }
    
        /**
     * Tests the methods.
     * @param args
     */
    public static void main(String[] args) {
        //LinkedList<Integer> linked= new LinkedList<>();
        //linked.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7}));
        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
        balance(array);
    }
}

