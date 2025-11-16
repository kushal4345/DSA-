package Tree;

public  class TransFormTreeSum {
    public static void toSumTree(Node root) {
        convert(root);
    }
   public static  int convert(Node root) {
        if (root == null) return 0;
        int oldValue = root.val;
        int leftSum = convert(root.left);
        int rightSum = convert(root.right);

        root.val = leftSum + rightSum;

        return root.val + oldValue;
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
        toSumTree(root);
    }
}
