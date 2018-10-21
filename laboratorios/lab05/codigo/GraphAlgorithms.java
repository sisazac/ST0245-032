import java.util.ArrayList;

/**
 * @author Hamilton Gómez and Santiago Isaza
 * @version October 2018
 */
public class GraphAlgorithms
{
    public int MaxSuccessors(Graph successors, int vertice){
        ArrayList<Integer> a= successors.getSuccessors(vertice);
        int max= successors.getSuccessors(a.get(0)).size();
        for(int i=1;i<a.size();i++){
            int aux=successors.getSuccessors(i).size();
            if(aux>max) max= aux;
        }
        return max;
    }
}