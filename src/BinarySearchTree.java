public class BinarySearchTree {
    Node root;

    public void insert(Node node) {
    root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data= node.data;
        if (root == null) {
            root = node;
            return root;
        }
        else if(data<root.data){
            root.left=insertHelper(root.left,node);
        }
        else if(data>root.data){
            root.right=insertHelper(root.right,node);
        }
        return root;
    }
    public void display() {
        displayHelper(root);
    }
    private void displayHelper(Node root) {
    if (root!=null){
        displayHelper(root.left);
        System.out.println(root.data);
        displayHelper(root.right);
    }
    }
    public boolean search(int data) {

        return searchHelper(root,data);
    }
    private boolean searchHelper(Node root, int data) {
        if (root==null){
            return false;
        }
        else if(root.data==data){
            return true;
        }
        else if(root.data>data){
            return searchHelper(root.left,data);
        }
        else if(root.data<data){
            return searchHelper(root.right,data);
        }
        return false;
    }
    public void delete(int data) {
         if(search(data)){
             deleteHelper(root,data);
         }
         else{
             System.out.println(data+ " Element not found");
         }

    }
    public Node deleteHelper(Node root, int data) {
        if (root==null){
            return root;
        }
        else if(data<root.data){
            root.left=deleteHelper(root.left,data);
        }
        else if(data>root.data){
            root.right=deleteHelper(root.right,data);
        }
        else{//node found
            if(root.left==null && root.right==null){
                root=null;
            }
            else if (root.right !=null){//find successor to replace the node
                root.data=successor(root);
                root.right=deleteHelper(root.right,root.data);
            }
            else{//find predecessor to replace the node
                root.data=predecessor(root);
                root.left=deleteHelper(root.left,root.data);
            }

        }
        return null;
    }
    private int successor(Node root) {//find the minimum value in the right subtree
        root=root.right;
        while (root.left!=null){
            root=root.left;
        }
        return root.data;
    }
    private int predecessor(Node root) {//find the maximum value in the left subtree
        root=root.left;
        while (root.right!=null){
            root=root.right;
        }
        return root.data;
    }
}

