package interviewQA.LinkedList;

public class LengthOfLoopInLL {

    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode collision = slow;
                slow = head;
                int steps = 0;
                while(slow != fast){
                    steps++;
                    slow = slow.next;
                    fast = fast.next;
                }
                while(slow != collision){
                    steps++;
                    slow = slow.next;
                }
                return steps;
            }
        }
        return 0;
    }
}
