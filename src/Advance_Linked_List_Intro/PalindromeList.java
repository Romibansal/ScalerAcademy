package Advance_Linked_List_Intro;

//Q=Problem Description
//        Given a singly linked list A, determine if it's a palindrome. Return 1 or 0,
//        denoting if it's a palindrome or not, respectively.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10^5



public class PalindromeList {
    public int lPalin(ListNode A) {
        if(A.next==null){
            return 1;
        }
        ListNode prev=null;
        ListNode curr=null;
        ListNode head=A;
        ListNode superslow=null;
        ListNode slow=A;
        ListNode fast =A;
        while(fast!=null && fast.next!=null){
            superslow=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        superslow.next=null;
        if(fast!=null){
            curr=slow.next;
        }
        else{
            curr=slow;
        }
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        while(head!=null){
            if(head.val!= prev.val){
                return 0;
            }
            head=head.next;
            prev=prev.next;
        }

        return 1;
    }
    public static void main(String[] args) {
        PalindromeList I = new PalindromeList();
        ListNode A=new ListNode(1);
        A.next=new ListNode(2);
        A.next.next=new ListNode(3);
        A.next.next.next=new ListNode(4);
        A.next.next.next.next=new ListNode(4);
        A.next.next.next.next.next=new ListNode(3);
        A.next.next.next.next.next.next=new ListNode(2);
        A.next.next.next.next.next.next.next=new ListNode(1);

        System.out.println(I.lPalin(A));
    }
}



