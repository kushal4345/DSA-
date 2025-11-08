package Tree;
import java.util.*;
public class PrintRootToLeafPaths {
    private static void dfs(Node root, StringBuilder path, List<String> res) {
        if (root == null) return;

        int len = path.length();

        if (path.length() != 0) path.append("->");
        path.append(root.val);

        if (root.left == null && root.right == null) {
            res.add(path.toString());
        } else {
            dfs(root.left, path, res);
            dfs(root.right, path, res);
        }

        path.setLength(len);
    }
    public static  List<String> binaryTreePaths(Node root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, new StringBuilder(), res);
        return res;
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
        System.out.println(binaryTreePaths(root));
    }
}
