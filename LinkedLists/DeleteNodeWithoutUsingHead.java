public class DeleteNodeWithoutUsingHead {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertAtEnd(int data) {
        Node node = new Node(data);
        Node current = head;
        if (head == null) {
            head = node;
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public void deleteNode(int key) {
        Node node = head;
        while (node != null && node.data != key) {
            node = node.next;
        }
        if (node == null || node.next == null) {
            System.out.println("Cannot delete the given node.");
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DeleteNodeWithoutUsingHead list = new DeleteNodeWithoutUsingHead();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        System.out.println("Before deletion:");
        list.display(); // Output: 10 -> 20 -> 30 -> null
        list.deleteNode(20);
        System.out.println("\nAfter deletion:");
        list.display();
    }

}
