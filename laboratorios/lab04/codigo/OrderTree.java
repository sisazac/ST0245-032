
import java.util.Arrays;
public class OrderTree {
    public Node root;
    public void insertar(int[] data) {
        root= new Node(data[0]);
        for(int i=1;i<data.length;i++){
            insertarAux(root,data[i]);
        }
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     */
    private void insertarAux(Node node, int n) {
        if(n<node.data && node.left==null){
            Node left= new Node(n);
            node.left=left;
        }else if(n<node.data){
            insertarAux(node.left, n);
        }else if(n>node.data && node.right==null){
            Node right= new Node(n);
            node.right=right;
        }else if(n>node.data){
            insertarAux(node.right, n);
        }
    }

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

    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            System.out.println(node.data);
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
        }

    }

    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }

}