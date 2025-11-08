package Tree;
import java.util.*;
public class BottomUpTraversal {
    public static  List<List<Integer>> levelOrderBottom(Node root) {

        Queue<Node> q = new LinkedList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(n!=0){
                Node a = q.remove();
                list.add(a.val);
                if(a.left!=null) q.add(a.left);
                if(a.right!=null) q.add(a.right);
                n--;
            }
            res.add(list);
        }
        Collections.reverse(res);

        return res;
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
        System.out.println( levelOrderBottom(root));
    }
}
