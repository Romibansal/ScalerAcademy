package Linked_List_3_Problems_And_Doubly_Link_List;

//Q=Problem Description
//        Write a program to find the node at which the intersection of two singly linked lists,
//        A and B, begins. For example, the following two linked lists:
//
//        A:           a1 → a2
//                            ↘
//                              c1 → c2 → c3
//                            ↗
//        B:      b1 → b2 → b3

//        NOTE:
//
//        If the two linked lists have no intersection at all, return null.
//        The linked lists must retain their original structure after the function returns.
//        You may assume there are no cycles anywhere in the entire linked structure.
//        Your code should preferably run in O(n) time and use only O(1) memory.
//        The custom input to be given is different than the one explained in the examples. Please be careful.
//
//
//        Problem Constraints
//        0 <= |A|, |B| <= 10^6



class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if(B==null || A==null){
            return null;
        }
        ListNode head1=A;
        ListNode head2=B;
        int length1=0;
        while(head1!=null){
            length1++;
            head1=head1.next;

        }
        int length2=0;
        while(head2!=null){
            length2++;
            head2=head2.next;
        }
        head1=A;
        head2=B;
        int move=0;
        if(length2>length1){
            move=length2-length1;
            for(int i=0;i<move;i++){
                head2=head2.next;
            }
        }
        else{
            move=length1-length2;
            for(int i=0;i<move;i++){
                head1=head1.next;
            }
        }
        while(head1!=null && head2!=null){
            if(head1==head2){
                return head1;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return null;
    }
    public static void main(String[] args) {
        IntersectionOfLinkedLists I = new IntersectionOfLinkedLists();
        ListNode A=new ListNode(1);
        ListNode A1=new ListNode(2);
        ListNode A2=new ListNode(3);
        ListNode A3=new ListNode(4);
        ListNode A4=new ListNode(5);
        ListNode B=new ListNode(6);
        A.next=A1;
        A1.next=A2;
        A2.next=A3;
        A3.next=A4;
        B.next=A2;


        System.out.println(I.getIntersectionNode(A,B));
    }
}


