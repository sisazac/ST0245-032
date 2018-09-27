import java.util.*;
/**
 * Mall
 * 
 * @author Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio
 * @version September 2018
 */
public class Mall
{
    static Stack<Fridge> fridges=new Stack<>();
    static Queue<Order> orders=new LinkedList();
    public static void addFridge(Fridge fridge){
        fridges.push(fridge);
    }

    public static void addOrder(Order order){
       orders.add(order);
    }

    public static void service(){
        int size=orders.size();
        for(int i=0;i<size;i++){
            Order order = orders.remove();
            int n=order.getNumber();
            System.out.print(order.getName() + " :");
            while(n!=0 && fridges.size()!=0){
                Fridge temp= fridges.pop();
                System.out.print(" "+temp.getCode()+"-"+temp.getData()+",");
                n--;
            }
            System.out.println();
            if(fridges.size()==0){
                System.out.println("No more fridges");
                break;
            }
        }
    }
}
