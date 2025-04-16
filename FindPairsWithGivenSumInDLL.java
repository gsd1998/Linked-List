package interviewQA.LinkedList;

import java.util.ArrayList;

public class FindPairsWithGivenSumInDLL {
    public ArrayList<ArrayList<Integer>> deleteAllOccurrences(NodeDll head, int sum) {
        ArrayList<ArrayList<Integer>> parentList = new ArrayList<>();
        if(head == null){
            return parentList;
        }
        NodeDll left = head;
        NodeDll right = findTail(head);
        while(left.data < right.data){
            if(left.data + right.data == sum){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(left.data);
                list.add(right.data);
                parentList.add(list);
                left = left.next;
                right = right.prev;
            }else if(left.data + right.data > sum){
                right = right.prev;
            }else{
                left = left.next;
            }
        }
        return parentList;
    }

    private NodeDll findTail(NodeDll head) {
        NodeDll tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
    }
}
