public class LinkedList {
    // define head of the list
    private Node head;

    // define node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // to insert at end -
    // a. if list is empty - insert as head
    // b. else find last node and insert after it
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void deleteNode(int key) {
        Node current = head, prev = null;

        // if head node itself holds the key to be deleted
        if (current != null && current.data == key) {
            head = current.next; // Changed head
            return;
        }

        // search for the key to be deleted, keep track of the previous node
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // if key was not present in linked list
        if (current == null)
            return;

        // unlink the node from linked list
        prev.next = current.next;
    }

    // tracerse list and print each node - data
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void length() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Length of the list: " + count);
    }

    public int search(int key) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == key) {
                return position;
            }
            position++;
            current = current.next;
        }
        return -1; // key not found
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(0);
        list.display(); // Output: 0-> 10 -> 20 -> 30 -> null
        list.deleteNode(0);
        list.display();
        list.length();
        System.out.println("Index of 20 is : " + list.search(20));
    }
}
