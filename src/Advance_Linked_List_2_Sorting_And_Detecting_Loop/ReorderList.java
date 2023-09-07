package Advance_Linked_List_2_Sorting_And_Detecting_Loop;

//Q=Problem Description
//        Given a singly linked list A
//
//        A: A0 → A1 → … → An-1 → An
//        reorder it to:
//
//        A0 → An → A1 → An-1 → A2 → An-2 → …
//        You must do this in-place without altering the nodes' values.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10^6

//Example Input
//        Input 1:
//        A = [1, 2, 3, 4, 5]
//        Input 2:
//        A = [1, 2, 3, 4]
//
//        Example Output
//        Output 1:
//        [1, 5, 2, 4, 3]
//        Output 2:
//        [1, 4, 2, 3]


public class ReorderList {
    public ListNode reorderList(ListNode A) {
        if(A==null || A.next==null){
            return A;
        }
        ListNode slow=A;
        ListNode fast=A.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        ListNode head1=A;
        ListNode prev=null;
        ListNode curr=head2;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head2=prev;
        ListNode ans=head1;
        while(head2!=null){
            ListNode temp2=head2.next;
            ListNode temp1=head1.next;
            head1.next=head2;
            head2.next=temp1;
            head1=temp1;
            head2=temp2;
        }
        return ans;
    }
    public static void main(String[] args) {
        ReorderList I = new ReorderList();
        ListNode A=new ListNode(1);
        A.next=new ListNode(2);
        A.next.next=new ListNode(3);
        A.next.next.next=new ListNode(4);
        A.next.next.next.next=new ListNode(5);

        System.out.println(I.reorderList(A));
    }
}

