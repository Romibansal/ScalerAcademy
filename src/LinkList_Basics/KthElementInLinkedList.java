package LinkList_Basics;

//Q=Problem Description
//        You are given the head of a linked list A and an integer B. You need to find the B-th element of the linked list.
//
//        Note : Follow 0-based indexing for the node numbering.
//
//
//
//        Problem Constraints
//        1 <= size of linked list <= 10^5
//
//        1 <= value of nodes <= 10^9
//
//        0 <= B < size of linked list



public class KthElementInLinkedList {
    public int solve(ListNode A, int B) {
        ListNode temp=A;
        for(int i=0;i<B;i++){
            temp=temp.next;
        }
        return temp.val;
    }
    public static void main(String[] args) {
        KthElementInLinkedList I = new KthElementInLinkedList();
        ListNode A=new ListNode(4);
        ListNode A1=new ListNode(3);
        ListNode A2=new ListNode(2);
        ListNode A3=new ListNode(1);
  //      ListNode A4=new ListNode(17);
//        ListNode A5=new ListNode(8);
//        ListNode A6=new ListNode(7);
//        ListNode A7=new ListNode(3);
//        ListNode A8=new ListNode(7);
        A.next=A1;A1.next=A2;A2.next=A3;
        //A3.next=A4;
        //A4.next=A5;A5.next=A6;A6.next=A7;A7.next=A8;

       System.out.println( I.solve(A,1));
    }
}


