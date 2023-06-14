package Advance_Linked_List_Intro;

//Q=Problem Description
//        Given a linked list A, remove the B-th node from the end of the list and return its head.
//        For example, Given linked list: 1->2->3->4->5, and B = 2.
//        After removing the second node from the end, the linked list becomes 1->2->3->5.
//        NOTE: If B is greater than the size of the list, remove the first node of the list.
//        NOTE: Try doing it using constant additional space.
//
//
//        Problem Constraints
//        1 <= |A| <= 10^6


public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        int size=0;
        ListNode head=A;
        while(A!=null){
            size++;
            A=A.next;
        }
        int removing_position=size-B;
        if(removing_position==0 || removing_position<0){
            return head.next;
        }
        ListNode temphead=head;
        int flag=0;
        for(int i=0;i<removing_position-1;i++){
            temphead=temphead.next;
        }
        temphead.next=temphead.next.next;
        return head;
    }
    public static void main(String[] args) {
        RemoveNthNodeFromListEnd I = new RemoveNthNodeFromListEnd();
        ListNode d = new ListNode(5) ;
        ListNode c = new ListNode(4) ;
        ListNode b = new ListNode(3) ;
        ListNode a = new ListNode(2) ;
        ListNode A=new ListNode(1);
        A.next=a;
        a.next=b;
        b.next=c;
        c.next=d;

        System.out.println(I.removeNthFromEnd(A,12));
    }
}



