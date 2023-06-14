package Advance_Linked_List_Intro;

//Q=Problem Description
//        You are given a singly linked list having head node A.
//        You have to reverse the linked list and return the head node of that reversed list.
//
//        NOTE: You have to do it in-place and in one-pass.
//
//        Problem Constraints
//        1 <= Length of linked list <= 10^5
//
//        Value of each node is within the range of a 32-bit integer.




public class ReverseLinkedList {
    public ListNode reverseList(ListNode A) {
        if(A.next==null){
            return A;
        }
        ListNode prev=null;
        ListNode curr=A;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList I = new ReverseLinkedList();
        ListNode b = new ListNode(3) ;
        ListNode a = new ListNode(2) ;
        ListNode A=new ListNode(1);
        A.next=a;
        a.next=b;

        System.out.println(I.reverseList(A));
    }
}

