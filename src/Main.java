public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(new Node(5));
        tree.insert(new Node(2));
        tree.insert(new Node(6));
        tree.insert(new Node(8));
        tree.insert(new Node(3));
        tree.insert(new Node(4));
        tree.insert(new Node(9));


        System.out.println(tree.search(2));
        tree.delete(2);
        tree.delete(4);
        tree.delete(2);
        tree.display();
    }
}