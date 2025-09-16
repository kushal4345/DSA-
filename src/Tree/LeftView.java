package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
   static void Lview(Node root){
       System.out.println("Left View ->");
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int i = n;
            while(n!=0){

                Node x = q.remove();
                if(n==i) {
                    System.out.print( x.val + " "); // print elem when first node will encounter
                }

                if(x.left!=null) q.add(x.left);
                if(x.right!=null) q.add(x.right);
                n--;
            }
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
        Lview(root);
    }
}
