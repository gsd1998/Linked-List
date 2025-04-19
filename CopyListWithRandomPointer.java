package interviewQA.LinkedList;

import java.util.HashMap;

class NodeClone {
    int val;
    NodeClone next;
    NodeClone random;

    NodeClone() {
        this.val = 0;
        this.next = null;
        this.random = null;
    }
    NodeClone(int x) {
        this.val = x;
        this.next = null;
        this.random = null;
    }
    NodeClone(int x, NodeClone nextNode, NodeClone randomNode) {
        this.val = x;
        this.next = nextNode;
        this.random = randomNode;
    }
}

public class CopyListWithRandomPointer {
    public NodeClone copyRandomList(NodeClone head) {
        HashMap<NodeClone,NodeClone> map = new HashMap<>();
        NodeClone temp = head;
        while(temp != null){
            NodeClone newNode = new NodeClone(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            NodeClone copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
