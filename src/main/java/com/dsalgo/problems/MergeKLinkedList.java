package com.dsalgo.problems;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLinkedList {


    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

       ListNode dummy = new ListNode(0);
       ListNode head=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            head.next=queue.poll();
            head=head.next;

            if (head.next!=null)
                queue.add(head.next);
        }
        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
}
