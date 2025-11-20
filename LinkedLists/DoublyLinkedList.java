public class DoublyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    public void insertAtEnd(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        node.prev = current;
    }

    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void deleteNode(int key) {
        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            return; // Key not found
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next; // Deleting head node
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    public void reverseLinkedList() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        System.out.println("Doubly Linked List (forward):");
        list.displayForward(); // Output: 10 <-> 20 <-> 30 <-> null
        list.deleteNode(20);
        System.out.println("After deletion of 20:");
        list.displayForward(); // Output: 10 <-> 30 <-> null
        list.reverseLinkedList();
        System.out.println("After reversing the list:");
        list.displayForward(); // Output: 30 <-> 10 <-> null
    }
}