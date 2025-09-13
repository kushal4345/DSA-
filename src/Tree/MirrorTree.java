package Tree;
// concept -> only swap left and right part
public class MirrorTree {
    static void Mirror(Node root){
        if(root==null) return ;
        Node x = root.left;
        root.left = root.right;
        root.right = x;

        Mirror(root.left);
        Mirror(root.right);
        System.out.println(root.val);
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
        Mirror(root);
    }
}

