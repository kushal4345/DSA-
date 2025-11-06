package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelByLevel {
    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();

            while(n!=0){
                Node elem = q.remove();
                System.out.print(elem.val + " ");
                if(elem.left!=null) q.add(elem.left);
                if(elem.right!=null) q.add(elem.right);

                n--;
            }
            System.out.println();
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
        levelOrder(root);
    }
}
