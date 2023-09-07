package Advance_Linked_List_2_Sorting_And_Detecting_Loop;

//Q=Problem Description
//        Given a linked list of integers, find and return the middle element of the linked list.
//
//        NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
//
//
//
//        Problem Constraints
//        1 <= length of the linked list <= 100000
//
//        1 <= Node value <= 10^9

class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
}

public class MiddleElementOfLinkedList {
    public int solve(ListNode A) {
        ListNode slow=A;
        ListNode fast=A;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.val;
    }
    public static void main(String[] args) {
        MiddleElementOfLinkedList I = new MiddleElementOfLinkedList();
        ListNode A=new ListNode(1);
        A.next=new ListNode(5);
        A.next.next=new ListNode(6);
        A.next.next.next=new ListNode(2);
        A.next.next.next.next=new ListNode(3);
        A.next.next.next.next.next=new ListNode(4);

        System.out.println(I.solve(A));
    }
}
