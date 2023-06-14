package Advance_Linked_List_Intro;

//Q=Problem Description
//        You are given A which is the head of a linked list. Also given is the value B and position C.
//        Complete the function that should insert a new node with the said value at the given position.
//
//        Notes:
//
//        In case the position is more than length of linked list, simply insert the new node at the tail only.
//        In case the pos is 0, simply insert the new node at head only.
//        Follow 0-based indexing for the node numbering.
//
//
//        Problem Constraints
//        1 <= size of linked list <= 10^5
//
//        1 <= value of nodes <= 10^9
//
//        1 <= B <= 10^9
//
//        0 <= C <= 10^5


class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

public class InsertInLinkedList {
    public ListNode solve(ListNode A, int B, int C) {
        int flag=0;
        if(C==0){
            ListNode head=new ListNode(B);
            head.next=A;
            return head;
        }
        ListNode head=A;
        for(int i=0;i<C-1;i++){
            if(A.next==null){
                flag=1;
                break;
            }
            A=A.next;
        }
        ListNode newnode =new ListNode(B);
        if(flag==1){
            A.next=newnode;
            return head;
        }

        ListNode temp=A.next;
        A.next=newnode;
        newnode.next=temp;
        return head;
    }

    public static void main(String[] args) {
        InsertInLinkedList I = new InsertInLinkedList();
        ListNode a = new ListNode(2) ;
        ListNode A=new ListNode(1);
        A.next=a;

        System.out.println(I.solve(A,3,1));
    }
}
