public class BinaryTree {
    public Node root;
    public Node family;
    public BinaryTree(){
        root = null;
    }

    private int max2(int i, int j)
    {
        if (i > j)
         return i;
        return j;
    }

    public void search(Node node, String name){
        if(node != null){
            if(node.data.equals(name)){
                family = node;
            }
        }
        search(node.left, name);
        search(node.right, name);
    }
    
    private int maxheightAUX(Node node)
    {
        if (node == null)
            return 0;
        else {
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
        }
    }

    public int maxheight()
    {
        return maxheightAUX(root);
    }

    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }
    }

    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }
}