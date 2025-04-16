package interviewQA.LinkedList;

class NodeDll {
    int data;
    NodeDll next;
    NodeDll prev;

    NodeDll() {
    }
    NodeDll(int data) {
        this.data = data;
    }
    NodeDll(int data, NodeDll next, NodeDll prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class DeleteAllOccurrencesOfAKeyInDLL {
    public NodeDll deleteAllOccurrences(NodeDll head, int target){
        NodeDll temp = head;
        while(temp != null){
            if(temp.data == target){
                if(temp == head){
                    head = head.next;
                }
                NodeDll prevNode = temp.prev;
                NodeDll frontNode = temp.next;

                if(prevNode != null){
                    prevNode.next = frontNode;
                }
                if(frontNode != null){
                    frontNode.prev = prevNode;
                }
                temp = frontNode;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}
