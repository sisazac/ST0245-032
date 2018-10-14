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

    public Node search(Node node, String name){
        if(node != null){
            return null;
        }else{
            if(node.data.equals(name)){
                return node;
            }
            left=search(node.left, name);
            if(left!=null){
                return left;
            }
            right=search(node.right,name);
            if(right!=null){
                return right;   
            }
            return null;
        }
    }

    
    /*public String grandma(String name){
      *  Node relative= search(root, name);
      *  if(relative!=null){
      *      relative=relative.left;
      *      if(relative!=null){
      *          if(relative!=null){
      *              relative=relative.;
      *         }
      *      }
      *      
      *  }
      */

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