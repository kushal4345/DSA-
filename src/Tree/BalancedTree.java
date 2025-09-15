package Tree;

public class BalancedTree {
    static int isBalanced(Node root , int valid){
        if(root==null) return 0;
        int left = isBalanced(root.left,valid);
        int right = isBalanced(root.right,valid);
        int abs = Math.abs(left-right);
        if(abs>1){
            valid = 0;
        }
        return 1+ Math.max(left,right);
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
        int valid = 1;
        isBalanced(root,valid);
         if(valid==0){
             System.out.println(false);
         }
         else{
             System.out.println(true);
         }

    }
}
