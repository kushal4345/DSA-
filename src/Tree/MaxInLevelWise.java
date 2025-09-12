package Tree;
import java.util.*;

public class MaxInLevelWise {

    static void max(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int n = q.size();
            while(n!=0){
                Node x = q.remove();
               max= Math.max(max,x.val);
               if(x.left!=null) q.add(x.left);
               if(x.right!=null) q.add(x.right);
               n--;
            }
            System.out.println(max);
        }

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
        max(root);
    }
}
