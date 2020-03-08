package com.dsalgo.problems.other;

public class LinkedListProb {


    public Node reverseLinkedList(Node head){
       Node currNode = head;
       Node revNode = null;

       while(currNode!=null){
           Node tempNode = currNode.getNext();
           currNode.setNext(revNode);
           revNode = currNode;
           currNode = tempNode;
       }
        return revNode;
    }

    public boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;
        if(fast !=null && fast.getNext()!=null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
