package interviewQA.LinkedList;

import java.util.HashMap;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            if(map.containsKey(temp)){
                return true;
            }
            map.put(temp,1);
            temp = temp.next;
        }
        return false;
    }

    public boolean hasCycleSlowAndFastPointers(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

}
