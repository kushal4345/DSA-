package Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class IdenticalTree {

    public static void check(TreeNode q1, Queue<Integer> queue) {
        if (q1 == null) {
            queue.add(null); // Store null explicitly
            return;
        }

        queue.add(q1.val);
        check(q1.left, queue);
        check(q1.right, queue);
    }

    public static void main(String[] args) {
        // Sample trees
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        check(root1, q1);
        check(root2, q2);

        System.out.println(q1);
        System.out.println(q2);

        System.out.println(q1.equals(q2)); // Compare both queues if identical then return true else false
    }
}
