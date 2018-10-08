import java.util.*;
/**
 * Mall
 * 
 * @author Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio
 * 
 * @version September 2018
 */
public class Mall
{
    static Stack<Fridge> fridges=new Stack<>();
    static Queue<Order> orders=new LinkedList();
    static int size= orders.size();
    public static void addFridge(Fridge fridge){
        fridges.push(fridge);
    }

    public static void addOrder(Order order){
       orders.add(order);
    }

    public static void service(){
        for(int i=0;i<size;i++){
            Order order = orders.remove();
            int n=order.getNumber();
            System.out.print(order.getName() + " :");
            while(size!=0 && fridges.size()!=0){
                Fridge temp= fridges.pop();
                System.out.println("The code is: "+ temp.getCode()+"and the data: "+temp.getData());
                System.out.println("--------------------------");
                n--;
            }
        }
    }
}
