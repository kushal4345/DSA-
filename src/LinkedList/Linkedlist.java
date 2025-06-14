package LinkedList;

public class Linkedlist {
  public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }

    }
    public class linkedlist{
      Node head;
      Node tail;

      void insertAt(int val){
          Node temp = new Node(val);
          if(head==null){
              head = temp;
              tail = temp;
          }
          else{
              tail.next = temp;
              tail = temp;
          }
      }
    }
}
