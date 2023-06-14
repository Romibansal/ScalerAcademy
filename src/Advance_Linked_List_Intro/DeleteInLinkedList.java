package Advance_Linked_List_Intro;

//Q=Problem Description
//        You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.
//
//        Note : Follow 0-based indexing for the node numbering.
//
//
//
//        Problem Constraints
//        1 <= size of linked list <= 10^5
//        1 <= value of nodes <= 10^9
//        0 <= B < size of linked list


public class DeleteInLinkedList {
    public ListNode solve(ListNode A, int B) {
        if(B==0){
            return A.next;
        }
        ListNode head=A;
        for(int i=0;i<B-1;i++){
            A=A.next;
        }
        A.next=A.next.next;
        return head;
    }
    public static void main(String[] args) {
        DeleteInLinkedList I = new DeleteInLinkedList();
        ListNode b = new ListNode(3) ;
        ListNode a = new ListNode(2) ;
        ListNode A=new ListNode(1);
        A.next=a;
        a.next=b;

        System.out.println(I.solve(A,1));
    }
}


