
/**
 * Order
 * 
 * @author  Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio
 * @version September 2018
 */
public class Order
{
    public int number;
    public String name;

    public Order(int number, String name){
        this.number=number;
        this.name=name;
    }

    public int getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }
}
