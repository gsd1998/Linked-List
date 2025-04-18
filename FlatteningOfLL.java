package interviewQA.LinkedList;

class NodeFlat {
    int val;
    NodeFlat next;
    NodeFlat child;

    NodeFlat() {
    }
    NodeFlat(int val) {
        this.val = val;
    }
    NodeFlat(int val, NodeFlat next, NodeFlat child) {
        this.val = val;
        this.next = next;
        this.child = child;
    }
}

public class FlatteningOfLL {

    public NodeFlat flattening(NodeFlat head) {
        if(head == null || head.next == null){
            return head;
        }
        return createSortedList(head);
    }

    private NodeFlat createSortedList(NodeFlat head) {
        if(head == null || head.next == null){
            return head;
        }
        NodeFlat newMergedHead = createSortedList(head.next);
        head = mergeList(head,newMergedHead);
        return head;
    }

    private NodeFlat mergeList(NodeFlat list1, NodeFlat list2) {
        NodeFlat dummyNode = new NodeFlat(-1);
        NodeFlat temp = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.child = list1;
                temp = list1;
                list1 = list1.child;
            }else{
                temp.child = list2;
                temp = list2;
                list2 = list2.child;
            }
            temp.next = null;
        }
        if(list1 != null){
            temp.child = list1;
        }else {
            temp.child = list2;
        }
        return dummyNode.child;
    }
}
