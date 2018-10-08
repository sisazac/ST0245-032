import java.util.*;



public class smartInsertV2{

    public static List<Integer> list;

    public int size;

    public smartInsertV2()

    {

        size = list.size();

    }



    public static void smartInsert(List<Integer> list, int data){

        int index= list.size();

        int n=0;

        boolean ok=true;

        try{

            for(int i=0;i<index;i++){

                n = list.get(i);

                if(data==n){

                    System.out.println("Sorry mate that is the wrong number");

                    System.out.print("The last number of the array is: " + list.get(list.size()-1));

                    ok = false;

                    break;

                }

            }

            if(ok==true){

                list.add(data);

                System.out.println("The last number added is: "+ list.get(list.size()-1));

            }

        }catch(Exception e){

            System.out.println("Not allowed value");

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

        array.addAll(Arrays.asList(new Integer[] {2, 4, 6, 8}));

        smartInsert(array, 5);

        ArrayList<Integer> array2 = new ArrayList<>();

        array2.addAll(Arrays.asList(new Integer[] {3, 5, 6, 7, 8, 9}));

        smartInsert(array2, 9);

    }

}