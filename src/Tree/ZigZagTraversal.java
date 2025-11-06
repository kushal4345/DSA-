package Tree;
import java.util.*;
public class  ZigZagTraversal {
    static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> list = new ArrayList<>();

            while (n != 0) {
                Node x = q.remove();
                if (x.left != null) {
                    q.add(x.left);
                }
                if (x.right != null) {
                    q.add(x.right);
                }
                list.add(x.val);
                n--;
            }

            if (reverse) {
                Collections.reverse(list);
            }
            ans.add(list);
            reverse = !reverse;
        }
        return ans;
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


        System.out.println(zigzagLevelOrder(root));
    }
}
