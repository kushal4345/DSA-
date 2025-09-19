package Tree;

import java.util.Stack;

public class IterativePreorder {

    static void Itpre(Node root){
        Stack<Node> st = new Stack<>();

        st.add(root);
        while(!st.isEmpty()){
           Node x =  st.pop();
            System.out.println(x.val);
            if(x.right!=null) st.add(x.right);
           if(x.left!=null) st.add(x.left);
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
        Itpre(root);
    }
}
