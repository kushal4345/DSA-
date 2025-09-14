package Tree;

import java.sql.SQLOutput;

public class SymmetricTree {
    static boolean isSame(Node p,Node q ){
        if (p == null && q == null) return true;   // both empty → same
        if (p == null || q == null) return false;  // one empty, one not → different
        if (p.val != q.val) return false;


        return isSame(p.left, q.right) && isSame(q.left, p.right);
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

      boolean Ans = isSame(root.left,root.right);
        System.out.println("Is Symmetric -> "+ Ans);
    }

}
