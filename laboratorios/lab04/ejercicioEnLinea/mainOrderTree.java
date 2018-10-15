
/**
 * Main
 *
 * @author  Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio
 * @version (a version number or a date)
 */
public class mainOrderTree
{
    public static void main (String[]args){
        int[] test= {9,48,52,4,19,75,30,1,79,54};
        orderTree tree= new orderTree();
        tree.insertar(test);
        tree.recursivePrint();
        System.out.println("____________________________");
        tree.posOrderTree();
    }
}