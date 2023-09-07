package Advance_Linked_List_2_Sorting_And_Detecting_Loop;

//Q=Problem Description
//        You are given two linked lists, A and B, representing two non-negative numbers.
//
//        The digits are stored in reverse order, and each of their nodes contains a single digit.
//
//        Add the two numbers and return it as a linked list.
//
//
//
//        Problem Constraints
//        1 <= |A|, |B| <= 10^5

//
//Example Input
//        Input 1:
//        A = [2, 4, 3]
//        B = [5, 6, 4]
//        Input 2:
//        A = [9, 9]
//        B = [1]
//Example Output
//        Output 1:
//        [7, 0, 8]
//        Output 2:
//        [0, 0, 1]


public class AddTwoNumbersAsLists {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode head=null;
        ListNode ans=null;
        int carry=0;
        while(A!=null && B!=null){
            int sum=A.val+B.val+carry;
            int number=sum%10;
            carry=sum/10;
            ListNode temp=new ListNode(number);
            if(head==null){
                head=temp;
                ans=temp;
            }
            else{
                head.next=temp;
                head=temp;
            }
            A=A.next;
            B=B.next;
        }
        if(A==null){
            while(B!=null){
                int sum=B.val+carry;
                int number=sum%10;
                carry=sum/10;
                ListNode temp=new ListNode(number);
                head.next=temp;
                head=temp;
                B=B.next;
            }
        }
        if(B==null){
            while(A!=null){
                int sum=A.val+carry;
                int number=sum%10;
                carry=sum/10;
                ListNode temp=new ListNode(number);
                head.next=temp;
                head=temp;
                A=A.next;
            }
        }
        if(carry>0){
            head.next=new ListNode(carry);
        }
        return ans;
    }
    public static void main(String[] args) {
        AddTwoNumbersAsLists I = new AddTwoNumbersAsLists();
        ListNode A=new ListNode(9);
        A.next=new ListNode(9);
        A.next.next=new ListNode(9);
        ListNode B=new ListNode(1);
//        B.next=new ListNode(6);
//        B.next.next=new ListNode(4);

        System.out.println(I.addTwoNumbers(B,A));
    }
}

