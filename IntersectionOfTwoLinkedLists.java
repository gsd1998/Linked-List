package interviewQA.LinkedList;

import java.util.HashMap;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1 != null){
            t2 = headB;
            while(t2 != null){
                if(t1 == t2){
                    return t1;
                }
                t2 = t2.next;
            }
            t1 = t1.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeUsingHashing(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map = new  HashMap<>();
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1 != null){
            if(map.containsKey(t1)){
                return t1;
            }
            map.put(t1,t1.val);
            t1 = t1.next;
        }
        while(t2 != null){
            if(map.containsKey(t2)){
                return t2;
            }
            map.put(t2,t2.val);
            t2 = t2.next;
        }
        return null;
    }


    public ListNode getIntersectionNodeUsingLengthDiff(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode t1 = headA, t2 = headB;
        while (t1 != null) {
            len1++;
            t1 = t1.next;
        }
        while (t2 != null) {
            len2++;
            t2 = t2.next;
        }
        int diff = Math.abs(len1 - len2);
        ListNode pointer1 = headA;
        ListNode pointer2 = headB;
        if (len1 > len2) {
            for (int i = 0; i < diff; i++) {
                pointer1 = pointer1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                pointer2 = pointer2.next;
            }
        }
        while (pointer1 != null && pointer2 != null) {
            if (pointer1 == pointer2) return pointer1;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
            if(t1 == t2){
                return t1;
            }
            if(t1 == null){
                t1 = headB;
            }
            if(t2 == null){
                t2 = headA;
            }
        }
        return t1;
    }
}
