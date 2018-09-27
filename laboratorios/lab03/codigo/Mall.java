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
    static ArrayList<Fridge> fridges=new ArrayList<>();
    static ArrayList<Order> orders=new ArrayList();
    static int sizeO= orders.size();
    static int sizeF= fridges.size();
    public static void addFridge(Fridge fridge){
        for(int i= sizeF-1;i>=0;i--){
            fridges.set(i+1, fridges.get(i));
        }
        fridges.add(0,fridge);
    }

    public static void addOrder(Order order){
        orders.add(order);
    }

    public static void service(){
        for(int i=0;i<sizeO;i++){
            Order order = orders.get(i);
            int n=order.getNumber();
            System.out.print(order.getName() + " :");
            while(sizeO!=0 && fridges.size()!=0){
                Fridge temp= fridges.pop();
                System.out.println("The code is: "+ temp.getCode()+"and the data: "+temp.getData());
                System.out.println("--------------------------");
                n--;
                
            }
        }
    }
}
