import java.util.*;
/**
 * smartInsert
 * 
 * @author Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio
 * @version October 2018
 */
public class mainSmartInsert
{
    public List SmartInsert(List list, int data)
    {
        if(!(list.contains(data)))
        {
            list.add(data);
            return list;
        }
        return list;
    }
}

