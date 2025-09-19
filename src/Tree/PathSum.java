package Tree;

public class PathSum {
    static boolean sum(Node root,int targetSum){
        if(root==null) return false;
        if(root.left==null&&root.right==null){
            if(targetSum==root.val){
                return true;
            }
        }
        return sum(root.left,targetSum-root.val)||sum(root.right,targetSum - root.val);
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
        int targetSum  = 3;
       boolean result =  sum(root,targetSum );
        System.out.println(result);
    }
}
