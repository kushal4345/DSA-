package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class OddNodes {
    static void Odd(Node root){
        Queue<Node> q = new LinkedList<>();
        int i = 1;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            while(n!=0){
                Node x = q.remove();
                if(i%2!=0){
                    System.out.println(x.val);
                }
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }

                n--;
            }
            i++;
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
        Odd(root);
    }
}
