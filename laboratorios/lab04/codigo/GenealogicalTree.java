
/**
 * Write a description of class GenealogicalTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GenealogicalTree
{
    public NodeFam root= new NodeFam ("Hamilton");
    public void fatherFam(){
        root.right= new NodeFam ("Nelson");
        root.right.right= new NodeFam ("Horacio");
        root.right.left= new NodeFam ("Caridad");
        root.right.right.right= new NodeFam ("Pedro");
        root.right.right.left= new NodeFam ("María");
        root.right.left.right= new NodeFam ("Alberto");
        root.right.left.left= new NodeFam ("Carla");
    }
    
    public void motherFam(){
        root.left= new NodeFam ( "Elizabeth");
        root.left.right= new NodeFam ("Eduardo");
        root.left.left= new NodeFam ("Nicolasa");
        root.left.right.right= new NodeFam ("Jairo");
        root.left.right.left= new NodeFam ("Leonilde");
        root.left.left.right= new NodeFam ("Jose Mario");
        root.left.left.left= new NodeFam ("Laura");
    }
}
