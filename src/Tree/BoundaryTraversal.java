package Tree;

import java.util.*;

public class BoundaryTraversal {
    static void left(Node root , HashMap<Integer,Integer> map){
        if(root==null)  return;
        if(!map.containsKey(root.val)){
            System.out.println(root.val);
            map.put(root.val,1);
        }
        left(root.left,map);
        left(root.right,map);
    }

    static void level(Node root , HashMap<Integer,Integer> map){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(!map.containsKey(curr.val)){
                System.out.println(curr.val);
                map.put(curr.val,1);
            }
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
    }

    static void right(Node root , HashMap<Integer,Integer> map){
        if(root==null)  return;
        right(root.left,map);
        right(root.right,map);
        if(!map.containsKey(root.val)){
            System.out.println(root.val);
            map.put(root.val,1);
        }
    }

    public static void main(String args[]){
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        Node g = new Node(8);
        Node h = new Node(9);
        Node i = new Node(10);
        Node j = new Node(11);

        root.left = a;
        root.right = f;
        a.left = b;
        b.right = c;
        c.left = d;
        c.right = e;
        f.right = g;
        g.left = h;
        h.left = i;
        h.right = j;

        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.println(root.val);
        map.put(root.val,1);
        left(root.left , map);
        level(root , map);
        right(root.right , map);
    }
}
