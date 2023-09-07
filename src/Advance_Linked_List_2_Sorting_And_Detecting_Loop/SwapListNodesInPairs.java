package Advance_Linked_List_2_Sorting_And_Detecting_Loop;

//Q=Problem Description
//        Given a linked list A, swap every two adjacent nodes and return its head.
//
//        NOTE: Your algorithm should use only constant space.
//        You may not modify the values in the list; only nodes themselves can be changed.
//
//
//        Problem Constraints
//        1 <= |A| <= 10^6


//Example Input
//        Input 1:
//        A = 1 -> 2 -> 3 -> 4

//        Input 2:
//        A = 7 -> 2 -> 1
//
//
//        Example Output
//        Output 1:
//        2 -> 1 -> 4 -> 3

//        Output 2:
//        2 -> 7 -> 1

public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode A) {
        if(A==null || A.next==null){
            return A;
        }
        ListNode ans=null;
        ListNode head=null;
        ListNode temp=A.next.next;
        head=A.next;
        head.next=A;
        A.next=null;
        ans=head;
        while(temp!=null && temp.next!=null){
            ListNode temp1=temp.next.next;
            ListNode tempnext=temp.next;
            tempnext.next=temp;
            head.next.next=tempnext;
            temp.next=null;
            head=tempnext;
            temp=temp1;
        }
        if(temp!=null ){
            if(temp.next==null) {
                head.next.next = temp;
                temp.next = null;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        SwapListNodesInPairs I = new SwapListNodesInPairs();
        ListNode A=new ListNode(1);
        A.next=new ListNode(2);
        A.next.next=new ListNode(3);
        A.next.next.next=new ListNode(4);
        A.next.next.next.next=new ListNode(5);
        A.next.next.next.next.next=new ListNode(6);
        System.out.println(I.swapPairs(A));
    }
}

