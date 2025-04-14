package interviewQA.LinkedList;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode newHead = reverseListOptimised(head);
        if(n == 1){
            newHead = newHead.next;
            return reverseListOptimised(newHead);
        }
        ListNode temp = newHead;
        ListNode prev = null;
        int k = 0;
        while(temp != null){
            k++;
            if(k == n){
                prev.next = temp.next;
                temp.next = null;
            }
            prev = temp;
            temp = temp.next;
        }
        return reverseListOptimised(newHead);
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

    public ListNode removeNthFromEndOptimised(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return head;
        }
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
