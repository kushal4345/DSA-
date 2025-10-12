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
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);

        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);
        int targetSum  = 22;
       boolean result =  sum(root,targetSum );
        System.out.println(result);
    }
}
