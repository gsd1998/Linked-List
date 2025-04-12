package interviewQA.LinkedList;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class ReverseADLL {
    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 4};
        Node head = convertArr2DLL(arr);
        System.out.println("Doubly Linked List Initially:  ");
        printLL(head);
        System.out.println("Doubly Linked List After Reversing :");
        head = reverseDLL(head);
        printLL(head);

    }

    private static Node reverseDLL(Node head) {
        Node last = null;
        Node current = head;
        while(current != null){
            last = current.prev;
            current.prev = current.next;
            current.next = last;
            current = current.prev;
        }
        return last != null ? last.prev : null;
    }

    private static void printLL(Node head) {
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node convertArr2DLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1; i <= arr.length-1; i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

}
