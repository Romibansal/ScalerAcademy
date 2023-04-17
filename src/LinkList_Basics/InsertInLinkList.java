package LinkList_Basics;

//Q=Problem Description
//        You are given A which is the head of a linked list.
//        Also given is the value B and position C.
//        Complete the function that should insert a new node with the said value at the given position.
//
//        Notes:
//        In case the position is more than length of linked list, simply insert the new node at the tail only.
//        In case the pos is 0, simply insert the new node at head only.
//        Follow 0-based indexing for the node numbering.
//
//
//        Problem Constraints
//        1 <= size of linked list <= 10^5
//        1 <= value of nodes <= 10^9
//        1 <= B <= 10^9
//        0 <= C <= 10^5




class ListNode {
     public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
public class InsertInLinkList {
    public ListNode solve(ListNode A, int B, int C) {
        ListNode l=new ListNode(B);
        if(C==0){
            l.next=A;
            A=l;
            return A;
        }
        ListNode temp=A;
        for(int i=0;i<C-1;i++){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        l.next=temp.next;
        temp.next=l;
        return A;
    }
        public static void main(String[] args) {
            InsertInLinkList I = new InsertInLinkList();
            ListNode A=new ListNode(6);
            ListNode A1=new ListNode(3);
            ListNode A2=new ListNode(3);
            ListNode A3=new ListNode(6);
            ListNode A4=new ListNode(7);
            ListNode A5=new ListNode(8);
            ListNode A6=new ListNode(7);
            ListNode A7=new ListNode(3);
            ListNode A8=new ListNode(7);
            A.next=A1;A1.next=A2;A2.next=A3;A3.next=A4;A4.next=A5;A5.next=A6;A6.next=A7;A7.next=A8;
            System.out.println(I.solve(A,3,5));
        }
    }
