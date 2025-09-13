package Tree;
// this question can be done by 3 methods
// method 1
public class MaxNode {
    static int maxnode(Node root){
         if(root==null) return 0;
         int leftmax = maxnode(root.left);
         int rightmax = maxnode(root.right);
         int maxOfleftAndRight = Math.max(leftmax,rightmax);
         int max = Math.max(root.val,maxOfleftAndRight);
         return max; // return max element
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
        System.out.println(maxnode(root));
    }
}
