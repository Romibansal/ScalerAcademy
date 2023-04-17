package LinkList_Basics;


//Q=Problem Description
//        Given heads of two linked lists A and B,
//        check if they are identical i.e. each of their corresponding nodes should contain the same data.
//        The two given linked lists may or may not be of the same length.
//
//        Problem Constraints
//        1 <= size of linked lists <= 10^5
//        1 <= value of each node <= 10^9

public class CompareLinkedList {
    public int solve(ListNode A, ListNode B) {
        ListNode temp1=A;
        ListNode temp2=B;
        while(temp1!=null){
            if(temp1.val!=temp2.val){
                return 0;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        if(temp1==null && temp2!=null){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        CompareLinkedList I = new CompareLinkedList();
        ListNode A=new ListNode(4);
        ListNode A1=new ListNode(3);
        ListNode A2=new ListNode(2);
        ListNode A3=new ListNode(1);

        ListNode A4=new ListNode(4);
        ListNode A5=new ListNode(2);
        ListNode A6=new ListNode(3);
        ListNode A7=new ListNode(1);
        A.next=A1;A1.next=A2;A2.next=A3;
        A4.next=A5;A5.next=A6;A6.next=A7;

        System.out.println( I.solve(A,A4));
    }
}


