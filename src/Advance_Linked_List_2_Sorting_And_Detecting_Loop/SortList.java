package Advance_Linked_List_2_Sorting_And_Detecting_Loop;

//Q=Problem Description
//        Sort a linked list, A in O(n log n) time.
//
//
//
//        Problem Constraints
//        0 <= |A| = 10^5

public class SortList {
    ListNode merge(ListNode l,ListNode r){
        ListNode ans=null;
        if(l==null){
            return r;
        }
        if(r==null){
            return l;
        }
        if(l.val<r.val){
            ans=l;
            l=l.next;
        }
        else{
            ans=r;
            r=r.next;
        }
        ListNode head=ans;
        while(l!=null && r!=null){
            if(l.val<r.val){
                head.next=l;
                l=l.next;
            }
            else{
                head.next=r;
                r=r.next;
            }
            head=head.next;
        }
        if(l==null){
            head.next=r;
        }
        else{
            head.next=l;
        }
        return ans;
    }
    ListNode findmid(ListNode A){
        ListNode slow=A;
        ListNode fast=A.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        return head2;
    }
    public ListNode sortList(ListNode A) {
        if(A==null || A.next==null){
            return A;
        }
        ListNode head2 =findmid(A);
        ListNode left=sortList(A);
        ListNode right=sortList(head2);
        ListNode m=merge(left,right);
        return  m;
    }
    public static void main(String[] args) {
        SortList I = new SortList();
        ListNode A=new ListNode(5);
        A.next=new ListNode(4);
        A.next.next=new ListNode(3);
        A.next.next.next=new ListNode(2);
        A.next.next.next.next=new ListNode(1);

        System.out.println(I.sortList(A));
    }
}

