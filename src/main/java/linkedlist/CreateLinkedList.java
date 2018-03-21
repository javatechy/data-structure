package linkedlist;

import static linkedlist.LinkedList.Node;

/**
 * @author deepak
 */
public class CreateLinkedList {

    public static void main(String[] args) {
        /* Start with the empty list. */
        LinkedList llist = new LinkedList();
        llist.head = new Node(1);
        Node second = new Node(2);
        llist.head.next = second;
        Node third = new Node(3);
        llist.head.next.next = third;
        addANewElement(llist, 30);
        printLinkedList(llist.head);
    }

    static void printLinkedList(LinkedList.Node head) {
        LinkedList.Node n = head;
        while (n != null) {
            System.out.print(n.data + "  -> ");
            n = n.next;
        }
    }

    static void addANewElement(LinkedList llist, int newData) {
        Node node = new Node(30);
        node.next = llist.head;
        llist.head = node;
    }
}
