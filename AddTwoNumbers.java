package interviewQA.LinkedList;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        int carry = 0;
        ListNode t1 = l1;
        ListNode t2 = l2;
        while(t1 != null || t2 != null){
            int sum = carry;
            if(t1 != null){
                sum = sum + t1.val;
            }
            if(t2 != null){
                sum = sum + t2.val;
            }
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            curr.next = newNode;
            curr = newNode;
            if(t1 != null){
                t1 = t1.next;
            }
            if(t2 != null){
                t2 = t2.next;
            }
        }
        if(carry == 1){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        return dummyNode.next;
    }

}
