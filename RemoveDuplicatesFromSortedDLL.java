package interviewQA.LinkedList;

public class RemoveDuplicatesFromSortedDLL {

    public NodeDll removeDuplicatesKeepOne(NodeDll head) {
        if(head == null || head.next == null){
            return head;
        }
        NodeDll temp = head;
        NodeDll newNode = head.next;
        while(newNode != null){
            while (temp.data == newNode.data) {
                newNode = newNode.next;
            }
            temp.next = newNode;
            if(newNode !=null)
                newNode.prev = temp;
            temp = temp.next;
            if(temp != null)
                newNode = temp.next;
        }
        return head;
    }
}
