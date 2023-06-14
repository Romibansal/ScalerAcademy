package Advance_Linked_List_Intro;

//Q=Problem Description
//        Given a singly linked list A and an integer B, reverse the nodes of
//        the list B at a time and return the modified linked list.
//
//
//        Problem Constraints
//        1 <= |A| <= 10^3
//
//        B always divides A

//Input 1:
//
//        A = [1, 2, 3, 4, 5, 6]
//        B = 2
//        Input 2:
//
//        A = [1, 2, 3, 4, 5, 6]
//        B = 3
//
//
//        Example Output
//        Output 1:
//
//        [2, 1, 4, 3, 6, 5]
//        Output 2:
//
//        [3, 2, 1, 6, 5, 4]
//
//
//        Example Explanation
//        Explanation 1:
//
//        For the first example, the list can be reversed in groups of 2.
//        [[1, 2], [3, 4], [5, 6]]
//        After reversing the K-linked list
//        [[2, 1], [4, 3], [6, 5]]


public class KreverseLinkedList {
    public ListNode reverseList(ListNode A, int B) {
        if(B==0 || B==1){
            return A;
        }
        int flag=0;
        ListNode tt=null;
        ListNode ans=null;
        ListNode head=A;
        while(A!=null){
            ListNode tail=null;
            ListNode temptail=null;
            int flag1=0;
            for(int i=0;i<B;i++){
                if(i==B-1){
                    A=head.next;
                }
                ListNode temp=head.next;
                head.next=tail;
                tail=head;
                head=temp;
                if(flag1==0){
                    temptail=tail;
                    flag1=1;
                }
            }
            if(flag==0){
                ans=tail;
                flag=1;
                tt=temptail;
            }
            else{
                tt.next=tail;
                tt=temptail;
            }
        }
        return  ans;
    }
    public static void main(String[] args) {
        KreverseLinkedList I = new KreverseLinkedList();
        ListNode A=new ListNode(1);
        A.next=new ListNode(2);
        A.next.next=new ListNode(3);
        A.next.next.next=new ListNode(4);
        A.next.next.next.next=new ListNode(5);
        A.next.next.next.next.next=new ListNode(6);
        A.next.next.next.next.next.next=new ListNode(7);
        A.next.next.next.next.next.next.next=new ListNode(8);
        A.next.next.next.next.next.next.next.next=new ListNode(9);
        System.out.println(I.reverseList(A,3));
    }
}



