package Tree;

import java.util.*;

public class heightOfTree {
    static int height(Node root){
        if(root==null) return 0;
      int left =   height(root.left);
       int right =  height(root.right);
        return 1 + (Math.max(left,right));
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
        System.out.println(height(root));
    }
}
