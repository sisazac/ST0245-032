import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * 
 * -Taken from: https://github.com/damesaa201710054010/ST0247-032/blob/master/laboratorios/lab01/ejercicioEnLinea/Ejercicio2.java
 * Authors: Mesa, Daniel
 * @version 1
 */
public class Exercise2
{
    /* Title: esColoreable
     * Authors: Mesa, Daniel
     * Date: October 22, 2018
     * Taken from:https:https://github.com/damesaa201710054010/ST0247-032/blob/master/laboratorios/lab01/ejercicioEnLinea/Ejercicio2.java
     */
    public boolean isColorable(int [][] graph)
    {   
        int [] Color = new int[graph.length];
        int i = 0;
        while(i < Color.length)
        {
            Color[i] = -1;
            i++;
        }
        Color[0] = 1;
        boolean is =  aux(graph, Color);
        return is? true : false;
    }

    /* Title: aux
     * Authors: Mesa, Daniel
     * Date: October 22, 2018
     * Taken from:https:https://github.com/damesaa201710054010/ST0247-032/blob/master/laboratorios/lab01/ejercicioEnLinea/Ejercicio2.java
     */
    private boolean aux(int [][] graph, int [] color)
    {
        Stack<Integer> round =  new Stack<>();
        round.push(0);
        while(round.size() != 0)
        {
            int actual = round.pop();
            if(graph[actual][actual] == 1) return false;
            for(int i = 0; i < graph.length; i++)
            {
                if(graph[actual][i] == 1 && color[i] == -1)
                {
                    color[i] = 1-color[actual];
                    round.push(i);
                }else if(graph[actual][i] == 1  && color[actual] == color[i]) return false;
            }
        }
        return true;
    }

    /* Title: esColoreable
     * Authors: Mesa, Daniel
     * Date: October 22, 2018
     * Taken from:https:https://github.com/damesaa201710054010/ST0247-032/blob/master/laboratorios/lab01/ejercicioEnLinea/Ejercicio2.java
     */
    public static void main(String[] args)
    {
        Exercise2 g = new Exercise2();
        Scanner console =  new Scanner(System.in);
        int vertices= console.nextInt();
        int cont = 1;
        int edges = 0;
        int origin = 0;
        int destiny = 0;
        while(vertices != 0)
        {
            edges = console.nextInt();
            int [][] graph = new int[vertices][vertices];
            cont = 1;
            while(cont <= edges)
            {
                origin = console.nextInt();
                destiny = console.nextInt();
                graph[origin][destiny] = 1;
                cont++; 
            }
            String res = g.isColorable(graph)? "BICOLORABLE" : "NOT BICOLORABLE";
            System.out.println(res);
            vertices = console.nextInt();
        }
    }
}