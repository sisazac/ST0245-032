import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 * This class is an implementation of digraphs using adjacency lists
 * 
 * @author Hamilton Gómez and Santiago Isaza
 * -Taken from: https://github.com/iarangor1/ST0245-032/blob/master/talleres/taller11/DigraphAL.java
 * Authors: Arango, Isabella and Rengifo, Juan David
 * - Mauricio Toro’s Template
 * @version 1
 */
public class DigraphAL extends Graph
{
    ArrayList<LinkedList<Pair1>> list = new ArrayList<>();
    public DigraphAL(int size)
    {
        super(size);
        for(int i=0; i<size;i++){
            list.add(new LinkedList());
        }
    }

    public void addArc(int source, int destination, int weight)

    {
        Pair1 pair = new Pair1(destination, weight);
        LinkedList<Pair1> a = list.get(source);
        a.add(pair);
        list.add(source, a);
    }

    public int getWeight(int source, int destination)

    {
        LinkedList<Pair1> a = list.get(source);
        for(int i=0;i<a.size();i++){
            if(a.get(i).vertice == destination){
                return a.get(i).weight;
            }
            break;
        }
        return 0;
    }

    public ArrayList<Integer> getSuccessors(int vertice)
    {
        LinkedList<Pair1> a = list.get(vertice);
        ArrayList<Integer>successors = new ArrayList<>();
        for(int i=0; i<a.size();i++){
            if(a.get(i).weight!=0){
                successors.add(a.get(i).vertice);
            }
        }
        return successors;
    }
}