package Linked_List_3_Problems_And_Doubly_Link_List;

//Q=Problem Description
//        You are given a linked list A
//        Each node in the linked list contains two pointers: a next pointer and a random pointer
//        The next pointer points to the next node in the list
//        The random pointer can point to any node in the list, or it can be NULL
//        Your task is to create a deep copy of the linked list A
//        The copied list should be a completely separate linked list from the original list,
//        but with the same node values and random pointer connections as the original list
//        You should create a new linked list B, where each node in B has the same value as
//        the corresponding node in A
//        The next and random pointers of each node in B should point to the corresponding
//        nodes in B (rather than A)
//
//
//        Problem Constraints
//        0 <= |A| <= 10^6
//
//Example Input
//        Given list
//        1 -> 2 -> 3
//        with random pointers going from
//        1 -> 3
//        2 -> 1
//        3 -> 1
//
//
//
//        Example Output
//        1 -> 2 -> 3
//        with random pointers going from
//        1 -> 3
//        2 -> 1
//        3 -> 1




class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }
public class CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode A=head;
        while(A!=null){
            RandomListNode temp=new RandomListNode(A.label);
            RandomListNode t=A.next;
            A.next=temp;
            temp.next=t;
            A=A.next.next;
        }
        RandomListNode temp=head;
        while(temp!=null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp=temp.next.next;
        }
        RandomListNode t1 = head;
        RandomListNode t2 = head.next;

        RandomListNode newHead = head.next;

        while( t1 != null){
            RandomListNode t1p1 = null;

            if( t1 != null && t1.next != null){
                t1p1 = t1.next.next;
            }

            RandomListNode t2p1 = null;

            if( t2 != null && t2.next != null){
                t2p1 = t2.next.next;
            }

            t1.next = t1p1;
            t2.next = t2p1;

            t1 = t1p1;
            t2 = t2p1;
        }

        return newHead;
    }
    public static void main(String[] args) {
        CopyList I = new CopyList();
        RandomListNode A=new RandomListNode(1);
        RandomListNode A1=new RandomListNode(2);
        RandomListNode A2=new RandomListNode(3);
        RandomListNode A3=new RandomListNode(4);
        A.next=A1;
        A1.next=A2;
        A2.next=A3;
        A.random=A2;
        A1.random=A;
        A2.random=A;
        A3.random=A2;

        System.out.println(I.copyRandomList(A));
    }
}

