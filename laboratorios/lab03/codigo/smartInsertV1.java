import java.util.*;

public class smartInsert{
    private static Node first;
    private  static int size;
    private static LinkedList<Integer> linked;
      public smartInsert()
    {
        first = null;	
    }
    
    public static void smartInsert(LinkedList L, int data){
        int index= L.size()-1;
        //try{
            for(int i=0;i<index;i++){
                if(data != get(i)){
                    Node currentLast= getNode(index);
                    Node last= new Node(data);
                    currentLast.next= last;
                }
            }
        //}catch(Exception e){
        //    System.out.println("Not allowed value");
        //}

    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public static int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private static Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < linked.size()) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Tests the methods.
     * @param args
     */
    public static void main(String[] args) {
        linked.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7}));
        smartInsert(linked, 3);
        //ArrayList<Integer> array = new ArrayList<>();
        //array.addAll(Arrays.asList(new Integer[] {2, 4, 6, 8}));

    }
}