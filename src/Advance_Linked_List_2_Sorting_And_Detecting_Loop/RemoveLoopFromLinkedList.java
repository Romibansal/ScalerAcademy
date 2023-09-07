package Advance_Linked_List_2_Sorting_And_Detecting_Loop;

//Q=Problem Description
//        You are given a linked list that contains a loop.
//        You need to find the node, which creates a loop and break it by making the node point to NULL.
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 1000



public class RemoveLoopFromLinkedList {
    public ListNode solve(ListNode A) {
        ListNode slow=A;
        ListNode ans=A;
        ListNode fast=A;
        ListNode superslow=null;
        while(fast!=null && fast.next!=null){
            superslow =slow;
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return ans;
        }
        ListNode x=ans;
        while(x!=slow){
            x=x.next;
            superslow=slow;
            slow=slow.next;
        }
        superslow.next=null;
        return ans;
    }
    public static void main(String[] args) {
        RemoveLoopFromLinkedList I = new RemoveLoopFromLinkedList();
        ListNode A=new ListNode(6);
        A.next=new ListNode(5);
        A.next.next=new ListNode(5);
        A.next.next.next=new ListNode(3);
        System.out.println(I.solve(A));
    }
}

