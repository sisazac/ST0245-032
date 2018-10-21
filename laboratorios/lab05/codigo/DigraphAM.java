import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * 
 * @author Hamilton Gmez & Santiago Isaza- Plantilla de Mauricio Toro 
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