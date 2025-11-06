package Tree;


public class ExactOneChild {
    static int OneChild(Node root) {
        if (root == null) return 0;

        int count = 0;
        // if exactly one child exists
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            count = 1;
        }

        return count + OneChild(root.left) + OneChild(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        // connecting node
        root.left = b;
        b.left = c;
        c.left = d;
        root.right = e;
        e.left = f;
        f.right = g;

       int res =  OneChild(root);
        System.out.println(res);
    }
}
