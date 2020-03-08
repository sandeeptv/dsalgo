package com.test.example;

/**
 * Created by stuppad on 2/1/19.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode ll1 = new ListNode(1);
//        ListNode ll2 = new ListNode(8);
//        ll1.next = ll2;
//        ListNode ll3 = new ListNode(3);
//        ll2.next = ll3;


        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        l5.next = l6;
//        ListNode l7 = new ListNode(4);
//        l6.next = l7;

        ListNode listNode = addTwoNumbers.addTwoNumbers(ll1, l5);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}
