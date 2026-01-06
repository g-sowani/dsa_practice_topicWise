public class IterativeReverse {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

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
        return;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node();
    }
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while(current != null){
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
        
    }

    public static void main(String[] args) {
        IterativeReverse list = new IterativeReverse();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        System.out.println("Original Linked List:");
        list.display();
        Node reversedHead = list.reverse(list.head);
        System.out.println("Reversed Linked List:");
        list.head = reversedHead;
        list.display();
    }

}

