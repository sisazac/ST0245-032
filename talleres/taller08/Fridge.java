
/**
 * Fridge
 * 
 * @author Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio
 * @version September 2018
 */
public class Fridge
{
    public int code;
    public String data;  
    public Fridge(int code, String data){
        this.data=data;
        this.code=code;
    }

    public int getCode(){
        return code;
    }
    
    public String getData(){
        return data;
    }
}
