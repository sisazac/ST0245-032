
/**
 * PosOrder
 * 
 * @author Santiago Isaza Cadavid and Hamilton Smith Gómez Osorio 
 * @version October 2018
 */
public class PosOrder
{
    public Node root;
    
      public void posOrderTree(){
        posOrderTreeAux(root);
    }

    private void posOrderTreeAux(Node node){
        if(node!=null){
            posOrderTreeAux(node.left);
            posOrderTreeAux(node.right);
            System.out.println(node.data);
        }
    }
}
