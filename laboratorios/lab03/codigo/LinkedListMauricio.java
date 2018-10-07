import java.lang.IndexOutOfBoundsException; 



public class LinkedListMauricio{
    private Node first;
    private int size;
    public LinkedListMauricio()
    {
        size = 0;
        first = null;	
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
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
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    public int size()
    {
        return size;
    }

    public void insert(int data, int index)
    {
        try{
            if(index==0){
                Node temp= first.next;
                Node new1= new Node(data);
                temp.prev = new1;
                first= new1;
                size++;
            }else if(index>0){
                Node temp= getNode(index-1);
                Node new1= new Node(data);
                temp.next= new1;
                new1.prev= temp;
                size++;
            }
        }catch(Exception e){
            System.out.println("Not allowed value");
        }
    }
    
    public void remove(int index){
        try{
            if(index==size){
                Node temp= getNode(index-1);
                temp.prev.next= null;
                size--;
            }else if (index==0){
                Node temp= first.next;
                first= temp;
                first.prev=null;
                size--;
            }else if(index>0 && index<size-1){
                Node temp= getNode(index-1);
                temp.prev.next= temp.next;
                temp.next.prev=temp.prev;
                size--;
            }
        }catch(Exception e){
            System.out.println("Not allowed value");
        }
    }
    
    public boolean contains(int data) {
        try{
            Node currentNode = first;
            while (currentNode != null) {
                if (currentNode.data == data){
                    return true;
                }
                currentNode = currentNode.next;
            }
        }catch(Exception e){
            System.out.println("Not allowed valude");
        }
        return false;
    }
}