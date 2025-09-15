package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinNode {
    static boolean isCousin(Node root, int e, int f) {
        if (root == null) return false;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            boolean foundE = false, foundF = false;

            for (int i = 0; i < n; i++) {
                Node curr = q.poll();


                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == e && curr.right.val == f) ||
                            (curr.left.val == f && curr.right.val == e)) {
                        return false;
                    }
                }


                if (curr.val == e) foundE = true;
                if (curr.val == f) foundF = true;

                // Push children into queue
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }


            if (foundE && foundF) return true;
            if (foundE || foundF) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node b = new Node(2);
        Node c = new Node(9);
        Node d = new Node(2);
        Node e = new Node(7);
        Node f = new Node(6);

        root.left = b;
        root.right = c;
        c.left = d;
        d.right = e;
        b.left = f;

        System.out.println(isCousin(root, 6, 2));
    }
}
