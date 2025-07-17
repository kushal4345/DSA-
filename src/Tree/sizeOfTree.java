package Tree;

public class sizeOfTree {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){  // constructor
            this.val =val;
        }
    }
    public  static int size(Node root){
        if(root==null) return 0;

        return 1 + size(root.left) + size(root.right); // return the size of left tree and right
    }
    public  static void main(String args[]){
        Node root = new Node(3);
        Node a = new Node(4);
        Node b = new Node(5);
        Node c = new Node(8);
        Node d = new Node(3);
        Node e = new Node(7);
        Node f = new Node(2);
        root.left = a;   // building a tree
        root.right = b;
        a.left = c;
        a.right = d;
        b.left= e;
        b.right = f;
        int SizeOfTree = size(root); // return the size of the array
        System.out.println(SizeOfTree);
    }
}
