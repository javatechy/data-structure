package linkedlist;

/**
 * @author deepak
 */
public class CreateLinkedList {

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.head = new LinkedList.Node(1);
        LinkedList.Node second = new LinkedList.Node(2);
        LinkedList.Node third = new LinkedList.Node(3);
        llist.head.next = second; //
        second.next = third;
        printLinkedList(llist.head);
    }

    static void printLinkedList(LinkedList.Node head) {
        LinkedList.Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
}

class LinkedListl {

    Node head; // head of list

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }
}
