package interviewQA.LinkedList;

import java.util.Stack;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    public ListNode reverseListOptimised(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public ListNode reverseListUsingRecursion(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode frontNode = head.next;
        frontNode.next = head;
        head.next = null;
        return newHead;
    }
}
