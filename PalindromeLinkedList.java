package interviewQA.LinkedList;

import java.util.Stack;
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.val != stack.pop()){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public boolean isPalindromeOptimised(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseSLL(slow.next);
        ListNode first = head;
        ListNode second = newHead;
        while(second != null){
            if(first.val != second.val){
                reverseSLL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseSLL(newHead);
        return true;
    }

    private ListNode reverseSLL(ListNode head){
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

}
