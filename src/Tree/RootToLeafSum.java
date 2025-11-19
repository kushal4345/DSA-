package Tree;

// ---------- TreeNode Definition ----------


// ---------- Solution Class ----------
class RootToLeafSum {

    // Function returns sum of all root-to-leaf numbers
    public static  int rootToLeafSum(Node root, StringBuilder sb) {
        if (root == null) return 0;

        sb.append(root.val); // add digit
        int total = 0;

        // If leaf → convert SB to number and add to result
        if (root.left == null && root.right == null) {
            int num = Integer.parseInt(sb.toString());
            total = num;
        } else {
            // explore both sides
            total += rootToLeafSum(root.left, sb);
            total += rootToLeafSum(root.right, sb);
        }

        // backtracking
        sb.deleteCharAt(sb.length() - 1);

        return total;
    }

    public static int sumNumbers(Node root) {
        return rootToLeafSum(root, new StringBuilder());
    }
    public static void main(String[] args) {
        Node root = new Node(1);
         Node a = new Node(2 );
         Node b = new Node(3);
          root.left = a;
          root.right = b;


        int result = sumNumbers(root);

        System.out.println("Sum of all root-to-leaf numbers: " + result);
    }
}






