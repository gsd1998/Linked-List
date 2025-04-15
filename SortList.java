package interviewQA.LinkedList;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode tracker = head;
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        for(int i = 1; i <= len-1; i++){
            while(second != null && second != tracker){
                if(first.val > second.val){
                    swapNodes(first,second);
                }
                first = first.next;
                second = second.next;
            }
            tracker = first;
            first = head;
            second = head.next;
        }
        return head;
    }

    private void swapNodes(ListNode first , ListNode second){
        ListNode temp = new ListNode();
        temp.val = first.val;
        first.val = second.val;
        second.val = temp.val;
    }


    public ListNode sortListOptimised(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return mergeList(leftHead, rightHead);
    }

    public ListNode mergeList(ListNode leftHead, ListNode rightHead){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(leftHead != null && rightHead != null){
            if(leftHead.val <= rightHead.val){
                temp = leftHead;
                leftHead = leftHead.next;
            }else{
                temp.next = rightHead;
                temp = rightHead;
                rightHead = rightHead.next;
            }
        }
        if(leftHead != null){
            temp.next = leftHead;
        }
        if(rightHead != null){
            temp.next = rightHead;
        }
        return dummyNode.next;
    }
    public ListNode findMiddle(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null  && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
