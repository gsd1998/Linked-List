package interviewQA.LinkedList;

public class DeleteTheMiddleNodeOfALinkedList {

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevOfSlow = null;
        while(fast !=null && fast.next != null){
            prevOfSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevOfSlow.next = prevOfSlow.next.next;
        return head;
    }

    public ListNode deleteMiddleSkippingSlowBy1Step(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
