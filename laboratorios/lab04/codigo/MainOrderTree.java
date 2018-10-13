
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainOrderTree
{
    public static void main (String[]args){
        int[] test= {9,48,52,4,19,75,30,1,79,54};
        OrderTree tree= new OrderTree();
        tree.insertar(test);
        tree.recursivePrint();
        System.out.println("____________________________");
        tree.posOrderTree();
    }
}
