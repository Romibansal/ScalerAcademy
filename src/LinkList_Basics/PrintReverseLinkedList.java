package LinkList_Basics;

//Q=Problem Description
//        You are given a singly linked list having head node A. You need to print the linked list in reverse order.
//
//        Note :- The node values must be space separated. You must give a newline after printing all the nodes.
//
//
//
//        Problem Constraints
//        1 <= Length of linked list <= 10^5
//        1 <= Value of each linked list node <= 10^9



public class PrintReverseLinkedList {
    public void solve(ListNode A) {
        ListNode temp=A;
        if(temp==null){
            return;
        }
        solve(temp.next);
        System.out.print(temp.val+" ");
        if(A==temp){
            System.out.println();
        }
    }
    public static void main(String[] args) {
        PrintReverseLinkedList I = new PrintReverseLinkedList();
        ListNode A=new ListNode(5);
        ListNode A1=new ListNode(10);
        ListNode A2=new ListNode(12);
        ListNode A3=new ListNode(4);
        ListNode A4=new ListNode(17);
//        ListNode A5=new ListNode(8);
//        ListNode A6=new ListNode(7);
//        ListNode A7=new ListNode(3);
//        ListNode A8=new ListNode(7);
        A.next=A1;A1.next=A2;A2.next=A3;A3.next=A4;
        //A4.next=A5;A5.next=A6;A6.next=A7;A7.next=A8;

       I.solve(A);
    }
}

