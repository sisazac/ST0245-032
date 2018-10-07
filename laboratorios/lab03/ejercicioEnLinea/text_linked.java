
import java.util.*;

/**
 *Text
 * 
 * @author Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio 
 * @version October 2018
 */
public class text_linked
{
    public static String pc(String str){
        List<String> list = new LinkedList<>();
        boolean start= true;
        int index=0;
        String newString="";
        for(int i=0;i<str.length()-1;i++){
            if(str.substring(i,i+1).equals("[")){
                start=true;
                index=0;
            }
            else if(str.substring(i,i+1).equals("]")){
                start=false;
            }else if(!str.substring(i,i+1).equals("[") && !str.substring(i,i+1).equals("]")){
                if(start){
                    list.add(index,str.substring(i,i+1));
                    index++;
                }else{
                    list.add(str.substring(i,i+1));
                }
            }
        }
        
        for(int i=0;i<list.size();i++){
            newString= newString+list.get(i);
        }
        
        return newString;
    }
}
