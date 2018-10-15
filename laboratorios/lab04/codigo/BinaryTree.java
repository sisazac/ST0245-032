public class BinaryTree {
    public Node root;
    public Node relative;
    public Node left;
    public Node right;
    public BinaryTree(){
        root = null;
    }

    private int max2(int i, int j)
    {
        if (i > j)
            return i;
        return j;
    }

    public String search(Node node, String name){
        if(node!= null){
            if(node.data.equals(name)){
                if(node.left.left!= null) return node.left.left.data;
            }else{
                search(node.left,name);
                search(node.right,name);
            }
        }
        return "Not found";
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