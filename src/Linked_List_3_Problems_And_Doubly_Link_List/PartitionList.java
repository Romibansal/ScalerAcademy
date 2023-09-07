package Linked_List_3_Problems_And_Doubly_Link_List;

//Q=Problem Description
//        Given a linked list A and a value B, partition it such that all nodes less than B come
//        before nodes greater than or equal to B.
//
//        You should preserve the original relative order of the nodes in each of the two partitions.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10^6
//
//        1 <= A[i], B <= 10^9


//Example Input
//        Input 1:
//        A = [1, 4, 3, 2, 5, 2]
//        B = 3

//        Input 2:
//        A = [1, 2, 3, 1, 3]
//        B = 2
//
//Example Output
//        Output 1:
//        [1, 2, 2, 4, 3, 5]

//        Output 2:
//        [1, 1, 2, 3, 3]

public class PartitionList {
    public ListNode partition(ListNode A, int B) {
        if(A==null || A.next==null){
            return A;
        }
        ListNode head2=null;
        ListNode less=null;
        ListNode prev=null;
        ListNode curr=A;
        ListNode head=A;
        while(curr!=null){
            if(curr.val<B){
                if(head2==null){
                    less=curr;
                    head2=curr;
                }
                else{
                    less.next=curr;
                    less=curr;
                }
                if(prev==null){
                    head=head.next;
                }
                else{
                    prev.next=curr.next;
                }

            }
            else{
                prev=curr;
            }

            curr=curr.next;
        }
        if(less==null){
            return head;
        }
        less.next=head;
        return  head2;
    }
    public static void main(String[] args) {
        PartitionList I = new PartitionList();
        ListNode A=new ListNode(1);
        A.next=new ListNode(2);
        A.next.next=new ListNode(3);
        A.next.next.next=new ListNode(4);
        A.next.next.next.next=new ListNode(5);
        //A.next.next.next.next.next=new ListNode(2);

        System.out.println(I.partition(A,1));
    }
}



