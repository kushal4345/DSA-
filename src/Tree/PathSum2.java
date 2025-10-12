package Tree;
import java.util.*;


public class PathSum2 {

    static List<List<Integer>> sum(Node root, int targetSum, List<List<Integer>> list, List<Integer> temp) {
        if (root == null) return list;

        // Add current node
        temp.add(root.val);

        // If leaf node and path sum matches
        if (root.left == null && root.right == null && targetSum == root.val) {
            list.add(new ArrayList<>(temp)); // add a copy of temp
        } else {
            // Recurse left and right
            sum(root.left, targetSum - root.val, list, temp);
            sum(root.right, targetSum - root.val, list, temp);
        }

        // Backtrack (remove last added element)
        temp.remove(temp.size() - 1);
        return list;
    }

    public static void main(String[] args) {
        // Level 1
        Node root = new Node(5);

        // Level 2
        root.left = new Node(4);
        root.right = new Node(8);

        // Level 3
        root.left.left = new Node(11);
        root.right.left = new Node(13);
        root.right.right = new Node(4);

        // Level 4
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);

        int targetSum = 22;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        System.out.println(sum(root, targetSum, list, temp));
    }
}
