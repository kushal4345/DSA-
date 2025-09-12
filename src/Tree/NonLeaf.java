package Tree;

public class NonLeaf {

    static  int nonleaf(Node root){
        int count =0;
        if(root==null) return 0;
        if(root.left!=null||root.right!=null){
            count++;

        }
        count+=nonleaf(root.left);
        count+=nonleaf(root.right);
        return count;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node b = new Node(2);
        Node c = new Node(9);
        Node d = new Node(2);
        Node e = new Node(7);
        Node f = new Node(6);
        Node g = new Node(5);

        root.left = b;
        root.right = c;
        c.left = d;
        d.right = e;
        b.left = f;
        System.out.println(nonleaf(root));
    }
}
