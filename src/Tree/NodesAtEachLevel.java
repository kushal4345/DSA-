package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class NodesAtEachLevel {
    public static List countNodes(List<Integer> list ,Node root){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int count =0;
            while(n!=0){
                count++;

                Node elem = q.remove();
                if(elem.left!=null) q.add(elem.left);
                if(elem.right!=null) q.add(elem.right);
                n--;

            }
            list.add(count);
            count = 0;
        }
        return list;
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
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(countNodes(list ,root));
    }
}
