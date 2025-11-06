package Tree;

public class BuildTree {
    public static Node buildTree(int arr[] , int i ){
        if(i>=arr.length) return null;
        Node root = new Node(arr[i]);
        root.left = buildTree(arr,2*i+1);
        root.right = buildTree(arr,2*i+2);

        return root;

    }

    public static void inorder(Node root){
        if(root==null) return ;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int i = 0;
       Node root =  buildTree(arr,i);
       inorder(root);
    }
}
