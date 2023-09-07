package Advance_Linked_List_2_Sorting_And_Detecting_Loop;

//Q=Problem Description
//        Merge two sorted linked lists, A and B, and return it as a new list.
//
//        The new list should be made by splicing together the nodes of the first
//        two lists and should also be sorted.
//
//        Problem Constraints
//        0 <= |A|, |B| <= 10^5

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode ans=null;
        if(A==null){
            return B;
        }
        if(B==null){
            return A;
        }
        if(A.val<B.val){
            ans=A;
            A=A.next;
        }
        else{
            ans=B;
            B=B.next;
        }
        ListNode head=ans;
        while(A!=null && B!=null){
            if(A.val<B.val){
                head.next=A;
                A=A.next;
            }
            else{
                head.next=B;
                B=B.next;
            }
            head=head.next;
        }
        if(A==null){
            head.next=B;
        }
        else{
            head.next=A;
        }
        return ans;

    }
    public static void main(String[] args) {
        MergeTwoSortedLists I = new MergeTwoSortedLists();
        ListNode A=new ListNode(5);
        A.next=new ListNode(8);
        A.next.next=new ListNode(20);
        ListNode B=new ListNode(4);
        B.next=new ListNode(11);
        B.next.next=new ListNode(15);

        System.out.println(I.mergeTwoLists(A,B));
    }
}
