package interviewQA.LinkedList;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while(temp != null){
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode != null){
                nextNode = kthNode.next;
                kthNode.next = null;
                ListNode newHead = reverseList(temp);
                if(temp == head){
                    head = newHead;
                }else{
                    prevNode.next = kthNode;
                }
                prevNode = temp;
                temp = nextNode;
            }else{
                prevNode.next = nextNode;
                break;
            }
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode frontNode = head.next;
        frontNode.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode findKthNode(ListNode head, int k) {
        int cnt = 0;
        ListNode temp = head;
        while(temp != null){
            cnt++;
            if(cnt == k){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
}
