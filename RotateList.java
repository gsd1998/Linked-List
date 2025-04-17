package interviewQA.LinkedList;

public class RotateList {

    //this method won't work for all cases
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode temp = head;
        ListNode tempLen = head;
        int count = 0;
        int len = 0;
        while(tempLen != null){
            len++;
            tempLen = tempLen.next;
        }

        k = k % len;
        while(temp != null){
            count++;
            if(count == k){
                break;
            }
            temp = temp.next;
        }
        ListNode kthNode = temp.next;
        ListNode secondHead = kthNode.next;
        kthNode.next = null;
        ListNode firstHead = head;

        ListNode newFirsttHead = reverse(firstHead);
        ListNode newSecondHead = reverse(secondHead);
        firstHead.next = newSecondHead;
        ListNode newHead = reverse(newFirsttHead);
        return newHead;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode frontNode = head.next;
        frontNode.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode rotateRightOptimised(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        k = k % len;
        if(k == 0){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(k != 0){
            k--;
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode tail = slow;
        ListNode rotatedHead = slow.next;
        tail.next = null;
        fast.next = head;
        return  rotatedHead;
    }
}
