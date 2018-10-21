import java.util.ArrayList;

/**
 * This class is an implementation of digraphs using adjacency matrix
 * @author Hamilton Gómez and Santiago Isaza-Mauricio Toro’s Template
 * @version 1
 */
public class DigraphAM extends Graph
{
    int [][] matriz;
    public DigraphAM(int size)
    {
        super(size);
        matriz = new int[size][size];
    }

    public int getWeight(int source, int destination)
    {
        return matriz[source][destination];
    }

    public void addArc(int source, int destination, int weight)
    {
        matriz[source][destination]=weight;
    }

    public ArrayList<Integer> getSuccessors(int vertex)
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i<size; i++) {
            if(matriz[vertex][i] != 0) {
                a.add(i);
            }
        }
        return a;
    }
}